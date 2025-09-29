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
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/update_stats")
    public String updateMyStats(@AuthenticationPrincipal OAuth2User oauth2User,
                                Model model,
                                @RequestParam Double height,
                                @RequestParam Double weight,
                                @RequestParam Integer age,
                                @RequestParam Integer bicepsMeasurement,
                                @RequestParam Integer shouldersMeasurement,
                                @RequestParam Integer chestMeasurement,
                                @RequestParam Integer waistMeasurement) {
        String oauthId = oauth2User.getAttribute("sub");
        Optional<UserModel> userModelOptional = userRepository.findByOauthId(oauthId);

        if (userModelOptional.isPresent()) {
            UserModel userModel = userModelOptional.get();
            userModel.setBicepsMeasurement(bicepsMeasurement);
            userModel.setShouldersMeasurement(shouldersMeasurement);
            userModel.setChestMeasurement(chestMeasurement);
            userModel.setWaistMeasurement(waistMeasurement);
            userModel.setHeight(height);
            userModel.setWeight(weight);
            userModel.setAge(age);
            userRepository.save(userModel);

            // Adiciona o usuário atualizado ao modelo
            model.addAttribute("user", userModel);
        } else {
            // Lidar com o caso de usuário não encontrado.
            // Poderia redirecionar para uma página de erro ou criar um novo usuário.
            // Exemplo: model.addAttribute("error", "Usuário não encontrado.");
            // return "error_page";
        }

        return "my_stats";
    }
}
