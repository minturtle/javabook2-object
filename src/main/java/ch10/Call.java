package ch10;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Call(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Duration getDuration(){
        return Duration.between(startTime, endTime);
    }
}
