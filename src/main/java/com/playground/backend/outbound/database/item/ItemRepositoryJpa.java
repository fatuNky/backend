package com.playground.backend.outbound.database.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryJpa extends JpaRepository<ItemEntity, Long> {


}