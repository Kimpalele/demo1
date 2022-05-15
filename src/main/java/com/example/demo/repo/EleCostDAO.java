package com.example.demo.repo;

import com.example.demo.models.EleCost;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.PreparedStatement;

public class EleCostDAO {

    List<EleCost> elecList = new ArrayList<>();
    public EleCostDAO() {}

    //This method takes a EleCost object as input parameter and transfers
    //the values from it to the database as a new row in the correct table
    public EleCost addNewCost(EleCost ec) throws IOException, NumberFormatException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));
        try{Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));

            PreparedStatement stmt = con.prepareStatement("INSERT INTO elecost VALUES(?,?,?)");
            stmt.setNull(1,0);
            stmt.setString(2,ec.getDate());
            stmt.setInt(3,ec.getCost());
            stmt.executeUpdate();

            } catch (SQLException e) {
            throw new RuntimeException(e);
            }

        return null;
    }

    //Connects to the database and fetches the correct data
    //and then returns a new updated list of objects.
    public List<EleCost> updateList() throws IOException{
        elecList.clear();
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));

        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from elecost")){

            while (rs.next()){
                String date = rs.getString("date");
                int cost = rs.getInt("cost");

                elecList.add(new EleCost(date,cost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elecList;
    }
}

