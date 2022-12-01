package com.Library.Library.manager;

import com.Library.Library.dao.entity.Book;
import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.entity.User;
import com.Library.Library.dao.repo.BorrowingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BorrowingManagerTest {

    @Mock
    private BorrowingRepo borrowingRepo;

    private BorrowingManager underTest;

    @BeforeEach
    void setUp() {
        underTest = new BorrowingManager(borrowingRepo);
    }

    @Test
    void shouldGetAllBorrowings() {
        //when
        underTest.findAll();

        //then
        verify(borrowingRepo).findAll();

    }

    @Test
    void shouldAddBorrowing() {
        //given
        Book book = new Book();
        User user = new User();
        Borrowing borrowing = new Borrowing(book, user);

        //when
        underTest.save(borrowing);

        //then
        ArgumentCaptor<Borrowing> argumentCaptor = ArgumentCaptor.forClass(Borrowing.class);
        verify(borrowingRepo).save(argumentCaptor.capture());
        Borrowing capturedBorrowing = argumentCaptor.getValue();
        assertThat(capturedBorrowing).isEqualTo(borrowing);
    }

    @Test
    void deleteById() {
        //given
        Book book = new Book();
        User user = new User();
        Borrowing borrowing = new Borrowing(book, user);
        borrowing.setId(10L);
        underTest.save(borrowing);

        //when
        underTest.deleteById(borrowing.getId());

        //then
        verify(borrowingRepo).deleteById(borrowing.getId());

    }

    @Test
    void shouldGetAllBorrowingsById(){
        //given
        Book book = new Book();
        User user = new User();
        Borrowing borrowing = new Borrowing(book, user);
        borrowing.setId(10L);
        underTest.save(borrowing);

        //when
        underTest.findById(borrowing.getId());

        //then
        ArgumentCaptor<Long> argument = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findById(argument.capture());
        Long capturedId = argument.getValue();
        assertThat(capturedId).isEqualByComparingTo(borrowing.getId());
    }

    @Test
    void shouldGetAllBorrowingsByUserId() {
        //given
        Book book = new Book();
        User user = new User();
        user.setId(10L);
        Borrowing borrowing = new Borrowing(book, user);
        underTest.save(borrowing);

        //when
        underTest.findByUserId(user.getId());

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByUserId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(user.getId());

    }
    @Test
    void shouldGetAllBorrowingsByBookId() {
        //given
        Book book = new Book();
        User user = new User();
        book.setId(10L);
        Borrowing borrowing = new Borrowing(book, user);
        underTest.save(borrowing);

        //when
        underTest.findByBookId(book.getId());

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByBookId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(book.getId());

    }
    @Test
    void shouldGetAllActiveBorrowings() {
        //given
        Book book = new Book();
        User user = new User();
        Borrowing borrowing = new Borrowing(book, user);
        underTest.save(borrowing);

        //when
        underTest.findAllActive();

        //then
        assertThat(borrowing.getBorrowEnd()).isNull();

    }

    @Test
    void shouldGetAllActiveBorrowingsByUserId() {
        //given
        Book book = new Book();
        User user = new User();
        user.setId(10L);
        Borrowing borrowing = new Borrowing(book, user);
        underTest.save(borrowing);

        //when
        underTest.findActiveByUserId(user.getId());

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByUserIdAndBorrowEndNull(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(user.getId());
        assertThat(borrowing.getBorrowEnd()).isNull();
    }
}