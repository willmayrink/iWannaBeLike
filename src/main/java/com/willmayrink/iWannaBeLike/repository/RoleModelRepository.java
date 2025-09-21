package com.willmayrink.iWannaBeLike.repository;

import com.willmayrink.iWannaBeLike.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {

    @Query("SELECT rm FROM RoleModel rm WHERE UPPER(rm.category) = 'ANIME' ORDER BY rm.origin")
    List<RoleModel> findAnimeRoleModels();

}
