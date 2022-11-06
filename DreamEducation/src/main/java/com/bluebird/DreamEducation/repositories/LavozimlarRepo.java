package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Lavozim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LavozimlarRepo extends JpaRepository<Lavozim, Long> {
}
