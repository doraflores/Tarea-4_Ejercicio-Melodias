package org.example.micatalogodemelodias.Vista;

import org.example.micatalogodemelodias.Modelo.Genero;

import java.util.Scanner;

// clase que captura y muestra

public class CatalogoView {
    // Scanner leerCadenas
    private Scanner leerNumeros = new Scanner(System.in);
    // Scanner leerNumeros
    private Scanner leerCadenas = new Scanner(System.in);
    String[] formatos = {"mp3", "ogg", "wav"};

    // Metodo para leer la opcion que quiero hacer con el catalogo y mostrar el menu
    public int mostrarMenu() {
        leerNumeros = new Scanner(System.in);
        leerCadenas = new Scanner(System.in);
        System.out.println("--- MENÚ CATALOGO DE MELODIAS ---");
        System.out.println("1. Registrar Melodia");
        System.out.println("2. Mostrar todo el catalogo");
        System.out.println("3. Salir");
        System.out.println("Elige una opción: ");
        return leerNumeros.nextInt();
    }

    // Metodo para leer y regresar el nombre que le asigare a melodia
    public String leerNombreMelodia() {
        System.out.println("Ingresa el nombre de la melodia: ");
        return leerCadenas.nextLine();
    }

    // Metodo para leer y regresar el compositor que le asigare a melodia
    public String leerCompositor() {
        System.out.println("Ingrese el nombre del compositor: ");
        return leerCadenas.nextLine();
    }

    // Metodo para leer y regresar el cantante que le asigare a melodia
    public String leerCantante() {
        System.out.println("Ingresa el nombre del cantante: ");
        return leerCadenas.nextLine();
    }

    // Metodo para leer y regresar el año que le asigare a melodia
    public int leerAnioMelodia() {
        System.out.println("Ingresa el año de lamzamiento de la melodia: ");
        return leerNumeros.nextInt();
    }

    // Metodo para mostrar el catalogo
    public void mostrarCatalogo(String catalogo){
        System.out.println(catalogo);
    }

    // Metodo para mostrar cadenas
    public void mostrarCadena(String cadena) {
        System.out.println(cadena);
    }

    // Metodo para leer y regresar el genero que asignare a melodia
    public String mostrarObtenerGenero() {
        Genero[] generos = Genero.values();
        int numero = 1;
        int seleccion;
        for (Genero g : Genero.values()) {
            System.out.println(numero + ". Género: " + g);
            numero++;
        }
        System.out.println("Ingrese el numero del genero");
        numero = leerNumeros.nextInt();
        return generos[numero - 1].toString();
    }

    // Metodo para leer y regresar el precio que le asiganre a melodia
    public double leerPrecioMelodia(){
        System.out.println("Ingresa el precio de la melodia: ");
        return leerNumeros.nextDouble();
    }

    // Metodo para leer y regresar el formato que le asignere a melodia
    public String mostrarObtenerFormato() {
        int numero = 1;
        int seleccion;
        for (String g : formatos) {
            System.out.println(numero + ". Formato: " + g);
            numero++;
        }
        System.out.println("Ingrese el numero del formato");
        numero = leerNumeros.nextInt();
        return formatos[numero - 1].toString();
    }
}
