package ch2;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime playTime;

    public Screening(Movie movie, int sequence, LocalDateTime playTime) {
        this.movie = movie;
        this.sequence = sequence;
        this.playTime = playTime;
    }

    public int getfinalPrice(int reversePeopleAmount){
        return movie.getMovieFee(this) * reversePeopleAmount;
    }


    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getPlayTime() {
        return playTime;
    }
}
