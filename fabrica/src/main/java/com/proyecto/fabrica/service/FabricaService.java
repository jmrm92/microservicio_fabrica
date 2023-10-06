package com.proyecto.fabrica.service;

import java.util.List;

import com.proyecto.fabrica.model.Fabrica;

public interface FabricaService {
    List<Fabrica> fabricas();
    double consultarPresupuesto (int idFabrica);
    int consultarStockPiezas (int idFabrica);
    void actualizarPresupuesto (int idFabrica, double presupuesto);
    void actualizarStockPiezas (int idFabrica, int stockPiezas);
    void optimizarFabricacionModelo (int idModelo);
    void nuevaFabrica (Fabrica fabrica);
    void eliminarFabrica (int idFabrica);
    List<Fabrica> filtrarPorPresupuesto (double presupuestoMinimo, double presupuestoMaximo);
}
