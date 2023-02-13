namespace Domain
{
    public class MovieTicket
    {
        private int _rowNr { get; set; }
        private int _seatNr { get; set; }
        public bool IsPremium { get; set; }
        public MovieScreening MovieScreening { get; set; }

        public MovieTicket(int rowNr, int seatNr, bool isPremium, MovieScreening movieScreening)
        {
            _rowNr = rowNr;
            _seatNr = seatNr;
            IsPremium = isPremium;
            MovieScreening = movieScreening;
        }

        public double GetPrice()
        {
            return MovieScreening.GetPricePerSeat();
        }
    }
}