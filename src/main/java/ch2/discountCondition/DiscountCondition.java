package ch2.discountCondition;

import ch2.Screening;

public interface DiscountCondition {

    /*
    * 입력받은 Screening이 할인 조건에 부합하는지 검증하는 메서드
    * */
    boolean satisfy(Screening screening);
}
