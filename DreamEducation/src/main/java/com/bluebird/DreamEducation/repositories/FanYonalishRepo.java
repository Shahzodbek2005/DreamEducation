package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.FanYonalish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FanYonalishRepo extends JpaRepository<FanYonalish, Long> {
    @Query(value = "select count(*) as soni from fan_yonalish where fan_id = :fID and yonalish_id=:yID", nativeQuery = true)
    Integer checkExists(Long fID, Long yID);
}
