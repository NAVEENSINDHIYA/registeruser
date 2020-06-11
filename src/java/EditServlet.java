/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author SCINDIA
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
      
        PrintWriter out=response.getWriter();  
         
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        User e=UserDao.getUserById(id); 
         request.setAttribute("data", e);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPage.jsp");
        if(dispatcher != null){
            dispatcher.forward(request, response);
        
}
    }
}