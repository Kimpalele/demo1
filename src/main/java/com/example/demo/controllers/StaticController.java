package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class StaticController {

    //Creates each and everydatabase from which we will
    //read data from and add to our lists below
    TempDAO TDAO = new TempDAO();
    HumidDAO HDAO = new HumidDAO();
    SummaryDAO SDAO = new SummaryDAO();
    EleCostDAO EDAO = new EleCostDAO();

    List<Temp> tempList;
    List<Humid> humidList;
    List<Summary> sumList;
    List<EleCost> elecList;

    //Fetches temperature data from the database and displays it in the browser
    @RequestMapping("/temps")
    public ModelAndView temperature() throws IOException {
        tempList = TDAO.updateList();
        ModelAndView mav = new ModelAndView("temperature");
        mav.addObject("Temperature_List", tempList);
        return mav;
    }

    //Fethces humidity data from the database and displays it in the browser
    @RequestMapping("/humid")
    public ModelAndView humidity() throws IOException {
        humidList = HDAO.updateList();
        ModelAndView mav = new ModelAndView("humidity");
        mav.addObject("Humidity_List", humidList);
        return mav;
    }

    //Fetches electricity cost from the database and displays it in the browser
    @RequestMapping("/elecost")
    public ModelAndView electricity() throws IOException {
        elecList = EDAO.updateList();
        ModelAndView mav = new ModelAndView("electricitycost");
        mav.addObject("Elec_List", elecList);
        return mav;
    }

    //Fetches every datatype from the database and displays
    //a summary of it all in the browser
    @RequestMapping("/")
    public ModelAndView summary() throws IOException {
        sumList = SDAO.updateList();
        ModelAndView mav = new ModelAndView("summary");
        mav.addObject("Summary", sumList);
        return mav;
    }

    //When parameters from the form 'addelecost.html' have been recieved
    //we send a new object to the database and updates the right table.
    //It then redirects us back to the summary which has now been updated
    //thanks to our 'updateList()' method
    @RequestMapping("electricity/savecost")
    public ModelAndView saveCost(@ModelAttribute EleCost ec) throws IOException, NumberFormatException {

        EleCostDAO temp = new EleCostDAO();
        temp.addNewCost(ec);
        return new ModelAndView("redirect:/confirmed");
    }

    //At this url theres a form that you fill in that then sends the
    //parameters to the function 'saveCost'
    @RequestMapping("/addcost")
    public String addCost(Model model) {
        EleCost ec = new EleCost();
        model.addAttribute("elecost", ec);
        return "addelecost.html";
    }

    @RequestMapping("/confirmed")
    public String confirmed() {
        return "confirmed.html";
    }
}
