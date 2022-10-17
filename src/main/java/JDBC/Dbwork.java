package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbwork {
    //making the connection of our application with PostgreSQL
    public Connection connect_to_db(String dbname, String user, String pass){
        //making the object of Connection
        Connection conn = null;
        try{
            //load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            //setting up the connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            //passing condition to check the connection is successfull or not
            if(conn != null){
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    //method for creating a new table
    public void createTable(Connection conn, String table_name){
        //make an object of Statement
        Statement statement;
        try{
            String query = "create table" + table_name + "(empId SERIAL, name varchar(200), email varchar(200), country varchar(200), age integer, salary integer, primary key(empId))";
            //create a statement
            statement = conn.createStatement();
            //executing our query by putting it in to our statement
            statement.executeUpdate(query);
            System.out.println("Table created!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method for inserting data into our table columns
    public void insert_data(Connection conn, String table_name, String name, String email, String country, int age, int salary){
        //make an object of statement
        Statement statement;
        try{
            String query = String.format("insert into %s(name,email,country,age,salary) values('%s', '%s', '%s', '%d', '%d')", table_name, name, email, country, age, salary);
            //create a statement
            statement = conn.createStatement();
            //executing our query by putting it in to our statement
            statement.executeUpdate(query);
            System.out.println("Data has been inserted successfully!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //function for reading all the data from the database
    public void read_data(Connection conn, String table_name){
        Statement statement;
        //using the result set to get result of the db query
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            //executing our query by putting it in to our statement
            rs = statement.executeQuery(query);
            while (rs.next()){
                //print all the columns
                System.out.print(rs.getString("empId") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("email") + " ");
                System.out.print(rs.getString("country") + " ");
                System.out.print(rs.getString("age") + " ");
                System.out.println(rs.getString("salary") + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //function to update the data column specifically
    public void update_col(Connection conn, String table_name, String old_col, String new_col){
        Statement statement;
        try{
            String query = String.format("update %s set name='%s' where name='%s'", table_name, new_col, old_col);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Name has been updated successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //function to get the whole row data by searching the name
    public void search_data(Connection conn, String table_name, String name){
        Statement statement;
        //using the result set to get result of the db query
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where name='%s'", table_name, name);
            statement = conn.createStatement();
            //executing our query by putting it in to our statement
            rs = statement.executeQuery(query);
            while (rs.next()){
                //print all the columns
                System.out.print(rs.getString("empId") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("email") + " ");
                System.out.print(rs.getString("country") + " ");
                System.out.print(rs.getString("age") + " ");
                System.out.println(rs.getString("salary") + " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //function to get the whole row data by searching the id
    public void search_by_id(Connection conn, String table_name, int id){
        Statement statement;
        //using the result set to get result of the db query
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where empId='%d'", table_name, id);
            statement = conn.createStatement();
            //executing our query by putting it in to our statement
            rs = statement.executeQuery(query);
            while (rs.next()){
                //print all the columns
                System.out.print(rs.getString("empId") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("email") + " ");
                System.out.print(rs.getString("country") + " ");
                System.out.print(rs.getString("age") + " ");
                System.out.println(rs.getString("salary") + " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //function to delete the whole row data
    public void delete_by_name(Connection conn, String table_name, String name){
        Statement statement;
        try{
            String query = String.format("delete from %s where name='%s'", table_name, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data has been deleted successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //function to delete the table
    public void del_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query = String.format("drop table %s", table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println(table_name + "Table has been deleted successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}











