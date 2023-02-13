namespace Domain
{
    public class Movie
    {
        public string Title { get; set; }
        public List<MovieScreening> Screenings { get; set; }

        public Movie(string title)
        {
            Title = title;
            Screenings = new List<MovieScreening>();
        }

        public void AddScreening(MovieScreening screening)
        {
            Screenings.Add(screening);
        }
    }
}