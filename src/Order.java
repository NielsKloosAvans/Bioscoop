import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.json.JSONException;
import org.json.JSONObject;

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

    public void export(TicketExportFormat exportFormat) throws IOException {    
        switch (exportFormat) {        
            case JSON:                      
                JSONObject json = new JSONObject();
                try {
                    json.put("OrderNr", orderNr);
                    json.put("IsStudentOrder", isStudentOrder);
                    json.put("Tickets", List.of(tickets));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                try (PrintWriter out = new PrintWriter(new FileWriter("Order.json"))) {
                    out.write(json.toString());
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                break;        
            case PLAINTEXT:  
            	try (FileWriter out = new FileWriter("Order.txt")){
                    out.write("Order: " + orderNr + "\nIs Student Order: " + isStudentOrder + "\nTickets:");
                    for (MovieTicket movieTicket : tickets) {
                        out.write(movieTicket.toString());
                    }
                    out.close();   
            	} catch(JSONException e) {
            		e.printStackTrace();
            	}
         
                break;        
            default:            
                throw new IllegalArgumentException("Invalid format: " + exportFormat);    }
    }
}

enum TicketExportFormat{
    PLAINTEXT,
    JSON
}
