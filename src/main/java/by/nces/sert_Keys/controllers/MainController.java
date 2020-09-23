package by.nces.sert_Keys.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Value("${role.values}")
    private List<String> role;
    @Value("${type.values}")
    private List<String> type;
    @Value("${signatureAlgorithm.values}")
    private List<String> signatureAlgorithm;


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
    public String info()
    {
        return "info";
    }

    @GetMapping("/createKeys")
    public String createKeys(Model model)
    {
        model.addAttribute("role",role);
        model.addAttribute("type",type);
        model.addAttribute("signatureAlgorithm", signatureAlgorithm);
        return "createKeys";
    }


}
