package com.willmayrink.iWannaBeLike.controller.user;

import com.willmayrink.iWannaBeLike.model.user.UserModel;
import com.willmayrink.iWannaBeLike.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/my_stats")
    public String myStats(Model model, @AuthenticationPrincipal OAuth2User oauth2User){
        String oauthId = oauth2User.getAttribute("sub");
        Optional<UserModel> userModelOptional = userRepository.findByOauthId(oauthId);
        userModelOptional.ifPresent(user ->model.addAttribute("user",user));
        return "my_stats";
    }
}
