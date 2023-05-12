package ufro.apicar.services;


import ufro.apicar.models.Auto;

import java.util.List;

public sealed interface IAutoService permits AutoServiceImpl{
    String generarMarca();

    int retornarCantidadLista();
    List<Auto>retornarLista();
    List<Auto> listarAutos(int cantidad);
    void crearAutos(int cantidad);
    int generarId();
    int generarAño();
    String generarColor();
    int generarPrecio();
    boolean generarTurbo();
    String seleccionarTipo();
    String seleccionarMotor(String tipoAuto);
    String cantidadCabina();
    boolean seleccionarSunRoof();
    int popularidad();

    String motorSedan();
    String motorCamioneta();
    String motorSuv();

}
