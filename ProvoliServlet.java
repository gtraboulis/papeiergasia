package servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticketplease.Provoli;

public class ProvoliServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Παραλαβή των δεδομένων από το αίτημα
        int provoliID = Integer.parseInt(request.getParameter("provoliID"));
        String provoliFilm = request.getParameter("provoliFilm");
        String provoliCinema = request.getParameter("provoliCinema");
        String provoliStartDate = request.getParameter("provoliStartDate");
        String provoliEndDate = request.getParameter("provoliEndDate");
        int provoliNumberOfReservations = Integer.parseInt(request.getParameter("provoliNumberOfReservations"));
        boolean provoliIsAvailable = Boolean.parseBoolean(request.getParameter("provoliIsAvailable"));

        // Δημιουργία ενός αντικειμένου Provoli με τα δεδομένα που παραλάβαμε
        Provoli provoli = new Provoli(provoliID, provoliFilm, provoliCinema, provoliStartDate, provoliEndDate,
                provoliNumberOfReservations, provoliIsAvailable);

        // Κάντε ό, τι απαιτείται με τα δεδομένα της διαθέσιμης προβολής ταινίας, όπως αποθήκευση στη βάση δεδομένων

        // Αποστολή απάντησης πίσω στον πελάτη
        response.getWriter().println("Η διαθέσιμη προβολή ταινίας δημιουργήθηκε με επιτυχία!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
