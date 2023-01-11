package ch10;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class PhoneTest {

    private CallingPlan plan;
    private Phone phone;
    private Call call1;
    private Call call2;



    @BeforeEach
    void setUp() {
        plan = new CallingPlan(5L, 10L); //5초당 10원 부과
        phone = new Phone(plan);
        // 1분짜리 통화
        call1 = new Call(
                LocalDateTime.of(2023, 1, 11, 1, 44, 20),
                LocalDateTime.of(2023,1,11,1,45,20));

        //2분짜리 통화
        call2 = new Call(
                LocalDateTime.of(2023, 1, 11, 1, 44, 20),
                LocalDateTime.of(2023,1,11,1,46,20));

    }

    @Test
    @DisplayName("객체 생성")
    void t1() throws Exception {
        //then
        assertThat(plan).isNotNull();
        assertThat(phone).isNotNull();
        assertThat(call1).isNotNull();
        assertThat(call2).isNotNull();
    }


    @Test
    @DisplayName("Phone에 Call 추가")
    void t2() throws Exception {
        //given
        phone.call(call1);
        phone.call(call2);
        //when

        List<Call> callList = phone.getCallList();
        //then
        assertThat(callList).contains(call1, call2);
    }


    @Test
    @DisplayName("Call 요금 계산")
    void t3() throws Exception {
        //given
        phone.call(call1);
        phone.call(call2);
        //when
        Double fee = phone.calculateFee();
        //then
        assertThat(fee).isEqualTo(360.0);
    }
}