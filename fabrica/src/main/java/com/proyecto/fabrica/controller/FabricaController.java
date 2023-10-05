package com.proyecto.fabrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.fabrica.model.Fabrica;
import com.proyecto.fabrica.service.FabricaServiceImpl;

@RestController
public class FabricaController {
    
    @Autowired
    FabricaServiceImpl servicio;

    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabrica> obtenerFabricas() {
        return servicio.fabricas();
    }

    @GetMapping (value = "/presupuesto/{idFabrica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double presupuesto(@PathVariable("idFabrica") int idFabrica) {
        return servicio.consultarPresupuesto(idFabrica);
    }

    @GetMapping (value = "/stockPiezas/{idFabrica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int stockPiezas(@PathVariable("idFabrica") int idFabrica) {
        return servicio.consultarStockPiezas(idFabrica);
    }

    @PostMapping (value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevaFabrica(@RequestBody Fabrica fabrica) {
        servicio.nuevaFabrica(fabrica);
    }

    @PutMapping (value = "/{idFabrica}/{piezasNecesarias}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarStockPiezas(@PathVariable("idFabrica") int idFabrica, @PathVariable("piezasNecesarias") int piezasNecesarias) {
        servicio.actualizarStockPiezas(idFabrica, piezasNecesarias);
    }

    @PutMapping (value = "/{idFabrica}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarPresupuesto(@PathVariable("idFabrica") int idFabrica, @PathVariable("presupuesto") double presupuesto) {
        servicio.actualizarPresupuesto(idFabrica, presupuesto);
    }
}
