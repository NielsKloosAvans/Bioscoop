public class MovieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;
    public MovieScreening movieScreening;
    
    public MovieTicket(MovieScreening movieScreening, int rowNr, int seatNr, boolean isPremium) {
        this.movieScreening = movieScreening;
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.isPremium = isPremium;
    }

    public boolean isPremiumTicket() {
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
