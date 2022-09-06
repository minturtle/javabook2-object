package ch2.discountPolicy;

import ch2.discountCondition.DiscountCondition;

public class RateDiscountPolicy extends DiscountPolicy {

    private double discountRate;


    public RateDiscountPolicy(double discountRate, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountRate = discountRate;
    }

    @Override
    protected int applyDiscount(int moviePrice) {
        return (int)Math.round(moviePrice *(1 - discountRate));
    }
}
