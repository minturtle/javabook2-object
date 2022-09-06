package ch2.discountCondition;

import ch2.Screening;

public interface DiscountCondition {

    boolean satisfy(Screening screening);
}
