package com.willmayrink.iWannaBeLike.service.trainings;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import com.willmayrink.iWannaBeLike.model.training.TrainingModel;
import com.willmayrink.iWannaBeLike.repository.training.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepository;

    public List<TrainingModel> getTrainingsFromRoleModel(RoleModel roleModel){
        List<TrainingModel> trainingModelOptional = roleModel.getAssociatedTrainings();
                    return trainingModelOptional;
    }


}
