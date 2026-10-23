package org.example.micatalogodemelodias.Modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CatalogoMelodias {
    private ArrayList<Melodia> canciones = new ArrayList<>();

    // constructor
    public CatalogoMelodias() {
        canciones = new ArrayList<>();
    }

    // boolean registrarMelodia(Melodia melodia)
    public boolean registrarMelodia(Melodia obj){
        boolean bandera = false;
        if(canciones != null) {
            for (Melodia melodia : canciones) {
                bandera = melodia.equals(obj);
                if (bandera) {
                    break;
                }
            }
        }
        if(!bandera){
            canciones.add(obj);
        }
        return bandera; // falso = se logro, verdadero = no se logro
    }

    public void crearObjetoMelodia(String nm, String nca, String nco, int anio, double precio, String formato, String genero){
        registrarMelodia(new Melodia(nm, nco, anio, genero, nca, precio, formato));
    }

    public String mostrarTodasLasMelodias(){
        StringBuffer sb = new StringBuffer();
        for(Melodia melodia : canciones){
            sb.append(melodia);
            sb.append("\n");
        }
        return sb.toString();
    }

    // removerMelodia(int id)
    // ArrayList<Melodia> buscar(String nombreMelodia)
    // Melodia buscar(int id)
    // actualizarMelodia(int id, String nombreMelodia, String compositor, int anio, String genero, String cantante, double precio, String formato)
    // double obtenerPrecioColeccion()
    // ArrayList<> todosLosGeneros() // utlizar String o Enum
    public ArrayList<String> obtenerTodosLosGeneros(){
        ArrayList<String> generos = (ArrayList<String>)canciones
                .stream()
                .map(Melodia::getGenero)
                .distinct()
                .collect(Collectors.toList());
        return generos;
    }

    public HashSet<String> obtenerTodosLosGenerosIterativo(){
        HashSet<String> generos = new HashSet<>();
        for(Melodia cancion : canciones){
            generos.add(cancion.getGenero());
        }
        return generos;
    }


    // ArrayList<Melodia> cancionesPorCompositor(String compositor)
    public HashMap<String, ArrayList<Melodia>> melodiasPorCompositor() {
        HashMap<String, ArrayList<Melodia>> mapa = new HashMap<>();
        canciones.forEach(m -> {
            mapa.putIfAbsent(m.getCompositor(),
                    new ArrayList<>());
            mapa.get(m.getCompositor()).add(m);
        });
        return mapa;
    }
    // ArrayList<Melodia> melodiasPorAnio(int anio)
    //ordenarMelodiasPorPrecio()

    //ordenarMelodiasPorAnio()
    public ArrayList<Melodia> ordenarMelodiasPorAnio() {
        return canciones.stream()
                .sorted(Comparator.comparingInt(Melodia::getAnio))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //ordenarMelodiasPorCantante()

}
