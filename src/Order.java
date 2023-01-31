public class Order {
    int orderNr;
    boolean isStudentOrder;

    public Order(int orderNr, boolean isStudentOrder){
        this.isStudentOrder = isStudentOrder;
        this.orderNr =orderNr;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket){

    }

    public double calculatePrice(){
        int i = 1;
        return i;
    }

    public void export(TicketExportFormat exportFormat){
        
    }
}
