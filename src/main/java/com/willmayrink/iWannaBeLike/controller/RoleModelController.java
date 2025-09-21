package com.willmayrink.iWannaBeLike.controller;

import com.willmayrink.iWannaBeLike.model.RoleModel;
import com.willmayrink.iWannaBeLike.repository.RoleModelRepository;
import com.willmayrink.iWannaBeLike.service.RoleModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.relation.Role;
import java.util.List;

@Controller
public class RoleModelController {

    private final RoleModelRepository roleModelRepository;
    private final RoleModelService roleModelService;

    // Construtor com a dependência injetada
    public RoleModelController(RoleModelRepository roleModelRepository , RoleModelService roleModelService) {
        this.roleModelRepository = roleModelRepository;
        this.roleModelService = roleModelService;
    }

    @GetMapping("/role_models/{id}")
    public String findRoleModelById(@PathVariable("id") Long id, Model model) {
        roleModelRepository.findById(id).ifPresentOrElse(
                roleModel -> model.addAttribute("role_model", roleModel),
                () -> model.addAttribute("error", "Role model não encontrado")
        );
        return "viewRoleModel";
    }

    @GetMapping("/role_models/anime")
    public String findAnimeModels(Model model) {
        List<RoleModel> animeRoleModels = roleModelService.getAnimeRoleModels();
        model.addAttribute("anime_models", animeRoleModels);
        return "categoryView";
    }
}