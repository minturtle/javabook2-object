package ch10;

public class FixSaleAdditionalCallingPlan extends AdditionalCallingPlan{

    private long saleAmount;

    public FixSaleAdditionalCallingPlan(CallingPlan next, long saleAmount) {
        super(next);
        this.saleAmount = saleAmount;
    }

    @Override
    protected double afterCalculate(double fee) {
        return fee - saleAmount;
    }
}
