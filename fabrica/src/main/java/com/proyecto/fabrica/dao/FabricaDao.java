package com.proyecto.fabrica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.fabrica.model.Fabrica;

public interface FabricaDao extends JpaRepository <Fabrica, Integer> {
    
    @Query("SELECT f FROM Fabrica f WHERE f.presupuesto BETWEEN :presupuestoMinimo AND :presupuestoMaximo")
    List<Fabrica> filtrarPorPresupuesto(@Param("presupuestoMinimo") double presupuestoMinimo, 
                                          @Param("presupuestoMaximo") double presupuestoMaximo);
}
