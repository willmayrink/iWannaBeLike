package com.willmayrink.iWannaBeLike.controller.training;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import com.willmayrink.iWannaBeLike.model.training.TrainingModel;
import com.willmayrink.iWannaBeLike.repository.rolemodel.RoleModelRepository;
import com.willmayrink.iWannaBeLike.repository.training.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class TrainingController {
    @Autowired
    private RoleModelRepository roleModelRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    //I went for a RESTFul approach, if you want to find the @Controller for the RoleModels, go for controller.rolemodel.RoleModelController
    @GetMapping("/role_models/{id}/trainings")
    public String viewTrainingsForRoleModel(@PathVariable Long id, Model model){
        Optional<RoleModel> optionalRoleModel = roleModelRepository.findById(id);
        if(optionalRoleModel.isPresent()){
            RoleModel roleModel = optionalRoleModel.get();
            List<TrainingModel> trainings = roleModel.getAssociatedTrainings();
            model.addAttribute("role_model", roleModel);
            model.addAttribute("trainings", trainings);
            return "trainingsPerRoleModel";
        }
        else {
            return "error";
        }
    }
}
