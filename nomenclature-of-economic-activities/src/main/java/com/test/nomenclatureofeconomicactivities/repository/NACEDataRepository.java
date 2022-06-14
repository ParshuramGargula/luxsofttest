package com.test.nomenclatureofeconomicactivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nomenclatureofeconomicactivities.model.NACEData;

public interface NACEDataRepository extends JpaRepository<NACEData, Long> {

}
