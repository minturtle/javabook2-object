package ch2.discountPolicy;

import ch2.Screening;
import ch2.discountCondition.DiscountCondition;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> discountConditions;

    public DiscountPolicy(DiscountCondition ... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }


    /*
    * Screening이 조건을 만족하는지 확인하고 만족한다면 moviePrice를 차감하는 메서드
    *
    * @param Screening
    * @param movie의 원가
    * @return Screening이 조건을 만족한다면 할인가, 아니면 원가를 리턴
    * */
    public int calculateMovieFee(Screening screening, int moviePrice){

        for(DiscountCondition condition : discountConditions){
            if (condition.satisfy(screening)) {
                return applyDiscount(moviePrice);
            }
        }

        return moviePrice;
    }

    /*
    * @param : 영화의 총 가격
    * @return : 영화의 할인된 가격
    * */
    protected abstract int applyDiscount(int moviePrice);
}
