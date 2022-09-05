package ch1;

public class Audience {
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public boolean hasTicket(){
        return bag.hasTicket();
    }

    public int buy(Ticket ticket) throws Bag.NotHavingEnoughMoney {
        int ticketPay = bag.payForTicket(ticket); //지불할 값 (초대장을 가지고 있으면 0원, 그렇지 않으면 티켓 값을 가방에서 꺼낸다.)
        return ticketPay;
    }
}
