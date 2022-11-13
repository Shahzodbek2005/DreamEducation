package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.TraceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceRepository extends JpaRepository<TraceModel, Long> {}
