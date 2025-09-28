package com.willmayrink.iWannaBeLike.service.user;

import com.willmayrink.iWannaBeLike.model.user.UserModel;
import com.willmayrink.iWannaBeLike.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserModel> findByOauthId(String oauthId){
        return userRepository.findByOauthId(oauthId);
    }
    public Optional<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public UserModel save(UserModel user){
        return userRepository.save(user);
    }
}
