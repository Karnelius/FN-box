package com.mycompany.box;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/boxes/save")
    public String saveBox(Box box){
        service.save(box);

        return "redirect:/boxes";
    }


    /*
    @PostMapping("boxes/save")
    public String saveBox(Box box){
        float cost;
        if (box.getCountry().equals("1")) {
            cost = box.getWeight() * 1,3f;

        }else if (box.getCountry().equals("2")){
            cost = box.getWeight() * 2.5f;

        }else if(box.getCountry().equals("3")){
            cost = box.getWeight() * 3,5f;

        } else if(box.getCountry().equals("4")){
            cost = box.getWeight() * 5,5f;
        }
        service.save(box);

        return "redirect:/boxes";

    }




    @PostMapping("/boxes/save")
    public String saveBox(BoxForm box){
        float cost = 0;

        float swe = 1.3f;
        float chi = 2.5f;
        float bra = 3.4f;
        float aus = 5.5f;

        if (box.getCountry().equals("1")) {
            cost = box.getWeight() * swe;

        }else if(box.getCountry().equals("2")){
            cost = box.getWeight() * chi;


        }else if(box.getCountry().equals("3")){
            cost = box.getWeight() * bra;


        } else if(box.getCountry().equals("4")){
            cost = box.getWeight() * aus;


        }
        Box new_box = new Box();
        new_box.setReciever(box.getReciever());
        new_box.setColor(box.getColor());
        new_box.setCost(cost);
        new_box.setWeight(box.getWeight());

        service.save(new_box);

        return "redirect:/boxes";
    }
 */


}
