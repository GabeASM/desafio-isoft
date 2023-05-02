package ufro.apicar.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {
    private String ID;
    private String marca;
    private int anio ;
    private String color;
    private boolean turbo;
    private String tipoAuto;
    private String motor;
    private int popularidad;

}
