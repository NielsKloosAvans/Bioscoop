import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        List<MovieTicket> filtered = IntStream.range(0, tickets.size()).filter(t -> t % 2 == 1).mapToObj(tickets::get).collect(Collectors.toList());

        boolean isWeekend = (filtered.get(0).getPrice() != 0 && tickets.size() >= 6);

        for (MovieTicket movieTicket : filtered) {
            price += movieTicket.getPrice();
            if(!isStudentOrder){
                price++;
            }
        }

        if(isWeekend){
            price = price * 0.9;
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
