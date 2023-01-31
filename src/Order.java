import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    public ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.tickets = new ArrayList<>();
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket){
        this.tickets.add(ticket);
    }

    public double calculatePrice(){
        double price = 0;
        for (MovieTicket movieTicket : tickets) {
            price += movieTicket.getPrice();
        }

        return price;
    }

    public void export(TicketExportFormat format){

    } 
}

enum TicketExportFormat{
    PLAINTEXT,
    JSON
}
