package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Yonalish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YonalishRepo extends JpaRepository<Yonalish, Long> {
}
