package com.willmayrink.iWannaBeLike.controller.user;

import com.willmayrink.iWannaBeLike.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/my_stats")
    public String myStats(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userRepository.findById(id));
        return "myStats";
    }
}
