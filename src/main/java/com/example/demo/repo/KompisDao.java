package com.example.demo.repo;

import com.example.demo.models.Kompis;

import java.util.ArrayList;
import java.util.List;

public class KompisDao {
    List<Kompis> kompisar = new ArrayList<>();

    public KompisDao(){
        Kompis k1 = new Kompis(1, "Kim", "Stigfinnarvägen", 1070);
        Kompis k2 = new Kompis(2, "Kalle", "Ankagatan", 12345678);
        Kompis k3 = new Kompis(3, "Håkan", "Bråkanvägen", 100000);
        Kompis k4 = new Kompis(4, "Leffe", "Leffsongatan", 98765);

        kompisar.add(k1);
        kompisar.add(k2);
        kompisar.add(k3);
        kompisar.add(k4);
    }

    public List<Kompis> getList(){
        return kompisar;
    }

}
