package com.proyecto.fabrica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "fabricas")
public class Fabrica {
    
    @Id
    @Column (name ="id_fabrica")
    private int idFabrica;
    private double presupuesto;
    @Column (name ="stock_piezas")
    private int stockPiezas;
    
    public Fabrica() {
    }

    public Fabrica(double presupuesto, int stockPiezas) {
        this.presupuesto = presupuesto;
        this.stockPiezas = stockPiezas;
    }

    /**
     * Obtiene el ID de la fábrica.
     *
     * @return El ID de la fábrica.
     */
    public int getIdFabrica() {
        return idFabrica;
    }

    /**
     * Establece el ID de la fábrica.
     *
     * @param idFabrica El nuevo ID de la fábrica.
     */
    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    /**
     * Obtiene el presupuesto.
     *
     * @return El presupuesto actual.
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Establece el presupuesto.
     *
     * @param presupuesto El nuevo presupuesto.
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Obtiene el stock de piezas.
     *
     * @return La cantidad de piezas en stock.
     */
    public int getStockPiezas() {
        return stockPiezas;
    }

    /**
     * Establece el stock de piezas.
     *
     * @param stockPiezas La nueva cantidad de piezas en stock.
     */
    public void setStockPiezas(int stockPiezas) {
        this.stockPiezas = stockPiezas;
    }  
}
