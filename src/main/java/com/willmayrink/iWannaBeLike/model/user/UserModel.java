package com.willmayrink.iWannaBeLike.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "active_users", schema = "iwannabelike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(length = 12)
    private String realName;
    @Column(nullable = false)
    private Integer height;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    private Integer chestMeasurement;
    @Column(nullable = false)
    private Integer shouldersMeasurement;
    @Column(nullable = false)
    private Integer bicepsMeasurement;
    @Column(nullable = false)
    private Integer waistMeasurement;

}
