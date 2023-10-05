package com.proyecto.fabrica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fabrica {
    
    @Id
    @Column (name ="id_fabrica")
    private int idFabrica;
    private double presupuesto;
    @Column (name ="stock_piezas")
    private int stockPiezas;
    
    public Fabrica() {
    }

    public Fabrica(int idFabrica, double presupuesto, int stockPiezas) {
        this.idFabrica = idFabrica;
        this.presupuesto = presupuesto;
        this.stockPiezas = stockPiezas;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getStockPiezas() {
        return stockPiezas;
    }

    public void setStockPiezas(int stockPiezas) {
        this.stockPiezas = stockPiezas;
    }
    
    
    

    
}
