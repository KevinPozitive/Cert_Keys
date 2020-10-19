package by.nces.sert_Keys.controllers;

import by.nces.sert_Keys.models.CertSetModel;
import by.nces.sert_Keys.models.MembersModel;
import by.nces.sert_Keys.repo.CertSetRepo;
import org.apache.tomcat.util.net.jsse.PEMFile;
import org.apache.tomcat.util.net.openssl.OpenSSLConfCmd;
import org.apache.tomcat.util.net.openssl.OpenSSLEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.KeyPairGenerator;
import java.util.Set;

@Controller
public class InfoController {
    @Autowired
    private CertSetRepo SertSet;

    @GetMapping("/info")
    public String info(
            Model model, Model model2)
    {
        
        Iterable<CertSetModel> certSets = SertSet.findAll();
        model.addAttribute("CertSets",certSets);
        return "info";
    }
}
