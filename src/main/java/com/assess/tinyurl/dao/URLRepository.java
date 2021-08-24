package com.assess.tinyurl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assess.tinyurl.entity.URLEntity;

@Repository
public interface URLRepository extends JpaRepository<URLEntity, Integer> {
}