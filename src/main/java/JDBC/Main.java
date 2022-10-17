package JDBC;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        //making an object of Dbwork class
        Dbwork db = new Dbwork();
        //calling the database connection function
        Connection conn = db.connect_to_db("*********","********","********");

        //calling the method to make a new table
        //db.createTable(conn, "students");

        //calling the method to insert the data into employee table
        //db.insert_data(conn, "employee", "Hafize", "hafize@gmail.com", "Netherlands", 47, 6000);

        //calling the method to fetch all the data from db table
        //db.read_data(conn, "employee");

        //calling the method that updates the name column of employee table
        //db.update_col(conn, "employee", "Orhan", "Said");

        //calling the method that search the whole row via name
        //db.search_data(conn, "employee", "Huzeyfe");

        //calling the method that search the whole row via id
        //db.search_by_id(conn, "employee", 2);

        //calling the method that delete the whole row via name
        //db.delete_by_name(conn, "employee", "Huzeyfe");

        //calling the method to delete the specific table
        //db.del_table(conn, "students");
    }
}
