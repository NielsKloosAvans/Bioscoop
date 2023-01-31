import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Order {
    int orderNr;
    boolean isStudentOrder;
    ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder){
        this.tickets = new ArrayList<>();
        this.isStudentOrder = isStudentOrder;
        this.orderNr =orderNr;
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

    public void export(TicketExportFormat exportFormat, Object object, String fileName)throws IOException {
        switch (exportFormat) {
            case JSON:
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(fileName + ".json"), object);
                break;
            case PLAINTEXT:
                FileWriter fileWriter = new FileWriter(fileName + ".txt");
                fileWriter.write(object.toString());
                fileWriter.close();
                break;
            default:
                throw new IllegalArgumentException("Invalid format: " + exportFormat);
        }
    }
}
