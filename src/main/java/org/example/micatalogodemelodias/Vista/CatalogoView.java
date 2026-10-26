package org.example.micatalogodemelodias.Vista;

import org.example.micatalogodemelodias.Modelo.Genero;
import org.example.micatalogodemelodias.Modelo.Melodia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// clase que captura y muestra

public class CatalogoView {
    // Scanner leerCadenas
    private Scanner leerNumeros = new Scanner(System.in);
    // Scanner leerNumeros
    private Scanner leerCadenas = new Scanner(System.in);
    String[] formatos = {"mp3", "ogg", "wav"};

    /**
     * Se amplio el menú
     **/
    // Metodo para leer la opcion que quiero hacer con el catalogo y mostrar el menu
    public int mostrarMenu() {
        leerNumeros = new Scanner(System.in);
        leerCadenas = new Scanner(System.in);
        System.out.println("--- MENÚ CATALOGO DE MELODIAS ---");
        System.out.println("1. Registrar melodia");
        System.out.println("2. Mostrar todo el catalogo");
        System.out.println("3. Buscar melodia por nombre");
        System.out.println("4. Eliminar melodia");
        System.out.println("5. Mostrar valor total de la colección");
        System.out.println("6. Mostrar cantantes");
        System.out.println("7. Mostrar generos");
        System.out.println("8. Buscar melodias por cantante");
        System.out.println("9. Buscar melodias por compositor");
        System.out.println("10. Buscar melodias por año");
        System.out.println("11. Mostrar formatos");
        System.out.println("12. Ordenar melodias por precio");
        System.out.println("13. Salir");
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

    /**
     * Metodos añadidos
     **/

    public void mostrarCantantes(HashSet<String> cantantes){
        cantantes.forEach(System.out::println);
    }

    public void mostrarGeneros(HashSet<String> generos){
        generos.forEach(System.out::println);
    }

    public void mostrarFormatos(HashMap<String, Integer> formatos){
        formatos.forEach(
                (formato,cantidad) -> System.out.println(formato + ": " + cantidad)
        );
    }

    public int leerId(){
        System.out.println("Ingrese el ID: ");
        return leerNumeros.nextInt();
    }

    public int leerAnio(){
        System.out.println("Ingrese el año:");
        return leerNumeros.nextInt();
    }


    /**
     *
     **/

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

    // metodo que muestra las melodias almacenadas en el arraylist
    public void mostrarMelodias(ArrayList<Melodia> melodias){
        if(melodias.isEmpty()){
            System.out.println("No se encontraron melodias");
            return;
        }
        melodias.forEach(System.out::println);
    }
}
