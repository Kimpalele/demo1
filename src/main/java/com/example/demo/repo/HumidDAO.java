package com.example.demo.repo;

import com.example.demo.models.Humid;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HumidDAO {

    List<Humid> humidList = new ArrayList<>();
    public HumidDAO() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));

        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from humid")){

            while (rs.next()){
                String date = rs.getString("date");
                int morning = rs.getInt("morningH");
                int noon = rs.getInt("noonH");
                int dusk = rs.getInt("duskH");

                Humid h1 = new Humid(date, morning, noon, dusk);
                humidList.add(h1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Humid> getList(){
        return humidList;
    }
}
