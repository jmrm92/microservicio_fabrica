package com.proyecto.fabrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.fabrica.dao.FabricaDao;
import com.proyecto.fabrica.model.Fabrica;

@Service
public class FabricaServiceImpl implements FabricaService {

    @Autowired
    FabricaDao dao;

    @Override
    public List<Fabrica> fabricas() {
        return dao.findAll();
    }

    @Override
    public void actualizarPresupuesto(int idFabrica, double presupuesto) {
        dao.findById(idFabrica).get().setPresupuesto(presupuesto);
    }

    @Override
    public void actualizarStockPiezas(int idFabrica, int stockPiezas) {
        dao.findById(idFabrica).get().setStockPiezas(stockPiezas);
    }

    @Override
    public void nuevaFabrica(Fabrica fabrica) {
        dao.save(fabrica);
    }

    @Override
    public double consultarPresupuesto(int idFabrica) {
        return dao.findById(idFabrica).get().getPresupuesto();
    }

    @Override
    public int consultarStockPiezas(int idFabrica) {
        return dao.findById(idFabrica).get().getStockPiezas();
    }
    
}
