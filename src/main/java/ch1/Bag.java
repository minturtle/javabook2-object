package ch1;

public class Bag {
    private Ticket ticket;
    private Invitation invitation;
    private Integer money;

    public Bag() {
        this.money = 0;
        this.ticket = null;
        this.invitation = null;
    }

    public Bag(Ticket ticket, Invitation invitation, Integer money) {
        this.ticket = ticket;
        this.invitation = invitation;
        this.money = money;
    }

    public boolean hasTicket(){return (ticket != null);}
    public boolean hasInvitation(){return (invitation != null);}

    public int payForTicket(Ticket ticket)throws NotHavingEnoughMoney{
        if(hasInvitation()){
            invitation = null;
            this.ticket = ticket;
            return 0;
        }
        else if(this.money > ticket.getFee()){
            minusMoney(ticket.getFee());
            this.ticket = ticket;
            return ticket.getFee();
        }
        else{
            throw new NotHavingEnoughMoney();
        }
    }


    private void minusMoney(int money){this.money -= money;}
    private void plusMoney(int money){this.money += money;}



    public static class NotHavingEnoughMoney extends RuntimeException{}
}
