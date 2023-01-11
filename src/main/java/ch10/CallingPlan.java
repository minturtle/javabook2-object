package ch10;

import java.time.Duration;

public class CallingPlan {

    private Long seconds; // 단위 시간
    private Long amount; // 단위 요금


    public CallingPlan(Long seconds, Long amount) {
        this.seconds = seconds;
        this.amount = amount;
    }

    public Long getSeconds() {
        return seconds;
    }



    public Long getAmount() {
        return amount;
    }
}

