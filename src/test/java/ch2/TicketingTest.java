package ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;


class TicketingTest {

    private Customer customer;
    private Movie movie;

    private Screening screening;

    @BeforeEach
    void setUp() {
        customer = new Customer(100000);
        movie = new Movie("존 윅", 15000);
        screening = new Screening(movie, LocalDateTime.of(2023, 1, 2, 1, 0), 30);
    }

    @Test
    @DisplayName("load objects")
    void t1() throws Exception {
        //then
        assertThat(customer).isNotNull();
        assertThat(movie).isNotNull();
        assertThat(screening).isNotNull();
    }

    @Test
    @DisplayName("티켓 구매하기")
    void t2() throws Exception {
        //when
        customer.buy(screening);
        //then
        assertThat(customer.getTicket()).isNotNull();
        assertThat(customer.getTicket().getName()).isEqualTo("존 윅");
        assertThat(customer.getTicket().getStartTime()).isEqualTo(LocalDateTime.of(2023, 1, 2, 1, 0));
        assertThat(customer.getAmount()).isEqualTo(85000);
        assertThat(screening.getSpareSeat()).isEqualTo(29);
    }

    @Test
    @DisplayName("티켓 구매하기 - 여석이 없음")
    void t3() throws Exception {
        //given
        screening = new Screening(movie,LocalDateTime.of(2023, 1, 2, 1, 0), 0);
        //when
        //then
        assertThatThrownBy(()-> customer.buy(screening)).isInstanceOf(Screening.CannotReservationException.class)
                .hasMessage("여석이 없습니다.");
        assertThat(customer.getTicket()).isNull();
    }

    @Test
    @DisplayName("티켓 구매하기 - 돈이 없음")
    void t4() throws Exception {
        //given
        customer = new Customer(0);
        //when
        //then
        assertThatThrownBy(()->customer.buy(screening)).isInstanceOf(Screening.CannotReservationException.class)
                .hasMessage("잔액이 부족합니다.");
        assertThat(customer.getTicket()).isNull();
    }
}