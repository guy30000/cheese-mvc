package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping(value = "cheese")  // Makes requesse path localhost-port/cheese
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();
    static ArrayList<String> cheese_Discription = new ArrayList<>(); //added this line to get desctiptions
    HashMap<String, String> cheese_n_description = new HashMap<>(); //Hashing with descriptions

    // Request path: cheese/
    @RequestMapping(value = "")
    public String index(Model model) {

        // ArrayList<String> cheeses = new ArrayList<>(); This moved above adding "static" proceding it



        model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheese_Discription", cheese_Discription); //added this line to get desctiptions
        model.addAttribute("cheese_n_description", cheese_n_description);
        model.addAttribute("title", "My Cheeses");  //this passes info into the index template
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String proceessAddCheeseform(@RequestParam String cheeseName, String cheese_disc) {
    /*  Alt way to do line above
    public String proceessAddCheeseform(HttpServletRequest request) {
        String cheeseName = request.getParameter("cheeseName"); */
        cheese_n_description.put(cheeseName, cheese_disc);
        cheeses.add(cheeseName);
        cheese_Discription.add(cheese_disc);   //added this line to get desctiptions
        //redirectes to cheese handler
        return "redirect:";

    }

    //Studio, adding crossoff
    /*
    @RequestMapping(value = "crossoff", method = RequestMethod.GET)
    public String displayCrossoffCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/crossoff";

    }
    */


}
