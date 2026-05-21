package repositorio;

import Modelo.Vehiculos;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class RepositorioVehiculo implements RepositorioV<Vehiculos> {

    private final Map<String, Vehiculos> vehiculos = new HashMap<>();

    //Ejercicio 1: CRUD

    @Override
    public void crear(Vehiculos v) {
        String chapa = v.getChapa();
        if (vehiculos.containsKey(chapa)) {
            System.out.println("El vehículo ya existe.");
        } else {
            vehiculos.put(chapa, v);
            System.out.println("Vehículo creado exitosamente.");
        }
    }

    @Override
    public void listar() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            vehiculos.forEach((chapa, v) ->
                System.out.printf("Chapa: %-12s | Marca: %-12s | Modelo: %-18s | Año: %d | Conectable: %b%n",
                    chapa, v.getMarca(), v.getModelo(), v.getAnhoFabricacion(), v.isConectable())
            );
        }
    }

    @Override
    public void buscarV(String id) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("El vehículo no existe.");
        } else {
            Vehiculos v = vehiculos.get(id);
            System.out.println("Vehículo encontrado:");
            System.out.printf("  Chapa              : %s%n", v.getChapa());
            System.out.printf("  Marca              : %s%n", v.getMarca());
            System.out.printf("  Modelo             : %s%n", v.getModelo());
            System.out.printf("  Año de Fabricación : %d%n", v.getAnhoFabricacion());
            System.out.printf("  Conectable         : %b%n", v.isConectable());
        }
    }

    @Override
    public void editar(String id, Vehiculos v) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("Error: el vehículo no existe.");
        } else {
            vehiculos.put(id, v);
            System.out.println("Vehículo editado exitosamente.");
        }
    }

    @Override
    public void borrar(String id) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("El vehículo no existe.");
        } else {
            vehiculos.remove(id);
            System.out.println("Vehículo eliminado exitosamente."); // fix: antes no avisaba nada
        }
    }

    //Ejercicio 2: Lambda

    @Override
    public void mostrarConLambda() {
        System.out.println("\n--- Lista con forEach (Lambda) ---");
        vehiculos.forEach((chapa, v) ->
            System.out.printf("Chapa: %-12s | Modelo: %-18s | Marca: %-12s%n",
                chapa, v.getModelo(), v.getMarca())
        );
    }

    //Ejercicio 3: Streams

    @Override
    public void filtrarConectables() {
        System.out.println("\n--- Vehículos Conectables ---");
        vehiculos.values().stream()
            .filter(Vehiculos::isConectable)
            .forEach(v -> System.out.printf("Chapa: %-12s | Modelo: %-18s | Conectable: %b%n",
                v.getChapa(), v.getModelo(), v.isConectable()));
    }

    @Override
    public void obtenerListaIds() {
        System.out.println("\n--- Lista de IDs (Chapas) ---");
        vehiculos.keySet().stream()
            .sorted()
            .forEach(chapa -> System.out.printf("Chapa: %s%n", chapa));
    }

    @Override
    public long contarVehiculos() {
        long total = vehiculos.size(); // fix: .stream().count() era innecesario
        System.out.printf("Total de vehículos registrados: %d%n", total);
        return total;
    }

    @Override
    public void buscarPorTipo(String tipo) {
        System.out.println("\n--- Búsqueda por Tipo: " + tipo + " ---");
        vehiculos.values().stream()
            .filter(v -> v.getModelo().equalsIgnoreCase(tipo))
            .forEach(v -> System.out.printf("Chapa: %-12s | Modelo: %-18s | Marca: %-12s%n",
                v.getChapa(), v.getModelo(), v.getMarca()));
    }

    //Ejercicio 4: Ordenamiento

    @Override
    public void ordenarPorId() {
        System.out.println("\n--- Lista Ordenada por Chapa ---");
        vehiculos.values().stream()
            .sorted(Comparator.comparing(Vehiculos::getChapa))
            .forEach(v -> System.out.printf("Chapa: %-12s | Modelo: %-18s%n",
                v.getChapa(), v.getModelo()));
    }

    @Override
    public void ordenarPorTipo() {
        System.out.println("\n--- Lista Ordenada por Modelo ---");
        vehiculos.values().stream()
            .sorted(Comparator.comparing(Vehiculos::getModelo)) // fix: antes ordenaba por Marca en vez de Modelo
            .forEach(v -> System.out.printf("Modelo: %-18s | Chapa: %-12s | Marca: %-12s%n",
                v.getModelo(), v.getChapa(), v.getMarca()));
    }
}