package ch1;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) throws CanNotSell{
        Ticket ticket = ticketOffice.getTicket();
        try{
            final int paidMoney = audience.buy(ticket);
            ticketOffice.plusMoney(paidMoney);
        }catch (Bag.NotHavingEnoughMoney e){
            throw new CanNotSell(e);
        }
    }

    public static class CanNotSell extends RuntimeException {
        public CanNotSell(Throwable cause) {
            super(cause);
        }
    }
}
