package com.example.subsidieradar.data;

import com.example.subsidieradar.domain.Subsidie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsidieRepository extends JpaRepository<Subsidie, String> {
    Subsidie findByNaam(String name);
}
