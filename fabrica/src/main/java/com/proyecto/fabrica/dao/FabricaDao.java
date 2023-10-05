package com.proyecto.fabrica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.fabrica.model.Fabrica;

public interface FabricaDao extends JpaRepository <Fabrica, Integer> {
    
}
