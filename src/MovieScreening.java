import java.time.LocalDateTime;
import java.util.ArrayList;

public class MovieScreening {
    LocalDateTime dateAndTime;
    double pricePerSeat;
    Movie movie;
    ArrayList<MovieTicket> tickets;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat ){
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
        this.movie = movie;
        this.tickets = new ArrayList<>();
    }

    public double getPricePerSeat() {
        boolean isWeekday = this.dateAndTime.getDayOfWeek().getValue() < 5;
        return isWeekday ? this.pricePerSeat : 0;
    }

    @Override
    public String toString() {
        return "MovieScreening [dateAndTime=" + dateAndTime + ", pricePerSeat=" + pricePerSeat + "]";
    }
}
