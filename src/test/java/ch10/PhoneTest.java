package ch10;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class PhoneTest {

    private CallingPlan plan;
    private CallingPlan nightPlan;
    private Phone phone;
    private Call call1;
    private Call call2;



    @BeforeEach
    void setUp() {
        plan = new CallingPlan(10L, 5L); //10초당 5원 부과
        nightPlan = new CallingPlan(10L, 2L); //10초당 2원 부과
        phone = new Phone(plan);
        // 1분짜리 통화
        call1 = new Call(
                LocalDateTime.of(2023, 1, 11, 1, 44, 20),
                LocalDateTime.of(2023,1,11,1,45,20));

        //2분짜리 통화, 심야 통화라 심야 요금제를 사용하는 휴대폰이라면 할인이 적용되야 함.
        call2 = new Call(
                LocalDateTime.of(2023, 1, 11, 23, 44, 20),
                LocalDateTime.of(2023,1,11,23,46,20));

    }

    @Test
    @DisplayName("객체 생성")
    void t1() throws Exception {
        //then
        assertThat(plan).isNotNull();
        assertThat(nightPlan).isNotNull();
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
    @DisplayName("Call 요금 계산(심야 적용 x)")
    void t3() throws Exception {
        //given
        phone.call(call1);
        phone.call(call2);
        //when
        Double fee = phone.calculateFee();
        //then
        assertThat(fee).isEqualTo(90.0);
    }

    @Test
    @DisplayName("심야 시간 요금제 적용한 요금 계산")
    void t4() throws Exception {
        //given
        phone = new NightlyDiscountPhone(plan, nightPlan);

        phone.call(call1);
        phone.call(call2);
        //when
        Double fee = phone.calculateFee();
        //then
        assertThat(fee).isEqualTo(54.0);
    }
}