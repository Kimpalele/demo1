package com.example.demo.repo;

import com.example.demo.models.EleCost;
import com.example.demo.models.Temp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EleCostDAO {

    List<EleCost> elecList = new ArrayList<>();
    public EleCostDAO() throws IOException {
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

                EleCost e1 = new EleCost(date,cost);
                elecList.add(e1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EleCost> getList(){
        return elecList;
    }
}

