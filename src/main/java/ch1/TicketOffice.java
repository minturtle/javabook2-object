package ch1;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private List<Ticket> tickets;
    private Integer money; //잔고

    public TicketOffice(Integer amount, Ticket ... tickets) {
        money = amount;
        this.tickets = new ArrayList<>(List.of(tickets));
    }

    public void minusMoney(int money){this.money -= money;}
    public void plusMoney(int money){this.money += money;}

    public Ticket getTicket(){
        return tickets.remove(0);
    }
}