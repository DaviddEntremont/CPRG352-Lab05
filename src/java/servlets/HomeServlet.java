package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

public class HomeServlet extends HttpServlet {
    
    //show welcome message
    //logout hyperlink get request to take user back to url login and shows message "you have successfully logged out"
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        
        String operation = request.getParameter("operation");
        if (operation != null && operation.equals("reset")) {
            sessionObject.invalidate();
            sessionObject = request.getSession();
        }
        
        AccountService userObject = (AccountService) sessionObject.getAttribute("user");
        
        request.setAttribute("user", userObject);
        
        getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
        return;
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
