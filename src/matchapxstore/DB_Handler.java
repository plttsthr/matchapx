package matchapxstore;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.PreparedStatement;

public class DB_Handler 
{
    private Connection conn = null;
    private int current_userID = 0;
   
    public int get_current_userID()
    {
        return(current_userID);
    }
    
    public void reset_current_userID()
    {
        current_userID = 0;
    }

    public Timestamp insert_records(String objectID, int price, int new_value) // maybe add userID //
    {
        if(current_userID == 0)
            return(null);
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into records(userID, objectID, price) values(?,?,?)");
            st.setInt(1, current_userID);
            st.setString(2, objectID);
            st.setFloat(3, price);
            st.executeUpdate();

            // get last item added //
            int record_id = conn.prepareStatement("select last_insert_rowid()").executeQuery().getInt("last_insert_rowid()");
            st.setQueryTimeout(30);  // set timeout to 30 sec.
            st = conn.prepareStatement("select timestamp from records where orderID=?");
            st.setInt(1, record_id);
            // retrieve timestamp from last transaction //
            Timestamp time = st.executeQuery().getTimestamp("timestamp");

            // decrease cash from db //
            update_money(new_value); // update local money !!!! //

            return(time);
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return(null);
    }

    public boolean update_money(int new_value) // update table users in db //
    {
        make_connection();
        try
        {
            String query = "UPDATE users SET cash=? WHERE userID=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, new_value);
            statement.setInt(2, current_userID);
            statement.executeUpdate();
            System.out.println("inside db " + new_value);
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.close();
            return(true);
        }
        
        catch(SQLException e)
        {
            
            System.err.println(e.getMessage());
        }
        return(false);
    }
    
    public boolean update_password(String old_password, String new_password) // update table users in db //
    {
        make_connection();
        try
        {
            String ps = "select hash from users where userID=?";
            PreparedStatement st = conn.prepareStatement(ps);
            st.setInt(1, current_userID);
            st.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = st.executeQuery();
            
            if(old_password.equals(rs.getString("hash"))) // check password //
            {
                String query = "UPDATE users SET hash=? WHERE userID=?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, new_password);
                statement.setInt(2, current_userID);
                statement.executeUpdate();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                
                statement.close();
                return(true);
            }
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return(false);
    }

    public Connection get_connection() // return connection //
    {
        return(conn);
    }

    public boolean make_connection() // connect with corresponding database //
    {
        if(conn != null) // if not connected yet, access db //
            return(false);
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:admin.db");
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return(false);
        }
        return(true);
    }

