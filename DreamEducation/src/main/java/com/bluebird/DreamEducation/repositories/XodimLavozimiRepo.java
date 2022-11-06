package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.FanYonalish;
import com.bluebird.DreamEducation.entities.XodimLavozimi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XodimLavozimiRepo extends JpaRepository<XodimLavozimi, Long> {
    @Query(value = "select count(*) as soni from xodim_lavozimi where lavozim_id = :lID and xodim_id = :xID", nativeQuery = true)
    Integer checkExists(Long lID, Long xID);
}