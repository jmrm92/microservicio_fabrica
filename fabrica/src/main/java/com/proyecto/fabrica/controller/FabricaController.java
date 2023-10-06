package com.proyecto.fabrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    /**
     * La función "obtenerFabricas" devuelve una lista de objetos "Fabricas" en formato JSON.
     * 
     * @return Se devuelve una lista de objetos de Fabrica.
     */
    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabrica> obtenerFabricas() {
        return servicio.fabricas();
    }

    /**
     * Esta función Java devuelve el presupuesto para un ID de fábrica determinado en formato JSON.
     * 
     * @param idFabrica El parámetro idFabrica es un número entero que representa el ID de una fábrica.
     * @return El método devuelve un valor doble, que representa el presupuesto (presupuesto) de una
     * fábrica con el id dado.
     */
    @GetMapping (value = "/presupuesto/{idFabrica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double presupuesto(@PathVariable("idFabrica") int idFabrica) {
        return servicio.consultarPresupuesto(idFabrica);
    }

    /**
     * La función "stockPiezas" devuelve el stock de piezas para un determinado ID de fábrica.
     * 
     * @param idFabrica El parámetro "idFabrica" es un valor entero que representa el ID de una
     * fábrica.
     * @return El método devuelve un valor entero, que representa el stock de piezas para una
     * identificación de fábrica determinada.
     */
    @GetMapping (value = "/stock-piezas/{idFabrica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int stockPiezas(@PathVariable("idFabrica") int idFabrica) {
        return servicio.consultarStockPiezas(idFabrica);
    }

    /**
     * Esta función de Java filtra una lista de objetos "Fabrica" en función de un presupuesto mínimo y
     * máximo.
     * 
     * @param presupuestoMinimo El valor de presupuesto mínimo para el filtrado.
     * @param presupuestoMaximo El presupuesto máximo para filtrar la lista de objetos "Fabrica".
     * @return El método devuelve una lista de objetos de tipo "Fabrica".
     */
    @GetMapping (value = "/filtro-presupuesto/{presupuestoMinimo}/{presupuestoMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabrica> filtrarPorPresupuesto(@PathVariable("presupuestoMinimo") double presupuestoMinimo, @PathVariable("presupuestoMaximo") double presupuestoMaximo) {
        return servicio.filtrarPorPresupuesto(presupuestoMinimo, presupuestoMaximo);
    }

    /**
     * Esta función de Java maneja una solicitud POST para crear un nuevo objeto "Fabrica" consumiendo
     * datos JSON.
     * 
     * @param fabrica El parámetro "fabrica" es de tipo "Fabrica" y está anotado con "@RequestBody".
     * Representa el cuerpo de la solicitud JSON que se convertirá en un objeto Fabrica y se pasará al
     * método "nuevaFabrica" del objeto "servicio".
     */
    @PostMapping (value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevaFabrica(@RequestBody Fabrica fabrica) {
        servicio.nuevaFabrica(fabrica);
    }

    /**
     * La función anterior es un método Java que actualiza el stock de piezas de una fábrica
     * determinada.
     * 
     * @param idFabrica El ID de la fábrica para la cual se necesita actualizar el stock de piezas.
     * @param stockPiezas El parámetro "stockPiezas" representa la nueva cantidad de stock de un
     * artículo en particular en una fábrica.
     */
    @PutMapping (value = "actualizacion-stock-piezas/{idFabrica}/{stockPiezas}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarStockPiezas(@PathVariable("idFabrica") int idFabrica, @PathVariable("stockPiezas") int stockPiezas) {
        servicio.actualizarStockPiezas(idFabrica, stockPiezas);
    }

    /**
     * La función "actualizarPresupuesto" actualiza el presupuesto de una fábrica con el ID dado.
     * 
     * @param idFabrica La identificación de la fábrica que necesita ser actualizada.
     * @param presupuesto El parámetro "presupuesto" es de tipo doble y representa el nuevo valor del
     * presupuesto a actualizar para una fábrica.
     */
    @PutMapping (value = "actualizacion-presupuesto/{idFabrica}/{presupuesto}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarPresupuesto(@PathVariable("idFabrica") int idFabrica, @PathVariable("presupuesto") double presupuesto) {
        servicio.actualizarPresupuesto(idFabrica, presupuesto);
    }

    /**
     * La función optimiza el proceso de fabricación para un modelo determinado.
     * 
     * @param idModelo La identificación del modelo que debe optimizarse para la fabricación.
     */
    @PutMapping (value = "optimizacion/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void optimizar(@PathVariable("idModelo") int idModelo) {
        servicio.optimizarFabricacionModelo(idModelo);
    }

  /**
   * Esta función de Java elimina una fábrica según su ID.
   * 
   * @param idFabrica La identificación de la fábrica que debe eliminarse.
   */
    @DeleteMapping (value = "/{idFabrica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarFabrica(@PathVariable("idFabrica") int idFabrica) {
        servicio.eliminarFabrica(idFabrica);
    }
}