    public void close_connection() // close connection with db //
    {
        try
        {
            conn.close();
        } 
        
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        } 
    }
    
    public boolean register(String username, String password) // register new users //
    {
        try
        {
            String check = "select hash from users where username=?";
            PreparedStatement ck = conn.prepareStatement(check);
            ck.setString(1, username);
            ck.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = ck.executeQuery();
            if(rs.next())
            {
                System.out.println("Username already exists.");
                return(false);
            }
            ck = conn.prepareStatement("insert into users(username, hash) values(?,?)");
            ck.setString(1, username);
            ck.setString(2, password);
            ck.setQueryTimeout(30);
            ck.executeUpdate();
            ck.close();
            rs.close();
            
            System.out.println("Registered");
            return(true);
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage()); // if the error message is "out of memory",
            return(false);
        }
    }
    
    
    public User signin(String username, String password) // sign in returning a User type //
    {
        try
        {
            String ps = "select hash from users where username=?";
            PreparedStatement st = conn.prepareStatement(ps);
            st.setString(1, username);
            st.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = st.executeQuery();
            
            if(rs.isClosed()) // not in db //
            {
                System.out.println("Username not found.");
            }
            if(password.equals(rs.getString("hash"))) // check password //
            {
                st = conn.prepareStatement("select * from users where username=?"); // retrieve information: update from db //
                st.setString(1, username);
                st.setQueryTimeout(30);  // set timeout to 30 sec.
                rs = st.executeQuery();

                current_userID = rs.getInt("userID");
                User user = new User(rs.getInt("cash"), current_userID); // create the current User type with db's info //
                getOrder(user); // retrieve items previously bought //
                st.close();
                rs.close();
                return(user);
            }
            st.close();
            rs.close();
            System.out.println("Invalid password.");
            return(null);
        }
        
        catch(SQLException e)
        {
            // prints errors //
            System.err.println(e.getMessage());
            return(null);
        }
    }
    
    public void getOrder(User u) // get records from db //
    {
        try
        {
            PreparedStatement state = conn.prepareStatement("select * from records where userID=?"); // get records' list //
            state.setInt(1, current_userID);
            ResultSet rs = state.executeQuery();
           
            while(rs.next()) // traverse all result set: output from SQL query //
            {
                String identifier = rs.getString("objectID");
                int transaction_cost = rs.getInt("price");
                java.sql.Timestamp datetime = rs.getTimestamp("timestamp"); // actually date of past transactions //

                Item newbie = null; // item to be added //
        
                switch(identifier.toLowerCase()) // create object depending on identifier //
                {
                    case "avocado":
                        newbie = new Avocado(identifier, transaction_cost, datetime);
                        break;
                    case "burger":
                        newbie = new Burger(identifier, transaction_cost, datetime);
                        break;
                    case "bench":
                        newbie = new Bench(identifier, transaction_cost, datetime);
                        break;
                    case "cactus":
                        newbie = new Cactus(identifier, transaction_cost, datetime);
                        break;
                    case "camera":
                        newbie = new Camera(identifier, transaction_cost, datetime);
                        break;
                    case "christmastree":
                        newbie = new ChristmasTree(identifier, transaction_cost, datetime);
                        break;
                    case "computer":
                        newbie = new Computer(identifier, transaction_cost, datetime);
                        break;
                    case "dumbbell":
                        newbie = new Dumbbell(identifier, transaction_cost, datetime);
                        break;
                    case "frog":
                        newbie = new Frog(identifier, transaction_cost, datetime);
                        break;
                    case "guitar":
                        newbie = new Guitar(identifier, transaction_cost, datetime);
                        break;
                    case "hammer":
                        newbie = new Hammer(identifier, transaction_cost, datetime);
                        break;
                    case "ipad":
                        newbie = new Ipad(identifier, transaction_cost, datetime);
                        break;
                    case "microwave":
                        newbie = new Microwave(identifier, transaction_cost, datetime);
                        break;
                    case "necklace":
                        newbie = new Necklace(identifier, transaction_cost, datetime);
                        break;
                    case "oven":
                        newbie = new Oven(identifier, transaction_cost, datetime);
                        break;
                    case "painting":
                        newbie = new Painting(identifier, transaction_cost, datetime);
                        break;
                    case "panda":
                        newbie = new Panda(identifier, transaction_cost, datetime);
                        break;
                    case "phone":
                        newbie = new Phone(identifier, transaction_cost, datetime);
                        break;
                    case "popcorn":
                        newbie = new Popcorn(identifier, transaction_cost, datetime);
                        break;
                    case "ramen":
                        newbie = new Ramen(identifier, transaction_cost, datetime);
                        break;
                    case "ricecooker":
                        newbie = new RiceCooker(identifier, transaction_cost, datetime);
                        break;
                    case "rocket":
                        newbie = new Rocket(identifier, transaction_cost, datetime);
                        break;
                    case "sunglasses":
                        newbie = new Sunglasses(identifier, transaction_cost, datetime);
                        break;
                    case "television":
                        newbie = new Television(identifier, transaction_cost, datetime);
                        break;
                    case "tiara":
                        newbie = new Tiara(identifier, transaction_cost, datetime);
                        break;
                    case "top":
                        newbie = new Top(identifier, transaction_cost, datetime);
                        break;
                    case "trumpet":
                        newbie = new Trumpet(identifier, transaction_cost, datetime);
                        break;
                    case "umbrella":
                        newbie = new Umbrella(identifier, transaction_cost, datetime);
                        break;   
                }
                
                if(newbie != null)
                    u.addItemToOrder(newbie); // add to users records //
            }
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
