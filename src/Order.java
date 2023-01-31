import java.io.File;
import java.io.FileWriter;
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

    public void addSeatReservation(MovieTicket ticket) {
        this.tickets.add(ticket);
    }

    public double calculatePrice() {

        boolean isSecondTicketFree = false;
        boolean tenPercentDisc = false;

        // Check if 2e ticket is free & ten percent discount is valid
        switch(tickets.get(tickets.size()).movieScreening.getLocalDateTime().getDayOfWeek().toString().toLowerCase()) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
                isSecondTicketFree = true;
                break;
            case "friday":
            case "saturday":
            case "sunday":
                if (isStudentOrder) {
                    isSecondTicketFree = true;
                
                } else if (tickets.size() >= 6) {
                    tenPercentDisc = true;
                }

                break;
        }


        double price = 0;
        boolean secondSwitcher = false;
        for (MovieTicket ticket: tickets) {

          
            if (secondSwitcher) {

                if (isStudentOrder) {

                    price += ticket.getPrice();

                    if (ticket.isPremiumTicket()) 
                        price += ticket.getPrice() + 2;                                        
                
            
                } else if (!isStudentOrder) {
                    price += ticket.getPrice();

                    if (ticket.isPremiumTicket()) 
                        price += ticket.getPrice() + 3;   
                }
            }                
            
            if (isSecondTicketFree)
                secondSwitcher = !secondSwitcher;
        }         

        if (tenPercentDisc) {
            price = price * 0.90;
        }

        return price;
    }

    // public void export(TicketExportFormat exportFormat, Object object, String fileName) throws IOException {    
        // switch (exportFormat) {        
        //     case JSON:            
        //     ObjectMapper objectMapper = new ObjectMapper();            
        //     objectMapper.writeValue(new File(fileName + ".json"), object);            
        //     break;       
        //     case PLAINTEXT:            
        //     FileWriter fileWriter = new FileWriter(fileName + ".txt");            
        //     fileWriter.write(object.toString());            
        //     fileWriter.close();            
        //     break;        
        //     default:            
        //     throw new IllegalArgumentException("Invalid format: " + exportFormat);    
        // }}
}

enum TicketExportFormat{
    PLAINTEXT,
    JSON
}
