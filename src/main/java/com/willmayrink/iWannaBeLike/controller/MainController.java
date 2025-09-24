package com.willmayrink.iWannaBeLike.controller;

import com.willmayrink.iWannaBeLike.repository.rolemodel.RoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    RoleModelRepository roleModelRepository;

    @RequestMapping("/")
    public String listAllModels(){
        return "templateLogin";
    }
    @GetMapping("/role_models")
    public String firstPage(Model model){
        model.addAttribute("role_model", roleModelRepository.findAll());
        return "listAll";
    }
    @GetMapping("/login-custom")
    public String viewLoginPage(){
        return  "templateLogin";
    }
}
