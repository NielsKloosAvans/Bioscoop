import java.util.ArrayList;

public class Movie {
    String title;
    ArrayList<MovieScreening> screenings;

    public Movie (String title){
        this.screenings = new ArrayList<>();
        this.title = title;
    }
    public void AddScreening(MovieScreening screening){
        this.screenings.add(screening);
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + "]";
    }
}

