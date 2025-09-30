package com.willmayrink.iWannaBeLike.repository.training;

import com.willmayrink.iWannaBeLike.model.training.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingModel, Long> {
}
