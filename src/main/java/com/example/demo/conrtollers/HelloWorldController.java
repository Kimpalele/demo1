package com.example.demo.conrtollers;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorldController {

    List<String> animals = new ArrayList<>(Arrays.asList("Lion", "Bear", "Pig", "Fish", "Horse", "Elephant", "Mole"));

    int min = 0;
    int max = 6;

    /*@RequestMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }*/

    @GetMapping(path = "/")
    public String helloWorld(){
        return "index.html";
    }

    @RequestMapping("/esp")
    public String esp(){
        return "Hola Mundo!";
    }

    @RequestMapping("/hello")
    public String addFoo(@RequestParam String fname, @RequestParam String lname){
        return "Hello " + fname + " " + lname;
    }

    public String randomAnimal(){
        return animals.get((int) (Math.random()*6));
    }

    public String randNum(){
        return String.valueOf((int) (Math.random() * 100));
    }

    @RequestMapping("/random")
    public String AnimalOrNumber(@RequestParam String luckyYou){
        if (luckyYou.equalsIgnoreCase("animal")){
            return randomAnimal();
        }else if (luckyYou.equalsIgnoreCase("number")){
            return randNum();
        }else{
            return "Wrong input";
        }
    }

    @RequestMapping("/defaultNames")
    public String defaultNames(@RequestParam String luckyYou){
        if (luckyYou.equalsIgnoreCase("animal")){
            return randomAnimal();
        }else if (luckyYou.equalsIgnoreCase("number")){
            return randNum();
        }else{
            return "Wrong input";
        }
    }
    /*
    @RequestMapping("/kompis")
    public String kompis(@RequestParam String name, @RequestParam String adress,
                         @RequestParam int phoneNum, @RequestParam int id){
        Kompis buddy = new Kompis(id, name, adress, phoneNum);
        return buddy.getPersonalInfo();
    }
    */
    @RequestMapping("/lista")
    public String lista(@RequestParam List<String> id){
        return "Items in list: " + id;
    }

    @RequestMapping("/pathvartest/{id}")
    public String pathvartest(@PathVariable String id){
        return "<h1>ID: " + id + "<h1>";
    }

    /*
    @RequestMapping("/random")
    public String random(@RequestParam String luckyYou){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        if (luckyYou.equalsIgnoreCase("animal")){
            return animals.get(random_int);
        }else if (luckyYou.equalsIgnoreCase("number")){
            String s = Integer.toString(random_int);
            return s;
        }else{return "Wrong input";}
    }*/


}
