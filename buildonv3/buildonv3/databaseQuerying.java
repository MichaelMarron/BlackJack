/**
 * This class will contain methods in which to query the database(login, register etc..)
 * 
 * @Callum Breen
 * @v0.01
 */

import java.sql.*;

public class databaseQuerying
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://ephesus.cs.cf.ac.uk/g4y2012db";    
    static final String USER = "g4y2012";
    static final String PASS = "Wokboj";
    
    public void registerPlayer(String username, String password, String email, int age, int credits, String location)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //Registers JDBC driver

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            pstmt = conn.prepareStatement("INSERT INTO Player_Info(Username, Password, Email, Age, Credits, location) VALUES(?,?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, age);
            pstmt.setInt(5, credits);
            pstmt.setString(6, location);
            pstmt.executeUpdate();

            System.out.println("Successfully registered!");
            

            pstmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if(pstmt!=null) pstmt.close();   
            }
            catch(SQLException se2)
            {
                //Can't do anything
            }
            try
            {
                if(conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
    } 
    
    
    public void registerCheck(String username, String email)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //Registers JDBC driver

            System.out.println("Connecting to database..."); //Opens a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Searching whether it exists or not...");

            pstmt = conn.prepareStatement("SELECT Email, Username FROM Player_Info WHERE Username = ? OR Email = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, email);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                String tempUsername = rs.getString("Username");
                String tempEmail = rs.getString("Email");
                
                if(tempUsername.equals(username))
                {
                    System.out.println("Username already exists!");
                }
                else
                {
                }
                
                if(tempEmail.equals(email))
                {
                    System.out.println("Email already exists!");
                }
                else
                {
                }
            }
            
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(pstmt!=null) pstmt.close();   
            }
            catch(SQLException se2)
            {
                //Can't do anything
            }
            try
            {
                if(conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
    }
    
    public int login(String username, String password)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int check = 0;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //Registers JDBC driver
            
            System.out.println("Connecting to database..."); //Opens a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            System.out.println("Creating statement...");

            pstmt = conn.prepareStatement("SELECT Password FROM Player_Info WHERE Username=?");
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery(); //Data found from query is assigned to rs
            
            while(rs.next())
            {
                String tempPassword = rs.getString("Password");
                
                if(tempPassword.equals(password))
                {
                    check = 1;
                }
                else
                {
                    check = 0;
                }
            }          
            rs.close();
            pstmt.close();
            conn.close();
                       
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            try
            {
                if(pstmt!=null) pstmt.close();   
            }
            catch(SQLException se2)
            {
                //Can't do anything
            }
            try
            {
                if(conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }    
        
        return check;
    }
    
    public void getTopTen()
    {
        Connection conn = null;
        Statement stmt = null;
        int gamesPlayed, Wins, Losses;
        String username;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            
            String sql = "SELECT PI.Username, ST.Played, ST.Win, ST.Lose FROM Player_Info PI, Statistics ST WHERE PI.Player_ID = ST.Player_ID ORDER BY ST.Win DESC LIMIT 10"; 
            ResultSet rs = stmt.executeQuery(sql); //Data found from query is assigned to rs     

            
            while(rs.next()) //Extracts the data from the Results set "rs"
            {
                username = rs.getString("Username");
                gamesPlayed = rs.getInt("Played");
                Wins = rs.getInt("Win");
                Losses = rs.getInt("Lose");

                System.out.println("Player: " + username + " - Games Played: " + gamesPlayed + " - Wins: " + Wins + " - Losses: " + Losses);
            }
            
            rs.close();
            stmt.close();
            conn.close();        
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            try
            {
                if(stmt!=null) stmt.close();   
            }
            catch(SQLException se2)
            {
                //Can't do anything
            }
            try
            {
                if(conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }    
    }
       
    public void setGameRules()
    {
        
    }
    
    public void getGameRules()
    {
    }
}
