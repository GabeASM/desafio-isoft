package ufro.apicar.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {

    private int ID;
    private String marca;
    private int anio ;
    private String color;
    private boolean turbo;
    private String tipoAuto;
    private String motor;
    private int popularidad;
    private String cantidadCabina;
    private boolean sunRoof;
    private int precio;

    public Auto(int ID, String marca, int anio, String color, boolean turbo, String tipoAuto, String motor, int popularidad, String cantidadCabina, boolean sunRoof , int precio) {
        this.ID = ID;
        this.precio = precio;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
        this.turbo = turbo;
        this.tipoAuto = tipoAuto;
        this.motor = motor;
        this.popularidad = popularidad;
        this.cantidadCabina = cantidadCabina;
        this.sunRoof = sunRoof;
    }
}
