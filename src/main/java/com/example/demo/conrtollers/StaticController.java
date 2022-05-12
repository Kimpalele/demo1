package com.example.demo.conrtollers;

import com.example.demo.models.*;
import com.example.demo.repo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
public class StaticController {

    TempDAO TDAO;
    HumidDAO HDAO;
    EleCostDAO EDAO;
    SummaryDAO SDAO;

    {
    try {
        TDAO = new TempDAO();
        HDAO = new HumidDAO();
        EDAO = new EleCostDAO();
        SDAO = new SummaryDAO();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    List<Temp> tempList = TDAO.getList();
    List<Humid> humidList = HDAO.getList();
    List<EleCost> elecList = EDAO.getList();
    List<Summary> sumList = SDAO.getList();



    @RequestMapping("/temps")
    public ModelAndView temperature(){
        ModelAndView mav = new ModelAndView("temperature");
        mav.addObject("Temperature_List", tempList);
        return mav;
    }

    @RequestMapping("/humid")
    public ModelAndView humidity(){
        ModelAndView mav = new ModelAndView("humidity");
        mav.addObject("Humidity_List", humidList);
        return mav;
    }

    @RequestMapping("/elecost")
    public ModelAndView electricity(){
        ModelAndView mav = new ModelAndView("electricitycost");
        mav.addObject("Elec_List", elecList);
        System.out.println(sumList);
        return mav;
    }

    @RequestMapping("/")
    public ModelAndView summary(){
        ModelAndView mav = new ModelAndView("summary");
        mav.addObject("Summary", sumList);
        return mav;
    }

}
