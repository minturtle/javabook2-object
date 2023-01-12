package ch10;

public class TaxAdditionalCallingPlan extends AdditionalCallingPlan{

    private double taxRate;

    public TaxAdditionalCallingPlan(CallingPlan next, double taxRate) {
        super(next);
        this.taxRate = taxRate;
    }

    @Override
    protected double afterCalculate(double fee) {
        return fee * (100  + taxRate) / 100;
    }
}
