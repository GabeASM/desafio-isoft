package ufro.apicar.services;

import org.springframework.stereotype.Service;
import ufro.apicar.models.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public final class AutoServiceImpl implements IAutoService {

    private List<Auto> listaAutos = new ArrayList<>();
    private Random random;

    @Override
    public String generarMarca() {
        List<String> marcas = List.of("TOYOTA", "SUBARU", "CHEVY", "FORD", "NISSAN");
        random = new Random();
        return marcas.get(random.nextInt(5));
    }

    @Override
    public int retornarCantidadLista() {
        return listaAutos.size();
    }

    @Override
    public List<Auto> retornarLista() {
        return listaAutos;
    }

    @Override
    public List<Auto> listarAutos(int cantidad) {
        crearAutos(cantidad);
        return listaAutos;
    }

    @Override
    public void crearAutos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String marca = generarMarca();
            int año = generarAño();
            String color = generarColor();
            boolean turbo = generarTurbo();
            String tipo = seleccionarTipo();
            String motor = seleccionarMotor(tipo);
            String cabinas = "NO APLICA";
            if (tipo == "CAMIONETA")
                cabinas = cantidadCabina();
            int numeroPopularidad = popularidad();
            boolean sunRoof = seleccionarSunRoof();
            int id = i + 1;
            int precio = generarPrecio();
            Auto auto = new Auto(id,
                    marca,
                    año,
                    color,
                    turbo,
                    tipo,
                    motor,
                    numeroPopularidad,
                    cabinas,
                    sunRoof, precio);
            listaAutos.add(auto);
        }
    }

    @Override
    public int generarId() {
        random = new Random();
        return random.nextInt(100) + 1;
    }

    @Override
    public int generarAño() {
        int limiteInferior = 2015;
        int limiteSuperior = 2023;

        random = new Random();
        int año = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
        return año;
    }

    @Override
    public String generarColor() {
        random = new Random();
        List<String> colores = List.of("ROJO", "VERDE", "PLOMO", "BLANCO", "AZUL");
        int numeroRandom = random.nextInt(5);
        return colores.get(numeroRandom);
    }

    @Override
    public int generarPrecio() {
        int limiteInferior = 8_000_000;
        int limiteSuperior = 30_000_000;

        random = new Random();
        int precio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
        return precio;
    }

    @Override
    public boolean generarTurbo() {
        random = new Random();
        return random.nextBoolean();
    }

    @Override
    public String seleccionarTipo() {
        List<String> tipoAuto = List.of("SEDAN", "CAMIONETA", "SUV");
        random = new Random();
        return tipoAuto.get(random.nextInt(3));
    }

    @Override
    public String seleccionarMotor(String tipoAuto) {
        if (tipoAuto == "SEDAN")
            return motorSedan();
        else if (tipoAuto == "CAMIONETA")
            return motorSuv();
        else if (tipoAuto == "SUV")
            return motorSuv();
        return "MOTOR NO ESPECIFICADO";
    }

    @Override
    public String cantidadCabina() {
        random = new Random();
        int numeroCabinas = (random.nextInt(2) + 1);
        return Integer.toString(numeroCabinas);
    }

    @Override
    public boolean seleccionarSunRoof() {
        random = new Random();
        return random.nextBoolean();
    }

    @Override
    public int popularidad() {
        random = new Random();
        return random.nextInt(101);
    }

    @Override
    public String motorSedan() {
        List<String> motor = List.of("1.4cc", "1.6cc", "2.0cc");
        random = new Random();
        return motor.get(random.nextInt(3));
    }

    @Override
    public String motorCamioneta() {
        List<String> motor = List.of("2.4cc", "3.0cc", "4.0cc");
        random = new Random();
        return motor.get(random.nextInt(3));
    }

    @Override
    public String motorSuv() {
        List<String> motor = List.of("1.8cc", "2.2cc", "2.8cc");
        random = new Random();
        return motor.get(random.nextInt(3));
    }

    @Override
    public void vaciarLista() {
        listaAutos.clear();
    }
}
