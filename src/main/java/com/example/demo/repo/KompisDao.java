package com.example.demo.repo;

import com.example.demo.models.BookLombok;
import com.example.demo.models.KompisLombok;

import java.util.ArrayList;
import java.util.List;

public class KompisDao {
    List<KompisLombok> kompisar = new ArrayList<KompisLombok>();

    public KompisDao(){
        KompisLombok k1 = new KompisLombok(1, "Kim", "Stigfinnarvägen", 070);
        KompisLombok k2 = new KompisLombok(2, "Kalle", "Ankagatan", 12345678);
        KompisLombok k3 = new KompisLombok(3, "Håkan", "Bråkanvägen", 00000);
        KompisLombok k4 = new KompisLombok(4, "Leffe", "Leffsongatan", 98765);

        kompisar.add(k1);
        kompisar.add(k2);
        kompisar.add(k3);
        kompisar.add(k4);
    }

    public List<KompisLombok> getList(){
        return kompisar;
    }

}
