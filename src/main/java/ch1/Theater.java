package ch1;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) throws CanNotEnter{
        if(audience.hasTicket()){
            System.out.println("티켓이 이미 있어 입장합니다.");
            return;
        }

        try {
            ticketSeller.sellTo(audience);
        }catch (TicketSeller.CanNotSell e){
            throw new CanNotEnter(e);
        }
    }

    public static class CanNotEnter extends RuntimeException{
        public CanNotEnter(Throwable cause) {
            super("입장할 수 없습니다.", cause);
        }
    }
}

