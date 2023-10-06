package com.proyecto.fabrica.model;

public class Modelo {
    
    private int idModelo;
    private String nombreModelo;
    private int piezasNecesarias;
    private double coste;
    
    public Modelo() {
    }

    public Modelo(String nombreModelo, int piezasNecesarias, double coste) {
        this.nombreModelo = nombreModelo;
        this.piezasNecesarias = piezasNecesarias;
        this.coste = coste;
    }

     /**
     * La función devuelve el valor de idModelo.
     * 
     * @return El método devuelve un valor entero, específicamente el valor de la variable "idModelo".
     */
    public int getIdModelo() {
        return idModelo;
    }

    /**
     * La función establece el valor de la variable idModelo.
     * 
     * @param idModelo El parámetro "idModelo" es un número entero que representa el ID de un modelo.
     */
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * La función devuelve el valor de la variable "nombreModelo".
     * 
     * @return El método devuelve un valor de cadena.
     */
    public String getNombreModelo() {
        return nombreModelo;
    }

   /**
    * La función establece el valor de la variable "nombreModelo" a la entrada proporcionada.
    * 
    * @param nombreModelo El parámetro "nombreModelo" es un String que representa el nombre de un
    * modelo.
    */
    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    /**
     * La función devuelve el número de piezas necesarias.
     * 
     * @return El método retorna el valor de la variable "piezasNecesarias".
     */
    public int getPiezasNecesarias() {
        return piezasNecesarias;
    }

    /**
     * La función establece el número de piezas necesarias.
     * 
     * @param piezasNecesarias El parámetro "piezasNecesarias" es un número entero que representa el
     * número de piezas necesarias.
     */
    public void setPiezasNecesarias(int piezasNecesarias) {
        this.piezasNecesarias = piezasNecesarias;
    }

    /**
     * La función "getCoste" devuelve el valor de la variable "coste".
     * 
     * @return El método devuelve el valor de la variable "costo", que es de tipo doble.
     */
    public double getCoste() {
        return coste;
    }

    /**
     * La función establece el valor de la variable "coste".
     * 
     * @param coste El parámetro "coste" es una variable de tipo doble que representa el costo.
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }
}
