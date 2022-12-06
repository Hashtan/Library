package com.Library.Library.manager;

import com.Library.Library.dao.entity.Book;
import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.entity.User;
import com.Library.Library.dao.repo.BorrowingRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BorrowingManagerTest {

    @Mock
    private BorrowingRepo borrowingRepo;
    @InjectMocks
    private BorrowingManager underTest;

    public Borrowing init (){
        Book book = new Book();
        User user = new User();
        return new Borrowing(book, user);
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
        Borrowing borrowing = init();

        //when
        underTest.save(borrowing);

        //then
        ArgumentCaptor<Borrowing> argumentCaptor = ArgumentCaptor.forClass(Borrowing.class);
        verify(borrowingRepo).save(argumentCaptor.capture());
        Borrowing capturedBorrowing = argumentCaptor.getValue();
        assertThat(capturedBorrowing.getBorrowStart()).isEqualTo(LocalDate.now());
        assertThat(capturedBorrowing.getExpectedReturnDate()).isEqualTo(LocalDate.now().plusMonths(3));
        assertThat(capturedBorrowing.getBook().isActiveStatus()).isFalse();
        assertThat(capturedBorrowing).isEqualTo(borrowing);

    }

    @Test
    void deleteById() {
        //given
        Borrowing borrowing = init();
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
        Borrowing borrowing = init();
        borrowing.setId(10L);

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
        Borrowing borrowing = init();
        borrowing.getUser().setId(10L);
        underTest.save(borrowing);

        //when
        underTest.findByUserId(borrowing.getUser().getId());

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByUserId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(borrowing.getUser().getId());
    }
    @Test
    void shouldGetAllBorrowingsByBookId() {
        //given
        Borrowing borrowing = init();
        borrowing.getBook().setId(10L);
        underTest.save(borrowing);

        //when
        underTest.findByBookId(borrowing.getBook().getId());

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByBookId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(borrowing.getBook().getId());

    }
    @Test
    void shouldGetAllActiveBorrowings() {
        //given
        Borrowing borrowing = init();
        underTest.save(borrowing);

        //when
        underTest.findAllActive();

        //then
        assertThat(borrowing.getBorrowEnd()).isNull();

    }

    @Test
    void shouldGetAllActiveBorrowingsByUserId() {
        //given
        Borrowing borrowing = init();
        borrowing.getUser().setId(10L);
        underTest.save(borrowing);

        //when
        underTest.findActiveByUserId(borrowing.getUser().getId());

        //then
        ArgumentCaptor <Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(borrowingRepo).findByUserIdAndBorrowEndNull(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualByComparingTo(borrowing.getUser().getId());
        assertThat(borrowing.getBorrowEnd()).isNull();
    }

    @Test
    void shouldReturnBookById() {
        //given
        Borrowing borrowing = init();
        borrowing.setId(10L);
        when(borrowingRepo.save(borrowing)).thenReturn(borrowing);
        when(borrowingRepo.findById(borrowing.getId())).thenReturn(Optional.of(borrowing));

        //when
        Borrowing capturedBorrowing = underTest.returnBookById(borrowing.getId());

        //then
        assertThat(capturedBorrowing.getBorrowEnd()).isEqualTo(LocalDate.now());
        assertThat(capturedBorrowing.getBook().isActiveStatus()).isTrue();
        assertThat(capturedBorrowing).isEqualTo(borrowing);
    }
}