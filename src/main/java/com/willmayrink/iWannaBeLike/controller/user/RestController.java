package com.willmayrink.iWannaBeLike.controller.user;


import com.willmayrink.iWannaBeLike.model.user.UserModel;
import com.willmayrink.iWannaBeLike.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/users")
public class RestController {

    private final UserRepository userRepository;

    @Autowired
    public RestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        List<UserModel> userModels = userRepository.findAll();
        return ResponseEntity.ok(userModels);
    }
}
