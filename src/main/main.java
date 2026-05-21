package main;

import Modelo.Vehiculos;
import controlador.ControladorVehiculo;

public class Main {

    public static void main(String[] args) {

        ControladorVehiculo controlador = new ControladorVehiculo();


        // Ejercicio 1 – CRUD
       

        System.out.println("========================================");
        System.out.println("        EJERCICIO 1 – CRUD");
        System.out.println("========================================");

        // Crear vehículos
        System.out.println("\n--- Crear vehículos ---");
        controlador.crear(new Vehiculos("Toyota",   "SUV",       2020, "ABC123", true));
        controlador.crear(new Vehiculos("Ford",     "Camioneta", 2018, "XYZ789", false));
        controlador.crear(new Vehiculos("Tesla",    "Sedan",     2023, "TES001", true));
        controlador.crear(new Vehiculos("Chevrolet","SUV",       2019, "CHV456", false));
        controlador.crear(new Vehiculos("BMW",      "Sedan",     2022, "BMW999", true));

        // Listar
        System.out.println("\n--- Listar todos ---");
        controlador.listar();

        // Buscar
        System.out.println("\n--- Buscar: TES001 ---");
        controlador.buscar("TES001");

        // Editar
        System.out.println("\n--- Editar: ABC123 ---");
        controlador.editar("ABC123", new Vehiculos("Toyota", "SUV", 2021, "ABC123", true));
        controlador.buscar("ABC123");

        // Borrar
        System.out.println("\n--- Eliminar: CHV456 ---");
        controlador.borrar("CHV456");

        System.out.println("\n--- Listar tras eliminar ---");
        controlador.listar();

    
        // Ejercicio 2 – LAMBDA


        System.out.println("\n========================================");
        System.out.println("      EJERCICIO 2 – LAMBDA");
        System.out.println("========================================");
        controlador.mostrarConLambda();

        // -------------------------------------------------------
        // EJERCICIO 3 – STREAMS
        // -------------------------------------------------------

        System.out.println("\n========================================");
        System.out.println("      EJERCICIO 3 – STREAMS");
        System.out.println("========================================");

        controlador.filtrarConectables();
        controlador.obtenerListaIds();
        controlador.contarVehiculos();

        System.out.println("\n--- Buscar por tipo: Sedan ---");
        controlador.buscarPorTipo("Sedan");

  
        // Ejercicio 4 – ORDENAMIENTO
 

        System.out.println("\n========================================");
        System.out.println("      EJERCICIO 4 – ORDENAMIENTO");
        System.out.println("========================================");

        controlador.ordenarPorId();
        controlador.ordenarPorTipo();

 
        // Ejercicio 5 – INTEGRACIÓN (creo que ya se hizo arriba)
        // Ejercicio 6 – MEJORAS: se usan los métodos anteriores
        //               en combinación para mostrar reportes


        System.out.println("\n========================================");
        System.out.println("  EJERCICIO 6 – REPORTES Y ESTADÍSTICAS");
        System.out.println("========================================");

        System.out.println("\n-- Reporte completo de flota --");
        controlador.listar();

        System.out.println("\n-- Clasificación: solo conectables --");
        controlador.filtrarConectables();

        System.out.println("\n-- Clasificación: ordenado por tipo --");
        controlador.ordenarPorTipo();

        System.out.println("\n-- Estadística: total de vehículos --");
        controlador.contarVehiculos();

        System.out.println("\n-- Búsqueda avanzada por tipo: SUV --");
        controlador.buscarPorTipo("SUV");

        System.out.println("\n-- Búsqueda avanzada por tipo: Camioneta --");
        controlador.buscarPorTipo("Camioneta");
    }
}