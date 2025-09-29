package com.willmayrink.iWannaBeLike.model.training;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainings")
public class TrainingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String muscleGroup;
    private Integer numberSeries;
    private Integer numberRepetitions;
    private Integer minWeightLoad;

    @ManyToMany
    @JoinTable(
            name="role_model_training",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "role_model_id")
    )
    private List<RoleModel> associatedRoleModels;

}
