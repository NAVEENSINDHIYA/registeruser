import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import bean.User;

public class UserDao {
	
    /**
     *
     * @return
     */
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
        
               Properties prop = new Properties();
       FileInputStream fis= new FileInputStream("C:\\Users\\scindia\\Documents\\NetBeansProjects\\registeruser\\conn.properties");
       prop.load(fis);
        String dname=(String)prop.getProperty("Dname");
        String url=(String)prop.getProperty("URL");
        String user=(String)prop.getProperty("Uname");
        String pass=(String)prop.getProperty("password"); 
                Class.forName(dname);
            con = DriverManager.getConnection(url,user,pass);
        }catch(IOException e){System.out.println(e);} catch (ClassNotFoundException e) {  
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;  
    }       
        
       public static int save(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into registeruser(id,name,password,email,country) values (?,?,?,?,?)");  
            ps.setInt(1,e.getId());
            ps.setString(2,e.getName());  
            ps.setString(3,e.getPassword());  
            ps.setString(4,e.getEmail());  
            ps.setString(5,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
        
       
           public static int update(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update registeruser set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
        
          
	    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from registeruser where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
            
                public static User getUserById(int id){  
        User e=new User();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from registeruser where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } 
                
                  public static List<User> getAllUsers(){  
        List<User> list=new ArrayList<User>();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from registeruser");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                User e=new User();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
}
