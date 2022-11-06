package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Xodimlar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XodimlarRepo extends JpaRepository<Xodimlar, Long> {
}
