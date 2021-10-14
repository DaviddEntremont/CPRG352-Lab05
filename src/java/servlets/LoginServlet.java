package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {

    @Override
    
    //Display login form and log out the user
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        String logout = (String) request.getParameter("invalidate");
        
        if (logout != null) {
            
            sessionObject.invalidate();
            sessionObject = request.getSession();
            sessionObject.setAttribute("loggedout", true);
            response.sendRedirect("home");
            return;
        }
        
        User redirectTemp  = (User) sessionObject.getAttribute("user");
        
        if (redirectTemp != null) {
            response.sendRedirect("home");
            return;
        }
        
        else if (redirectTemp == null) {
         
            getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
            return;
        }
    }

    //validate that username and password are not empy
    //pass username and password to the login method of "ACCOUNTSERVICE" class
    //if non null value returned store the username in the session and redirect to the home url
    //display error message if parameters are invalid
    //keep textboxes filled
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        sessionObject.setAttribute("loggedout", false);
        
        String userUsername = request.getParameter("username");
        
        String userUserPassword = request.getParameter("password");
        
        request.setAttribute("username", userUsername);
        
        request.setAttribute("password", userUserPassword);
        
        if ((userUsername == null || userUsername.equals("")) && (userUserPassword == null || userUserPassword.equals(""))) {
        
            request.setAttribute("nullBoth", true);
             
             getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
             
             return;
        }
        
        else if (userUsername == null || userUsername.equals("")) { 
            
             request.setAttribute("nullUsername", true);
             
             getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
             
             return;
        
        }
             
        else if (userUserPassword == null || userUserPassword.equals("")) {
            
            request.setAttribute("nullPassword", true);
             
             getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
             
             return;
            
        }
        else {
        
        AccountService accountAuthenticator = new AccountService();
        
        User authenticatorUser = accountAuthenticator.login(userUsername, userUserPassword);
        
        if (authenticatorUser == null){
            
            request.setAttribute("invalid", true);
            
            getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        
            return;
            
        }
        else {
             
            sessionObject.setAttribute("user", authenticatorUser);
            
            response.sendRedirect("home");
        
            return;
            
        }
        
       
    }


}
}
