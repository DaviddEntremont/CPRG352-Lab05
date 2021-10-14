package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

public class HomeServlet extends HttpServlet {
    
    //show welcome message
    //logout hyperlink get request to take user back to url login and shows message "you have successfully logged out"
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        User redirectTemp  = (User) sessionObject.getAttribute("user");
        
        if (redirectTemp != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
            return;
        }
        else if (redirectTemp == null) {
            response.sendRedirect("login");
            return;
        }
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
    }
}
