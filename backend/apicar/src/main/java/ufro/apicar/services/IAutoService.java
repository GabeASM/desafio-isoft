package ufro.apicar.services;


import ufro.apicar.models.Auto;

import java.util.List;

public sealed interface IAutoService permits AutoServiceImpl{
    List<Auto> listarAutos();
    void crearAutos(int cantidad);
    int generarId();
    int generarAño();
    String generarColor();
    int generarPrecio();
    boolean generarTurbo();
    String seleccionarTipo();
    String seleccionarMotor();
    int cantidadCabina();
    boolean seleccionarSunRoof();
    int popularidad();

}
