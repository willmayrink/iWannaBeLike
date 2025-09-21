package com.willmayrink.iWannaBeLike.service;

import com.willmayrink.iWannaBeLike.model.RoleModel;
import com.willmayrink.iWannaBeLike.repository.RoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleModelService {

    @Autowired
    RoleModelRepository roleModelRepository;

    public List<RoleModel> getAnimeRoleModels(){
        return roleModelRepository.findAnimeRoleModels();
    }
}
