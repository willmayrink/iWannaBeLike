package com.willmayrink.iWannaBeLike.model.rolemodel;

import com.willmayrink.iWannaBeLike.model.training.TrainingModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "role_models")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 20)
    private String category;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String origin;
    private Integer age;
    private String icon_rolemodel;
    private Double height;
    private Integer weight;
    private Integer chestMeasurement;
    private Integer shouldersMeasurement;
    private Integer bicepsMeasurement;
    private Integer waistMeasurement;
    private String physiqueRealistic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Column(columnDefinition = "TEXT")
    private String physiqueDescription;
    @ManyToMany(mappedBy = "associatedRoleModels")
    private List<TrainingModel> associatedTrainings;
}
