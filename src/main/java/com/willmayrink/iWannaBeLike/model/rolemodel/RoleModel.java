package com.willmayrink.iWannaBeLike.model.rolemodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "role_models", schema = "iwannabelike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "categoria", nullable = false, length = 20)
    private String category;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "origem", nullable = false, length = 100)
    private String origin;

    @Column(name = "idade")
    private String age;

    @Column(name = "altura")
    private Integer height;

    @Column(name = "peso")
    private Integer weight;

    @Column(name = "peito_cm")
    private Integer chestMeasurement;

    @Column(name = "ombros_cm")
    private Integer shouldersMeasurement;

    @Column(name = "biceps_cm")
    private Integer bicepsMeasurement;

    @Column(name = "cintura_cm")
    private Integer waistMeasurement;

    @Column(name = "descricao_fisico", columnDefinition = "TEXT")
    private String physiqueDescription;

    @Column(name = "realismo_fisico")
    private String physiqueRealistic;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String icon_rolemodel;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
