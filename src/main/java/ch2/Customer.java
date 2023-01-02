package ch2;

public class Customer {

    private long amount;
    private Ticket ticket;

    public Customer(long amount) {
        this.amount = amount;
        this.ticket = null;
    }

    public void buy(Screening screening){
        if(amount < screening.getPrice()) throw new Screening.CannotReservationException("잔액이 부족합니다.");
        amount -= screening.getPrice();
        this.ticket = screening.reservate();
    }

    public long getAmount() {
        return amount;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
