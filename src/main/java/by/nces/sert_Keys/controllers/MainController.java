package by.nces.sert_Keys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "smt");
        return "index";
    }
    @GetMapping("/hsm")
    public String hsm(){
        return "hsm";
    }
    @GetMapping("/info")
    public String info(){
        return "info";
    }
    @GetMapping("/createKeys")
    public String createKeys(){
        return "createKeys";
    }

}
