package com.willmayrink.iWannaBeLike.controller;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import com.willmayrink.iWannaBeLike.repository.rolemodel.RoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role_models")
public class MainRestController {

    private final RoleModelRepository repository;

    @Autowired
    public MainRestController(RoleModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<RoleModel>> getAllRoleModels() {
        List<RoleModel> roleModels = repository.findAll();
        return ResponseEntity.ok(roleModels);
    }
}
