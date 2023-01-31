import java.time.LocalDateTime;
import java.util.ArrayList;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private Double pricePerSeat;
    public Movie movie;
    public ArrayList<MovieTicket> tickets;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, Double pricePerSeat) {
        this.tickets = new ArrayList<>();
        this.movie = movie;
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public Double getPricePerSeat() {
        return pricePerSeat;
    }

    public LocalDateTime getLocalDateTime() {
        return this.dateAndTime;
    }

    @Override
    public String toString() {
        return "MovieScreening [dateAndTime=" + dateAndTime + ", pricePerSeat=" + pricePerSeat + "]";
    }
}
