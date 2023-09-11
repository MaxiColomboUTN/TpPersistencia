package com.example.tp1PersistenciaColombo.repositorios;

import com.example.tp1PersistenciaColombo.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral,Long> {
}
