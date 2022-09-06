package ch2.discountCondition;

import ch2.Screening;

import java.time.LocalDateTime;

public class DatetimeDiscountCondition implements DiscountCondition{

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public DatetimeDiscountCondition(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean satisfy(Screening screening) {
        return isBetweenEventTime(screening.getPlayTime());
    }

    private boolean isBetweenEventTime(LocalDateTime playTime){
        return startTime.isBefore(playTime) && endTime.isAfter(playTime);
    }
}
