package Modelo;

public class Vehiculos {

    private String marca;
    private String modelo;
    private int anhoFabricacion;
    private String chapa;
    private static int contadorId = 0;
    private int id;
    private boolean conectable;

    public Vehiculos(String marca, String modelo, int anhoFabricacion, String chapa, boolean conectable) {
        contadorId++;
        this.id = contadorId;
        this.marca = marca;
        this.modelo = modelo;
        this.anhoFabricacion = anhoFabricacion;
        this.chapa = chapa;
        this.conectable = conectable;
    }

    public int getId() {
        return id;
    }

    public boolean isConectable() {
        return conectable;
    }

    public void setConectable(boolean conectable) {
        this.conectable = conectable;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnhoFabricacion() {
        return anhoFabricacion;
    }

    public void setAnhoFabricacion(int anhoFabricacion) {
        this.anhoFabricacion = anhoFabricacion;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }
}