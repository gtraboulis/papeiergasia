package ticketplease;

public class Admins extends users {
    // Constructor
    public Admins(String username, String password, String first_name, String last_name, String email) {
        super(username, password, first_name, last_name, email);
    }
    
    public void createUser(String username, String password, String first_name, String last_name, String email) {
    }
    
    public void updateUser(String username, String password, String first_name, String last_name, String email) {
    }
    
    public void deleteUser(String username) {
    }
    
    public users searchUser(String username) {
      
        return null; // 
    }
    
    public void viewAllUsers() {
   
    }
    

    public void registerAdmin(String username, String password, String first_name) {
}
}