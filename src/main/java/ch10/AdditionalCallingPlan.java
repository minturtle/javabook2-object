package ch10;

public abstract class AdditionalCallingPlan implements CallingPlan{

    private CallingPlan next;

    public AdditionalCallingPlan(CallingPlan next) {
        this.next = next;
    }

    @Override
    public boolean isSatisfy(Call call) {
        return true;
    }

    @Override
    public double calculateFee(Call call) {
        double fee = next.calculateFee(call);

        return afterCalculate(fee);
    }


    public void setNext(CallingPlan next) {
        this.next = next;
    }

    protected abstract double afterCalculate(double fee);
}
