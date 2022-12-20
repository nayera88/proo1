package com.example.demo.Repo;

import com.example.demo.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StationRepo extends JpaRepository<Station ,Long> {
}
