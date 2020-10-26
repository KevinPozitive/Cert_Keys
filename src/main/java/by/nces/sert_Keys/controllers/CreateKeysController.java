package by.nces.sert_Keys.controllers;


import by.nces.sert_Keys.core.logic.CheckData;
import by.nces.sert_Keys.core.service.impl.CreateCertImpl;
import by.nces.sert_Keys.models.CertSetModel;
import by.nces.sert_Keys.models.MembersModel;
import by.nces.sert_Keys.repo.CertSetRepo;
import by.nces.sert_Keys.repo.MembersRepo;
import by.nces.sert_Keys.serverPart.connect.ClientConnect;
import by.nces.sert_Keys.serverPart.connect.Control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateKeysController extends Control {
    @Value("${role.values}")
    private List<String> role;
    @Value("${type.values}")
    private List<String> type;
    @Value("${signatureAlgorithm.values}")
    private List<String> signatureAlgorithm;
    private  ClientConnect clientConnect;
    private CheckData checkData;

    public CreateKeysController(ClientConnect clientConnect) {
        checkData = new CheckData();
        this.clientConnect = clientConnect;
    }


    @DateTimeFormat(pattern = "YYYY-MM-DD")

    @GetMapping("/createKeys")
    public String createKeys(Model model)
    {
        model.addAttribute("role",role);
        model.addAttribute("type",type);
        model.addAttribute("signatureAlgorithm", signatureAlgorithm);
        return "createKeys";
    }

    @Autowired
    private CertSetRepo certSetRepo;
    @Autowired
    private MembersRepo membersRepo;

    private String[] stringSplit(String string){
        String[] array = string.split(",");
        return array;
    }
    @PostMapping("/createKeys")
    public String CertSetAdd(@RequestParam String typeCert,@RequestParam String country, @RequestParam String nameUC,
                             @RequestParam int numb, @RequestParam String algEncrypt,
                             @RequestParam String role, @RequestParam String type,
                             @RequestParam String signatureAlgorithm, @RequestParam String startDate,
                             @RequestParam String endDate, Model model,
                             @RequestParam String firstName, @RequestParam String secondName,
                             @RequestParam String lastName, @RequestParam String organ,
                             @RequestParam String position, @RequestParam String reason) throws ParseException, IOException {
        CertSetModel certSet = new CertSetModel(country, nameUC, numb, algEncrypt, role, type, signatureAlgorithm, startDate, endDate);
        checkData.request(certSet.getData(), typeCert);
        clientConnect.setConnect();
        Control.serverInteraction.sendMessage(certSet.getData(), typeCert);
        List<MembersModel> membersModels = new ArrayList<>();
        for(int i = 0; i<stringSplit(firstName).length;i++){
            System.out.println(stringSplit(firstName)[i] + i);
            membersModels.add(new MembersModel(stringSplit(firstName)[i], stringSplit(secondName)[i],
                    stringSplit(lastName)[i], stringSplit(organ)[i],
                            stringSplit(position)[i], stringSplit(reason)[i],
                                    certSet.getId()));
        }
        certSet.setMembersModels(membersModels);
        certSetRepo.save(certSet);
        return"redirect:/info";
    }
}
