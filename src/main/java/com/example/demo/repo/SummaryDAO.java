package com.example.demo.repo;

import com.example.demo.models.Summary;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SummaryDAO {
    List<Summary> sumList = new ArrayList<>();
    public SummaryDAO(){}

    //Connects to the database and fetches the correct data
    //and then returns a new updated list of objects.
    public List<Summary> updateList() throws IOException {
        sumList.clear();
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));

        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from elecost left join humid on humid.date = elecost.date left join temp on temp.date = elecost.date")){

            while (rs.next()){
                int cost = rs.getInt("cost");
                String date = rs.getString("date");
                int morningT = rs.getInt("morningT");
                int noonT = rs.getInt("noonT");
                int duskT = rs.getInt("duskT");
                int morningH = rs.getInt("morningH");
                int noonH = rs.getInt("noonH");
                int duskH = rs.getInt("duskH");


                sumList.add(new Summary(date, morningT, morningH, noonT, noonH, duskT, duskH, cost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sumList;
    }


}
