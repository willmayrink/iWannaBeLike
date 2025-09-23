package com.willmayrink.iWannaBeLike.repository.user;

import com.willmayrink.iWannaBeLike.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
