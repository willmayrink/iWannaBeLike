package com.willmayrink.iWannaBeLike.model.user;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "active_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String oauthId;
    @Column(nullable = false)
    private String provider;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String realName;
    private Double height;
    private Double weight;
    private Integer chestMeasurement;
    private Integer shouldersMeasurement;
    private Integer bicepsMeasurement;
    private Integer waistMeasurement;
    private boolean active = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer age;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name= "user_role_model",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_model_id")
    )
    private List<RoleModel> followedRoleModels;
}
