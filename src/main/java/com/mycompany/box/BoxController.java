package com.mycompany.box;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Controller
public class BoxController {

    @Autowired
    private BoxService service;

    @GetMapping("/boxes")
        public String showAllBoxes (Model model){
        List<Box> listBoxes = service.listAll();
        model.addAttribute("listBoxes",listBoxes);

        return "boxes";
    }

    @GetMapping("/boxes/new")
    public String showNewBoxForm (Model model){
        model.addAttribute("box",new Box());

        return "box-form";
    }


}
