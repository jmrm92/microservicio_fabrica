package com.proyecto.fabrica.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.fabrica.dao.FabricaDao;
import com.proyecto.fabrica.model.Fabrica;
import com.proyecto.fabrica.model.Modelo;

@Service
public class FabricaServiceImpl implements FabricaService {

    @Autowired
    FabricaDao dao;

    @Autowired
    RestTemplate template;

    String urlModelo = "http://localhost:8080/";

    /**
     * La función devuelve una lista de todas las fabricas del dao.
     * 
     * @return El método devuelve una Lista de objetos de tipo "Fabrica".
     */
    @Override
    public List<Fabrica> fabricas() {
        return dao.findAll();
    }

    /**
     * La función actualiza el presupuesto de una fábrica con el ID proporcionado.
     * 
     * @param idFabrica El ID de la fábrica cuyo presupuesto debe actualizarse.
     * @param presupuesto El parámetro "presupuesto" es un valor doble que representa el presupuesto
     * actualizado de una fábrica.
     */
    @Override
    public void actualizarPresupuesto(int idFabrica, double presupuesto) {
        Fabrica fabrica = dao.findById(idFabrica).get();
        fabrica.setPresupuesto(presupuesto);
        dao.save(fabrica);
    }

    /**
     * La función actualiza el stock de piezas de una fábrica determinada.
     * 
     * @param idFabrica El ID de la fábrica para la cual desea actualizar el stock de piezas.
     * @param stockPiezas El parámetro "stockPiezas" representa la cantidad de stock actualizada de una
     * fábrica en particular.
     */
    @Override
    public void actualizarStockPiezas(int idFabrica, int stockPiezas) {
        Fabrica fabrica = dao.findById(idFabrica).get();
        fabrica.setStockPiezas(stockPiezas);
        dao.save(fabrica);
    }

    /**
     * La función guarda un nuevo objeto de fábrica en la base de datos.
     * 
     * @param fabrica El parámetro "fabrica" es un objeto de tipo "Fabrica".
     */
    @Override
    public void nuevaFabrica(Fabrica fabrica) {
        dao.save(fabrica);
    }

    /**
     * La función "consultarPresupuesto" devuelve el presupuesto de una fábrica dado su ID.
     * 
     * @param idFabrica El parámetro "idFabrica" es un número entero que representa el ID de una
     * fábrica.
     * @return El método está devolviendo un valor doble, que es el presupuesto (presupuesto) de la
     * fábrica con el id dado.
     */
    @Override
    public double consultarPresupuesto(int idFabrica) {
        return dao.findById(idFabrica).get().getPresupuesto();
    }

    /**
     * La función "consultarStockPiezas" devuelve el stock de piezas para un determinado ID de fábrica.
     * 
     * @param idFabrica El id de la fábrica de la que se quiere consultar el stock de piezas.
     * @return El método devuelve un valor entero, que representa el stock de piezas para una
     * identificación de fábrica determinada.
     */
    @Override
    public int consultarStockPiezas(int idFabrica) {
        return dao.findById(idFabrica).get().getStockPiezas();
    }

    /**
     * La función "eliminarFabrica" elimina un registro de la base de datos basándose en el "idFabrica"
     * proporcionado.
     * 
     * @param idFabrica El parámetro "idFabrica" es un número entero que representa el ID de la fábrica
     * (fábrica) que debe eliminarse.
     */
    @Override
    public void eliminarFabrica(int idFabrica) {
        dao.deleteById(idFabrica);
    }

    /**
     * La función optimiza la fabricación de un modelo específico actualizando su costo y piezas
     * requeridas.
     * 
     * @param idModelo El parámetro "idModelo" es un número entero que representa el identificador
     * único de un modelo.
     */
    @Override
    public void optimizarFabricacionModelo(int idModelo) {
        List<Modelo> modelos = Arrays.asList(template.getForObject(urlModelo, Modelo[].class));
        for (Modelo modelo : modelos) {
            if (modelo.getIdModelo() == idModelo) {
                template.put(urlModelo + "actualizar-coste/" + idModelo + "/" + (modelo.getCoste() - 1000.00), modelo);
                template.put(urlModelo + "actualizar-piezas-necesarias/" + idModelo  + "/" + (modelo.getPiezasNecesarias() - 100), modelo);
            }
        }
    }

    /**
     * La función filtra una lista de objetos "Fabrica" en función de un presupuesto mínimo y máximo.
     * 
     * @param presupuestoMinimo El presupuesto mínimo para filtrar la lista de objetos de Fabrica.
     * @param presupuestoMaximo El presupuesto máximo para filtrar la lista de objetos "Fabrica".
     * @return El método devuelve una Lista de objetos de tipo "Fabrica".
     */
    @Override
    public List<Fabrica> filtrarPorPresupuesto(double presupuestoMinimo, double presupuestoMaximo) {
        return dao.filtrarPorPresupuesto(presupuestoMinimo, presupuestoMaximo);
    } 
}
