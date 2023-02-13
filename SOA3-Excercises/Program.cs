using Domain;

class Program
{
    static void Main(string[] args)
    {
        Movie movie = new("Movie");

        Order order = new(1, true);

        MovieScreening movieScreening = new(new DateTime(2023, 11, 4), 5, movie);

        order.Tickets.AddRange(new List<MovieTicket> {
            new(1, 1, false, movieScreening),
            new(1, 1, false, movieScreening)
        });

        Console.WriteLine(order.CalculatePrice());
    }
}



