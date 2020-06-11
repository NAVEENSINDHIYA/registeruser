import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UpdateData extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              
            
            
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
                String d=request.getParameter("id");
		String n=request.getParameter("name");
		String p=request.getParameter("pass");
                String e=request.getParameter("email");
                String c=request.getParameter("country");
                
		
		
		try{  
                   Properties prop = new Properties();
       FileInputStream fis= new FileInputStream("C:\\Users\\scindia\\Documents\\NetBeansProjects\\registeruser\\conn.properties");
       prop.load(fis);
        String dname=(String)prop.getProperty("Dname");
        String url=(String)prop.getProperty("URL");
        String user=(String)prop.getProperty("Uname");
        String pass=(String)prop.getProperty("password"); 
		
       
                Class.forName(dname);
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement ps=con.prepareStatement("update registeruser set name=?,password=?,email=?,country=? where id=?");
		ps.setString(1,n);
		ps.setString(2,p);
                ps.setString(3,e);
                ps.setString(4,c);
                ps.setString(5,d);
		
		
		int i=ps.executeUpdate();
		if(i>0)
                {out.print("You are successfully updated...");
                
                }
                
		
			
		} catch (ClassNotFoundException e2) {
                    System.out.println(e2);
            } catch (SQLException e2) {
                System.out.println(e2);
            }
		
		out.close();
	}

}
