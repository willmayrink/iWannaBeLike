package com.willmayrink.iWannaBeLike.repository.rolemodel;

import com.willmayrink.iWannaBeLike.model.rolemodel.RoleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {

    @Query("SELECT rm FROM RoleModel rm WHERE UPPER(rm.category) = 'ANIME' ORDER BY rm.origin")
    List<RoleModel> findAnimeRoleModels();

    @Query("SELECT rm FROM RoleModel rm ORDER BY RANDOM()")
    Page<RoleModel> findRandomModels (Pageable pageable);
}
