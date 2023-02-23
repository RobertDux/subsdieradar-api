package com.example.subsidieradar.data;

import com.example.subsidieradar.domain.Contactpersoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GebruikerRepository extends JpaRepository<Contactpersoon, Long> {
}
