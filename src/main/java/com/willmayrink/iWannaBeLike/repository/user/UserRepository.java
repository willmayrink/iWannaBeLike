package com.willmayrink.iWannaBeLike.repository.user;

import com.willmayrink.iWannaBeLike.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByOauthId(String oauthId);
    Optional<UserModel> findByEmail(String email);
}
