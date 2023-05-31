package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentAdminsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmTitle = request.getParameter("filmTitle");
        String filmGenre = request.getParameter("filmGenre");
        int filmDuration = Integer.parseInt(request.getParameter("filmDuration"));
        
        ContentAdmins contentAdmin = new ContentAdmins("username", "password", "first_name", "last_name", "email");
        contentAdmin.insertFilm(filmTitle, filmGenre, filmDuration);
        
        response.getWriter().println("Film inserted successfully!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}