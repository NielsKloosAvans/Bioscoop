using System.Text.Json;
using System.Text.Json.Serialization;

namespace Domain
{
    public class Order
    {
        [JsonPropertyName("OrderNumber")] public int OrderNr { get; set; }
        [JsonPropertyName("IsStudentOrder")] private bool _isStudentOrder { get; set; }
        [JsonPropertyName("Tickets")] public List<MovieTicket> Tickets { get; set; }

        public Order(int orderNr, bool isStudentOrder)
        {
            Tickets = new List<MovieTicket>();
            OrderNr = orderNr;
            _isStudentOrder = isStudentOrder;
        }

        public void AddSeatReservation(MovieTicket ticket)
        {
            Tickets.Add(ticket);
        }

        public double CalculatePrice()
        {
            double price = 0;

            bool isWeekend = Tickets.Where(t => (int) t.MovieScreening.DateAndTime.DayOfWeek > 5).ToList().Count >= 1;

            List<MovieTicket> filtered = Tickets.Where((t, i) => (i % 2 == 1 && !((int)t.MovieScreening.DateAndTime.DayOfWeek < 5)) || (i % 2 == 1 && !_isStudentOrder)).ToList();

            bool isGroupDiscount = (isWeekend && Tickets.Count >= 6);

            foreach (MovieTicket movieTicket in filtered)
            {
                if (movieTicket.IsPremium && _isStudentOrder)
                {
                    if (isGroupDiscount) price += (movieTicket.MovieScreening.GetPricePerSeat() + 3) * 0.9;
                    else price += movieTicket.MovieScreening.GetPricePerSeat() + 3;
                }
                else if (movieTicket.IsPremium && !_isStudentOrder)
                {
                    if (isGroupDiscount) price += (movieTicket.MovieScreening.GetPricePerSeat() + 2) * 0.9;
                    else price += movieTicket.MovieScreening.GetPricePerSeat() + 2;
                }
                else {
                    if (isGroupDiscount) price += movieTicket.MovieScreening.GetPricePerSeat() * 0.9;
                    else price += movieTicket.MovieScreening.GetPricePerSeat();
                } 
            }
            return price;
        }

        public void Export(TicketExportFormat exportFormat)
        {
            switch (exportFormat)
            {
                case TicketExportFormat.JSON:
                    string json = JsonSerializer.Serialize(this);
                    File.WriteAllText("/path.json", json);
                    break;
                case TicketExportFormat.PLAINTEXT:
                    File.WriteAllText("path.txt", this.ToString());
                    break;
                default:
                    throw new ArgumentException("Invalid format: ", exportFormat.ToString());

            }
        }
    }

    public enum TicketExportFormat
    {
        PLAINTEXT = 0,
        JSON = 1
    }
}