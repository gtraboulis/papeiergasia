package servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticketplease.Customers;

public class CustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests from customers
        String action = request.getParameter("action");
        
        if (action == null) {
            // Default action or error handling
            response.getWriter().println("Invalid action");
        } else if (action.equals("showAvailableFilms")) {
            // Perform showAvailableFilms logic
            Customers customer = getCustomerFromSession(request); // Assuming you have a method to retrieve the customer object from session
            customer.showAvailableFilms();
            response.getWriter().println("Showing available films");
        } else if (action.equals("viewReservation")) {
            // Perform viewReservation logic
            Customers customer = getCustomerFromSession(request);
            customer.viewReservation();
            response.getWriter().println("Viewing reservation");
        } else {
            response.getWriter().println("Invalid action");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests from customers
        String action = request.getParameter("action");
        
        if (action == null) {
            // Default action or error handling
            response.getWriter().println("Invalid action");
        } else if (action.equals("makeReservation")) {
            // Perform makeReservation logic
            Customers customer = getCustomerFromSession(request);
            customer.makeReservation();
            response.getWriter().println("Making reservation");
        } else {
            response.getWriter().println("Invalid action");
        }
    }
    
    private Customers getCustomerFromSession(HttpServletRequest request) {
        // Retrieve the customer object from the session
        // You need to implement this method based on your session management
        // This is just a placeholder
        return (Customers) request.getSession().getAttribute("customer");
    }
}
