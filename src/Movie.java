import java.util.ArrayList;

public class Movie {
    private String title;
    public ArrayList<MovieScreening> screenings;

    public Movie(String title) {
        this.screenings = new ArrayList<>();
        this.title = title;
    }

    public void addScreening(MovieScreening screening){
        this.screenings.add(screening);
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + "]";
    }
}
