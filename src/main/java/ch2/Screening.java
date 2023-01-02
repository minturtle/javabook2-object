package ch2;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private LocalDateTime startTime;
    private int spareSeat;

    public Screening(Movie movie, LocalDateTime startTime, int spareSeat) {
        this.movie = movie;
        this.startTime = startTime;
        this.spareSeat = spareSeat;
    }

    public Ticket reservate(){
        if(spareSeat <= 0) throw new CannotReservationException("여석이 없습니다.");
        spareSeat--;
        return new Ticket(movie.getName(), startTime);
    }

    public long getPrice(){
        return movie.getPrice();
    }

    public int getSpareSeat() {
        return spareSeat;
    }

    public static class CannotReservationException extends RuntimeException{
        public CannotReservationException(String message) {
            super(message);
        }
    }
}
