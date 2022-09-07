package ch2;

import ch2.discountCondition.DatetimeDiscountCondition;
import ch2.discountCondition.DiscountCondition;
import ch2.discountCondition.TurnDiscountCondition;
import ch2.discountPolicy.DiscountPolicy;
import ch2.discountPolicy.FixDiscountPolicy;
import ch2.discountPolicy.RateDiscountPolicy;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class TicketingTest {

    private Customer customer;
    private Movie movie;
    private Screening screening;
    private DiscountCondition discountCondition1;
    private DiscountCondition discountCondition2;
    private DiscountPolicy discountPolicy;

    private static final int DISCOUNT_AMOUNT = 500;
    private static final double DISCOUNT_RATE = 0.1;

    @BeforeEach
    void setUp() {
        movie = new Movie("어벤져스", 10000, discountPolicy);
        customer = new Customer(20000, 2);

        discountCondition1 = new TurnDiscountCondition(5);

        //9.7 ~ 9.8일 까지 할인
        discountCondition2 = new DatetimeDiscountCondition(
                LocalDateTime.of(2022, 9,7,0,0),
                LocalDateTime.of(2022, 9,8,0,0));
    }

    @Test
    @DisplayName("예매-할인 조건 만족x")
    void t1() throws Exception {
        //given
        useFixDiscountPolicy();
        screening = new Screening(movie, 10,
                LocalDateTime.of(2022,9,6,0,0));
        //when
        customer.reserve(screening);
        //then
        assertThat(customer.getTicketPrice()).isEqualTo(20000);
        assertThat(customer.getMoney()).isEqualTo(0);
    }

    @Test
    @DisplayName("예매-할인 조건 1개(turn 조건) 만족, 고정금액 할인")
    void t2() throws Exception {
        //given
        useFixDiscountPolicy();
        screening = new Screening(movie, 5,
                LocalDateTime.of(2022,9,6,0,0));
        //when
        customer.reserve(screening);
        //then
        assertThat(customer.getTicketPrice()).isEqualTo(20000 - (2 * DISCOUNT_AMOUNT));
        assertThat(customer.getMoney()).isEqualTo(2 * DISCOUNT_AMOUNT);
    }

    @Test
    @DisplayName("예매-할인 조건 2개 만족, 고정금액 할인")
    void t3() throws Exception {
        //given
        useFixDiscountPolicy();
        screening = new Screening(movie, 5, LocalDateTime.of(2022,9,7,12,0));
        //when
        customer.reserve(screening);
        //then
        //두개를 만족하더라도 가격할인가는 1개만 적용.
        assertThat(customer.getTicketPrice()).isEqualTo(20000 - (2 * DISCOUNT_AMOUNT));
        assertThat(customer.getMoney()).isEqualTo(2 * DISCOUNT_AMOUNT);
    }

    @Test
    @DisplayName("예매-할인 조건 1개 만족(기간 조건 만족), 비율 할인")
    void t4() throws Exception {
        //given
        useRateDiscountPolicy();
        screening = new Screening(movie, 6, LocalDateTime.of(2022,9,7,12,0));
        //when
        customer.reserve(screening);
        //then
        assertThat(customer.getTicketPrice()).isEqualTo(18000);
        assertThat(customer.getMoney()).isEqualTo(2000);
    }

    @Test
    @DisplayName("예매-할인 조건 2개 만족, 비율 할인")
    void t5() throws Exception {
        useRateDiscountPolicy();
        screening = new Screening(movie, 5, LocalDateTime.of(2022,9,7,12,0));
        //when
        customer.reserve(screening);
        //then
        assertThat(customer.getTicketPrice()).isEqualTo(18000);
        assertThat(customer.getMoney()).isEqualTo(2000);
    }

    @Test
    @DisplayName("예매-결제금액이 부족한 경우")
    void t6() throws Exception {
        //given
        useFixDiscountPolicy();
        customer = new Customer(10000, 2);
        screening = new Screening(movie, 5, LocalDateTime.of(2022, 9, 7, 12, 0));
        //when
        ThrowableAssert.ThrowingCallable func = ()-> customer.reserve(screening);
        //then
        assertThatThrownBy(func).isInstanceOf(Customer.NotEnoughMoney.class);
    }

    private void useFixDiscountPolicy() {
        discountPolicy = new FixDiscountPolicy(DISCOUNT_AMOUNT, discountCondition1, discountCondition2);
        movie.setDiscountPolicy(discountPolicy);
    }

    private void useRateDiscountPolicy() {
        discountPolicy = new RateDiscountPolicy(DISCOUNT_RATE, discountCondition1, discountCondition2);
        movie.setDiscountPolicy(discountPolicy);
    }
}