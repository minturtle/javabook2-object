package ch10;

public class NightlyCallingPlan implements CallingPlan{

    private Long seconds; // 단위 시간
    private Long amount; // 단위 요금
    private final static int LATE_NIGHT_HOUR = 22;

    public NightlyCallingPlan(Long seconds, Long amount) {
        this.seconds = seconds;
        this.amount = amount;
    }

    @Override
    public boolean isSatisfy(Call call) {
        return call.getStartTime().getHour() > LATE_NIGHT_HOUR;
    }

    @Override
    public double calculateFee(Call call) {
        return (double)call.getSeconds() * amount / seconds;
    }


}
