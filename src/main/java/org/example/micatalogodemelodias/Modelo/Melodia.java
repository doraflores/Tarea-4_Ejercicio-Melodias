package org.example.micatalogodemelodias.Modelo;

public class Melodia {
    private int id;
    private String nombre; // nombre de la canción
    private String compositor;
    private int anio; // anio de grabación
    private String genero;
    private String cantante;
    private double precio;
    private String formato;

    // contructor parametrizado
    public Melodia(String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato){
        this.id = this.hashCode();
        this.nombre = nombre;
        this.compositor = compositor;
        this.anio = anio;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
    }

    // constructor vacio (inicializado)
    public Melodia(){
        this.id = this.hashCode();
        this.nombre = "Las mañanitas";
        this.compositor = "anónimo";
        this.anio = 1998;
        this.genero = "Ranchero";
        this.cantante = "Alejandro Fernandez";
        this.precio = 100;
        this.formato = "mp3";
    }

    // getters


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public String getCantante() {
        return cantante;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFormato() {
        return formato;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre +
                ", compositor: " + compositor +
                ", año: " + anio +
                ", género: " + genero +
                ", cantante: " + cantante +
                ", precio: " + precio +
                ", formato: " + formato;
    }

    // metodo equals
    @Override
    public boolean equals(Object obj){
        Melodia mel = (Melodia) obj;

        return cantante.equals(mel.getCantante()) && (anio == mel.getAnio());
    }


}
