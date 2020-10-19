package by.nces.sert_Keys.controllers;

import by.nces.sert_Keys.models.CertSetModel;
import by.nces.sert_Keys.repo.CertSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

}
