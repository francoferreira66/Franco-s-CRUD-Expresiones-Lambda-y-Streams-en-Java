package repositorio;

public interface RepositorioV<A> {

    //Ejercicio 1: CRUD 
    void crear(A objeto);
    void listar();
    void buscarV(String id);
    void editar(String id, A objeto);
    void borrar(String id);

    //Ejercicio 2:Lambda 
    void mostrarConLambda();

    //Ejercicio 3: Streams
    void filtrarConectables();
    void obtenerListaIds();
    long contarVehiculos();
    void buscarPorTipo(String tipo);

    //Ejercicio 4: Ordenamiento
    void ordenarPorId();
    void ordenarPorTipo();
}