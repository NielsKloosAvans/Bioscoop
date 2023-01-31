import java.time.LocalDateTime;
import java.util.ArrayList;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;
    public Movie movie;
    public ArrayList<MovieTicket> tickets;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, Double pricePerSeat) {
        this.tickets = new ArrayList<>();
        this.movie = movie;
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public Double getPricePerSeat() {
        boolean isWeekday = this.dateAndTime.getDayOfWeek().getValue() < 5;
        return isWeekday ? this.pricePerSeat : 0;
    }

    @Override
    public String toString() {
        return "MovieScreening [dateAndTime=" + dateAndTime + ", pricePerSeat=" + pricePerSeat + "]";
    }
}
