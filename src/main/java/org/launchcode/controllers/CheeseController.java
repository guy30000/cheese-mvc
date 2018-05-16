package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping(value = "cheese")  // Makes requesse path localhost-port/cheese
public class CheeseController {

    // Request path: cheese/
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "My Cheeses");  //this passes info into the index template
        return "cheese/index";
    }
}
