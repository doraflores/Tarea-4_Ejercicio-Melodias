package org.example.micatalogodemelodias;

import org.example.micatalogodemelodias.Controlador.ControlCatalogo;
import org.example.micatalogodemelodias.Modelo.CatalogoMelodias;
import org.example.micatalogodemelodias.Modelo.Melodia;
import org.example.micatalogodemelodias.Vista.CatalogoView;

import java.util.ArrayList;

public class Main{
    public static void  main (String[] args){
        CatalogoMelodias modelo = new CatalogoMelodias();
        CatalogoView vista = new CatalogoView();
        ControlCatalogo control = new ControlCatalogo(vista, modelo);
        control.iniciar();


        /**
        CatalogoMelodias catalogoMelodias = new CatalogoMelodias();

        // hacer comprobacion de que funciona
        // agregar 7 melodias, 2 repetidas y solo debe mostrar 6
        Melodia m1 = new Melodia(1, "Rosa Pastel", "Belanova", 2005, "Pop", "Belanova" , 50.8, "Mp3");
        Melodia m2 = new Melodia(2, "Doma", "", 2016, "Pop", "Jósean Log", 45.8, "mp3");
        Melodia m3 = new Melodia(3, "Borderline", "Kevin Parker", 2020, "Pop", "Tame Impala", 87.9, "mp3");
        Melodia m4 = new Melodia(4,"Borderlin", "Kevin Parker", 2020, "Pop", "Tame Impala", 68.9, "mp3"); // repetida
        Melodia m5 = new Melodia(5, "I Was Made For Lovin You", "Paul Stanley", 1979, "Rock", "KISS", 98.6, "mp3");
        Melodia m6 = new Melodia(6, "Salio El Sol", "Armando Rosario", 2006, "Reggaeton", "Don Omar", 156.7, "mp3");
        Melodia m7 = new Melodia(7, "Puño de Diamantes", "Marco Antonio Pérez", 2013, "Regional Mexicana", "Duelo", 208.3, "mp3");

        catalogoMelodias.registrarMelodia(m1);
        catalogoMelodias.registrarMelodia(m2);
        catalogoMelodias.registrarMelodia(m3);
        catalogoMelodias.registrarMelodia(m4);
        catalogoMelodias.registrarMelodia(m5);
        catalogoMelodias.registrarMelodia(m6);
        catalogoMelodias.registrarMelodia(m7);

        System.out.println(catalogoMelodias.mostrarTodasLasMelodias());


        //Obtener todos los generos
        catalogoMelodias.obtenerTodosLosGeneros();
        System.out.println(catalogoMelodias.obtenerTodosLosGeneros());

        // mostrar las melodias ordenadas por año
        ArrayList<Melodia> ordenadas = catalogoMelodias.ordenarMelodiasPorAnio();
        for(Melodia melodia : ordenadas){
            System.out.println(melodia);
        }
        **/
    }
}

