package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.user;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        user ourUser = (user) sessionObject.getAttribute("user");
        
        if (ourUser == null) { 
            
            ourUser = new user();
        
        }
        
        request.setAttribute("requestAttribute", "attribute in the request object.");
        
        
        String userUsername = request.getParameter("username");
        
        String userUserPassword = request.getParameter("password");
        
        user setUser = new user(userUsername, userUserPassword);
        
        sessionObject.setAttribute("user", setUser);
        
        getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        return;

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redirectTemp = request.getParameter("redirectParam");
        
        HttpSession sessionObject = request.getSession();
        
        String userUsername = request.getParameter("username");
        
        String userUserPassword = request.getParameter("password");
        
        user setUser = new user(userUsername, userUserPassword);
        
        sessionObject.setAttribute("user", setUser);
        
        //HttpSession sessionObject = request.getSession();
        
        //Store object as a session attribute.
        //sessionObject.setAttribute(String name, object o); 
        
        //Return value of specified attribute as an object
        //String username = (String)sessionObject.getAttribute(String name);
        
        //Remove specific attribute from this session.
        //sessionObject = removeAttribute(Stringe name);
        
        
        
        
        if (redirectTemp != null && redirectTemp.equals("true")) {
            response.sendRedirect("home");
            return;
        }
        else if (redirectTemp != null && redirectTemp.equals("false")) {
            response.sendRedirect("login");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
        
        return;
       
    }


}
