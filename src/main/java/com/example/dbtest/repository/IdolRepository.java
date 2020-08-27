package com.example.dbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dbtest.entity.Idol;

@Repository
public interface IdolRepository extends JpaRepository<Idol, Integer> {
}