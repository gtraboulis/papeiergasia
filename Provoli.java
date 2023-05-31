package ticketplease;

public class Provoli {
    
    private int provoliID;
    private String provoliFilm;
    private String provoliCinema;
    private String provoliStartDate;
    private String provoliEndDate;
    private int provoliNumberOfReservations;
    private boolean provoliIsAvailable;
    
  
    public Provoli(int provoliID, String provoliFilm, String provoliCinema,
                   String provoliStartDate, String provoliEndDate,
                   int provoliNumberOfReservations, boolean provoliIsAvailable) {
        this.provoliID = provoliID;
        this.provoliFilm = provoliFilm;
        this.provoliCinema = provoliCinema;
        this.provoliStartDate = provoliStartDate;
        this.provoliEndDate = provoliEndDate;
        this.provoliNumberOfReservations = provoliNumberOfReservations;
        this.setProvoliIsAvailable(provoliIsAvailable);
    }
    
    // Getters και Setters για τα χαρακτηριστικά της διαθέσιμης προβολής ταινίας
    public int getProvoliID() {
        return provoliID;
    }
    
    public void setProvoliID(int provoliID) {
        this.provoliID = provoliID;
    }
    
    public String getProvoliFilm() {
        return provoliFilm;
    }
    
    public void setProvoliFilm(String provoliFilm) {
        this.provoliFilm = provoliFilm;
    }
    
    public String getProvoliCinema() {
        return provoliCinema;
    }
    
    public void setProvoliCinema(String provoliCinema) {
        this.provoliCinema = provoliCinema;
    }
    
    public String getProvoliStartDate() {
        return provoliStartDate;
    }
    
    public void setProvoliStartDate(String provoliStartDate) {
        this.provoliStartDate = provoliStartDate;
    }
    
    public String getProvoliEndDate() {
        return provoliEndDate;
    }
    
    public void setProvoliEndDate(String provoliEndDate) {
        this.provoliEndDate = provoliEndDate;
    }
    
    public int getProvoliNumberOfReservations() {
        return provoliNumberOfReservations;
    }
    
    public void setProvoliNumberOfReservations(int provoliNumberOfReservations) {
        this.provoliNumberOfReservations = provoliNumberOfReservations;
    }

	public boolean isProvoliIsAvailable() {
		return provoliIsAvailable;
	}

	public void setProvoliIsAvailable(boolean provoliIsAvailable) {
		this.provoliIsAvailable = provoliIsAvailable;
	}
    
  }