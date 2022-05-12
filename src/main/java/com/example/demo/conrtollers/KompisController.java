package com.example.demo.conrtollers;

import com.example.demo.models.Kompis;
import com.example.demo.models.Response;
import com.example.demo.repo.KompisDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KompisController {

    KompisDao kd = new KompisDao();
    List<Kompis> kompisar = kd.getList();

    @RequestMapping("/kompis")
    public List<Kompis> getAllKompisar(){
        return kompisar;
    }

    @RequestMapping("/kompis/{id}")
    public Kompis getKompisById(@PathVariable int id){
        Kompis temp = new Kompis();
        for (Kompis k : kompisar){
            if (k.getId() == id){
                temp = k;
            }
        }
        return temp;
    }

    @RequestMapping("/kompis/name/{name}")
    public Kompis getKompisByName(@PathVariable String name){
        Kompis temp = new Kompis();
        for (Kompis k : kompisar){
            if (k.getName().equalsIgnoreCase(name)){
                temp = k;
            }
        }
        return temp;
    }

    @PostMapping("/kompis/add")
    public Response addKompis(@RequestBody Kompis k){
        System.out.println(k.getName() + " " + k.getAdress() + " " + k.getPhoneNumber() + " " + k.getId());
        Response res = new Response("Kompis added",Boolean.FALSE);
        kompisar.add(k);
        res.setStatus(Boolean.TRUE);
        return res;
    }

    @DeleteMapping("kompis/del/{id}")
    public Response deleteKompisById(@PathVariable("id") int id){
        Response res = new Response("Error deleting kompis..", Boolean.FALSE);

        int removeIndex = -1;
        for (int i = 0; i < kompisar.size(); i++){
            if (kompisar.get(i).getId() == id){
                removeIndex = i;
            }
        }

        if (removeIndex != -1){
            kompisar.remove(removeIndex);
            res.setMessage("Kompis successfully removed!");
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

}