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

    TempDAO TDAO = new TempDAO();
    HumidDAO HDAO = new HumidDAO();
    SummaryDAO SDAO = new SummaryDAO();
    EleCostDAO EDAO = new EleCostDAO();

    List<Temp> tempList;
    List<Humid> humidList;
    List<Summary> sumList;
    List<EleCost> elecList;


    @RequestMapping("/temps")
    public ModelAndView temperature() throws IOException {
        tempList = TDAO.updateList();
        ModelAndView mav = new ModelAndView("temperature");
        mav.addObject("Temperature_List", tempList);
        return mav;
    }

    @RequestMapping("/humid")
    public ModelAndView humidity() throws IOException {
        humidList = HDAO.updateList();
        ModelAndView mav = new ModelAndView("humidity");
        mav.addObject("Humidity_List", humidList);
        return mav;
    }

    @RequestMapping("/elecost")
    public ModelAndView electricity() throws IOException {
        elecList = EDAO.updateList();
        ModelAndView mav = new ModelAndView("electricitycost");
        mav.addObject("Elec_List", elecList);
        return mav;
    }

    @RequestMapping("/")
    public ModelAndView summary() throws IOException {
        sumList = SDAO.updateList();
        ModelAndView mav = new ModelAndView("summary");
        mav.addObject("Summary", sumList);
        return mav;
    }

    @RequestMapping("electricity/savecost")
    public ModelAndView saveCost(@ModelAttribute EleCost ec) throws IOException {
        EleCostDAO temp = new EleCostDAO();
        temp.addNewCost(ec);
        return new ModelAndView();

    }

    @RequestMapping("/addcost")
    public String addCost(Model model){
        EleCost ec = new EleCost();
        model.addAttribute("elecost", ec);
        return "addelecost.html";
    }

}
