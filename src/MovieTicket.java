public class MovieTicket {
    int rowNr;
    int seatNr;
    boolean isPremium;
    MovieScreening movieScreening;

    public MovieTicket(MovieScreening movieScreening, int rowNr, int seatNr, boolean isPremium){
        this.isPremium = isPremium;
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.movieScreening = movieScreening;

    }

    public boolean isPremium() {
        return isPremium;
    }
    public double getPrice(){
        return isPremium ? movieScreening.getPricePerSeat() + 2 : movieScreening.getPricePerSeat();
    }

    @Override
    public String toString() {
        return "MovieTicket [rowNr=" + rowNr + ", seatNr=" + seatNr + ", isPremium=" + isPremium + "]";
    }
}
