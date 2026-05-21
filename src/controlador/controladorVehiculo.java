package controlador;

import Modelo.Vehiculos;
import repositorio.RepositorioVehiculo;

public class ControladorVehiculo {

    private final RepositorioVehiculo repositorio = new RepositorioVehiculo();

    //Ejercicio 1: CRUD

    public void crear(Vehiculos v) {
        repositorio.crear(v);
    }

    public void listar() {
        repositorio.listar();
    }

    public void buscar(String id) {
        repositorio.buscarV(id);
    }

    public void editar(String id, Vehiculos v) {
        repositorio.editar(id, v);
    }

    public void borrar(String id) {
        repositorio.borrar(id);
    }

    //Ejercicio 2: Lambda 

    public void mostrarConLambda() {
        repositorio.mostrarConLambda();
    }

    //Ejercicio 3: Streams 

    public void filtrarConectables() {
        repositorio.filtrarConectables();
    }

    public void obtenerListaIds() {
        repositorio.obtenerListaIds();
    }

    public void contarVehiculos() {
        repositorio.contarVehiculos();
    }

    public void buscarPorTipo(String tipo) {
        repositorio.buscarPorTipo(tipo);
    }

    //Ejercicio 4: Ordenamiento 

    public void ordenarPorId() {
        repositorio.ordenarPorId();
    }

    public void ordenarPorTipo() {
        repositorio.ordenarPorTipo();
    }
}