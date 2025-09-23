package com.willmayrink.iWannaBeLike.service.rolemodel;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import com.willmayrink.iWannaBeLike.repository.rolemodel.RoleModelRepository;
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
