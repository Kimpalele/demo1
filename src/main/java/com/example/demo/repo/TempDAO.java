package com.example.demo.repo;

import com.example.demo.models.Temp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TempDAO {


    List<Temp> tempList = new ArrayList<>();

    public TempDAO() {}

    //Connects to the database and fetches the correct data
    //and then returns a new updated list of objects.
    public List<Temp> updateList() throws IOException{
        tempList.clear();
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/Settings.properties"));

        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from temp")){

            while (rs.next()){
                String date = rs.getString("date");
                int morning = rs.getInt("morningT");
                int noon = rs.getInt("noonT");
                int dusk = rs.getInt("duskT");

                tempList.add(new Temp(date,morning,noon,dusk));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tempList;
    }
}