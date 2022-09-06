package ch2.discountPolicy;


import ch2.discountCondition.DiscountCondition;

public class FixDiscountPolicy extends DiscountPolicy {

    private int discountAmount;


    public FixDiscountPolicy(int discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected int applyDiscount(int moviePrice) {
        return moviePrice - discountAmount;
    }
}
