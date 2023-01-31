public class MovieTicket {
    int rowNr;
    int seatNr;
    boolean isPremium;

    public MovieTicket(MovieScreening movieScreening, int rowNr, int seatNr, boolean isPremium){
        this.isPremium = isPremium;
        this.rowNr = rowNr;
        this.seatNr = seatNr;

    }

    public boolean isPremium() {
        return isPremium;
    }
    public double getPrice(){
        int i = 1;
        return i;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
