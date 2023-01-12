package ch10;

public class NormalCallingPlan implements CallingPlan{

    private Long seconds; // 단위 시간
    private Long amount; // 단위 요금


    public NormalCallingPlan(Long seconds, Long amount) {
        this.seconds = seconds;
        this.amount = amount;
    }


    @Override
    public boolean isSatisfy(Call call) {
        return true;
    }

    @Override
    public double calculateFeeByCall(Call call) {
        return (double)call.getSeconds() * amount / seconds;
    }
}

