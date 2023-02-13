namespace Domain
{
    public class MovieScreening
    {
        public DateTime DateAndTime { get; }
        private double _pricePerSeat { get; }
        public Movie Movie { get; set; }
        public List<MovieTicket> Tickets { get; set; }

        public MovieScreening(DateTime dateAndTime, double pricePerSeat, Movie movie)
        {
            Tickets = new List<MovieTicket>();
            DateAndTime = dateAndTime;
            _pricePerSeat = pricePerSeat;
            Movie = movie;
        }

        public double GetPricePerSeat()
        {
            return _pricePerSeat;
        }
    }
}