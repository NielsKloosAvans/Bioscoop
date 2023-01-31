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
        double price;
        if (isPremium = false){
            price = movieScreening.pricePerSeat;
        } else {
            price = movieScreening.pricePerSeat + 2;
        }
        return price;
    }

    @Override
    public String toString() {
        return "MovieTicket [rowNr=" + rowNr + ", seatNr=" + seatNr + ", isPremium=" + isPremium + "]";
    }
}
