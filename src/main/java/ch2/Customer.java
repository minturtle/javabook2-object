package ch2;

public class Customer {

    private int money;
    private int peopleAmount;
    private Ticketing ticketing;

    public Customer(int money, int peopleAmount) {
        this.money = money;
        this.peopleAmount = peopleAmount;
    }

    public void reserve(Screening screening)throws NotEnoughMoney{
        int finalPrice = screening.getfinalPrice() * peopleAmount;
        pay(finalPrice);
        ticketing = Ticketing.create(screening, finalPrice, finalPrice);
    }



    public int getTicketPrice() {
        return ticketing.getTotalPrice();
    }

    public int getMoney() {
        return money;
    }

    private void pay(int price) throws NotEnoughMoney{
        if(money < price) throw new NotEnoughMoney();
        money -= price;

    }

    public static class NotEnoughMoney extends RuntimeException{}
}
