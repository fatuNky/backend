package com.playground.backend.outbound.database.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepositoryJpa extends JpaRepository<TagEntity, Long> {


}