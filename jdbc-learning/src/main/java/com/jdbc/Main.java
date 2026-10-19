package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String username = "neondb_owner";

        String url = "jdbc:postgresql://ep-solitary-frost-b5y0gpbw-pooler.c-7.us-east-2.aws.neon.tech:5432/neondb?sslmode=require&channel_binding=require";
        String password = "npg_C4ILxj7sDlXZ";
        String query = "select username from users where id=1;";
        String allRecords = "select * from former_employees where id >=101 and id<=110;";
        String insertQ = "insert into former_employees values (501, 'dharanikumar', 'dharanikumar0704@gmail.com', 'It');";
        String updateQ = "update former_employees set name='Seetha' where id=110;";
        String deleteQ = "delete from former_employees where id=101;";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.println("Database connected successfully!");

            Statement st = con.createStatement();

            // single record
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("username");
            System.out.println(name);

            // fecthing all records
            ResultSet frs = st.executeQuery(allRecords);
            while (frs.next()) {
                System.out.print(frs.getString(2) + " - ");
                System.out.print(frs.getString(3) + " - ");
                System.out.println(frs.getString(4));
            }

            System.out.println(st.execute(insertQ));
            System.out.println(st.execute(updateQ));
            System.out.println(st.execute(deleteQ));
            // Return value Meaning
            // true The SQL statement returned a ResultSet, usually from a SELECT query.
            // false The SQL statement returned an update count or produced no result.
            int psId = 502;
            String psName = "Dharshini";
            String psEmail = "dharshini@gmail.in";
            String psDepartment = "IT";

            String psquery = "insert into former_employees values (?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(psquery);
            ps.setInt(1, psId);
            ps.setString(2, psName);
            ps.setString(3, psEmail);
            ps.setString(4, psDepartment);
            
            ps.execute();
            con.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}