package ch2;

public class Ticketing {

    private static long Ticketing_Id_Policy = 0;

    private Long id;
    private int peopleAmount;
    private Screening screening;
    private int totalPrice;

    public static Ticketing create(Screening screening, int peopleAmount, int totalPrice){

        Ticketing ticketing = new Ticketing();
        ticketing.id = Ticketing_Id_Policy++;
        ticketing.screening = screening;
        ticketing.peopleAmount = peopleAmount;
        ticketing.totalPrice = totalPrice;

        return ticketing;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
