package ufro.apicar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufro.apicar.models.Auto;

import java.util.ArrayList;
import java.util.List;

@Service
public final class AutoServiceImpl implements IAutoService{

    private List<Auto> listaAutos = new ArrayList<>();

    @Override
    public List<Auto> listarAutos() {
        return listaAutos;
    }

    @Override
    public void crearAutos(int cantidad) {

    }

    @Override
    public int generarId() {
        return 0;
    }

    @Override
    public int generarAño() {
        return 0;
    }

    @Override
    public String generarColor() {
        return null;
    }

    @Override
    public int generarPrecio() {
        return 0;
    }

    @Override
    public boolean generarTurbo() {
        return false;
    }

    @Override
    public String seleccionarTipo() {
        return null;
    }

    @Override
    public String seleccionarMotor() {
        return null;
    }

    @Override
    public int cantidadCabina() {
        return 0;
    }

    @Override
    public boolean seleccionarSunRoof() {
        return false;
    }

    @Override
    public int popularidad() {
        return 0;
    }
}
