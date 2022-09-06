package ch2;

import ch2.discountPolicy.DiscountPolicy;

import java.time.LocalDateTime;

public class Movie {

    private String title;
    private int price;
    private DiscountPolicy discountPolicy;

    public Movie(String title, int price, DiscountPolicy discountPolicy) {
        this.title = title;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public int getMovieFee(Screening screening){
        return discountPolicy.calculateMovieFee(screening, price);
    }


    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
