package ch2.discountCondition;

import ch2.Screening;

public class TurnDiscountCondition implements  DiscountCondition{

    private int turn;


    public TurnDiscountCondition(int turn) {
        this.turn = turn;
    }

    @Override
    public boolean satisfy(Screening screening) {
        return (screening.getSequence() == turn);
    }
}
