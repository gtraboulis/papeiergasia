package ticketplease;

public class ContentAdmins extends users {
    
    private String film_title;
    private String film_genre;
    private int film_duration;
    
    // Constructor
    public ContentAdmins(String username, String password, String first_name, String last_name, String email) {
        super(username, password, first_name,last_name,email);
    }
    
 
    public void insertFilm(String film_title, String film_genre, int film_duration) {
      
    }
    

    public void deleteFilm(int film_id) {
      
    }
    
    
    public void assignFilmToCinema(int film_id, int cinema_id) {
     
    }
    
    
    public String getFilmTitle() {
        return film_title;
    }

    public void setFilmTitle(String film_title) {
        this.film_title = film_title;
    }

    public String getFilmGenre() {
        return film_genre;
    }

    public void setFilmGenre(String film_genre) {
        this.film_genre = film_genre;
    }

    public int getFilmDuration() {
        return film_duration;
    }

    public void setFilmDuration(int film_duration) {
        this.film_duration = film_duration;
    }
}
