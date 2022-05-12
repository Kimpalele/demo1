package com.example.demo.repo;

import com.example.demo.models.Summary;
import com.example.demo.models.Temp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SummaryDAO {
    List<Summary> sumList = new ArrayList<>();
    public SummaryDAO() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));

        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from temp inner join humid on humid.date = temp.date inner join elecost on elecost.date = temp.date")){

            while (rs.next()){
                String date = rs.getString("date");
                int morningT = rs.getInt("morningT");
                int noonT = rs.getInt("noonT");
                int duskT = rs.getInt("duskT");
                int morningH = rs.getInt("morningH");
                int noonH = rs.getInt("noonH");
                int duskH = rs.getInt("duskH");
                int cost = rs.getInt("cost");

                Summary s1 = new Summary(date, morningT, morningH, noonT, noonH, duskT, duskH, cost);
                sumList.add(s1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Summary> getList(){
        return sumList;
    }


}
