package ch2;

import java.time.LocalDateTime;

public class Ticket {

    private String name;
    private LocalDateTime startTime;

    public Ticket(String name, LocalDateTime startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
