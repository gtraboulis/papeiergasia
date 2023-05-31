package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticketplease.Films;

public class FilmsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Παραλαβή των δεδομένων από το αίτημα
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        String filmTitle = request.getParameter("filmTitle");
        String filmCategory = request.getParameter("filmCategory");
        String filmDescription = request.getParameter("filmDescription");

        // Δημιουργία ενός αντικειμένου Films με τα δεδομένα που παραλάβαμε
        Films film = new Films(filmId, filmTitle, filmCategory, filmDescription);

        // Κάντε ό, τι απαιτείται με τα δεδομένα της ταινίας, όπως αποθήκευση στη βάση δεδομένων

        // Αποστολή απάντησης πίσω στον πελάτη
        response.getWriter().println("Η ταινία προστέθηκε με επιτυχία!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}