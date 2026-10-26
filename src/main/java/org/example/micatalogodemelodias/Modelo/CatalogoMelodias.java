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

    /**
     * Metodos añadidos
     * ******************************************************************
     **/
    // metodo que busca una melodia por su nombre y retorna los datos de la melodia
    public Melodia buscarMelodia(String nombre){
        for(Melodia melodia : canciones){
            if(melodia.getNombre().equalsIgnoreCase(nombre)){
                return melodia;
            }
        }
        return null;
    }

    // Metodo para buscar una melodia por Id
    public Melodia buscarMelodiaPorId(int id){
        for (Melodia melodia : canciones){
            if(melodia.getId() == id){
                return melodia;
            }
        }
        return null;
    }

    // Metodo que remueve una cancion del catalogo por su nombre
    public boolean removerMelodiaPorNombre(String nombre){
        return canciones.removeIf(
                melodia -> melodia.getNombre().equalsIgnoreCase(nombre)
        );
    }
    // metodo para remover melodia por su ID
    public boolean removerMelodiaPorId(int id){
        return canciones.removeIf(melodia -> melodia.getId() == id);
    }

    // Metodo para corregir algun dato de la melodia si te equivocas, este caso: el precio
    // recibe el nombre y el nuevo precio y retorna si se actualizo o no
    public boolean corregirPrecio(String nombre, double nuevoPrecio){
        Melodia melodia = buscarMelodia(nombre);
        if(melodia != null){
            melodia.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    // metodo para obtener el valor de la coleccion, retorna el valor total de la coleccion
    public double obtenerPrecioColeccion(){
        return canciones.stream()
                .mapToDouble(Melodia::getPrecio)
                .sum();
    }

    // metodo que retorna la cantidad de cantantes sin repetir
    public int cantidadCantantes(){
        HashSet<String> cantantes = new HashSet<>();
        canciones.forEach(
                melodia -> cantantes.add(melodia.getCantante())
        );
        return cantantes.size();
    }

    // metodo que muestra los cantantes de la coleccion sin repetir
    public HashSet<String> obtenerCantantes(){
        HashSet<String> cantantes = new HashSet<>();
        canciones.forEach(
                melodia -> cantantes.add(melodia.getCantante())
        );
        return cantantes;
    }

    // Metodo que obtiene los formatos de las melodias de la coleccion y la cantidad por formato
    public HashMap<String, Integer> obtenerFormatos(){
        HashMap<String, Integer> formatos = new HashMap<>();
        canciones.forEach(melodia -> {
            String formato = melodia.getFormato();
            formatos.put(formato, formatos.getOrDefault(formato,0)+1);
        });
        return formatos;
    }

    // ArrayList<Melodia> cancionesPorCompositor(String compositor)
    // metodo para obtener las melodias por compositor
    public ArrayList<Melodia> melodiasPorCompositor(String compositor){
        return canciones.stream()
                .filter(m -> m.getCompositor()
                        .equalsIgnoreCase(compositor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // metodo para obtener las melodias por cantante
    public ArrayList<Melodia> melodiasPorCantante(String cantante){
        ArrayList<Melodia> resultado = new ArrayList<>();
        for(Melodia melodia : canciones){
            if (melodia.getCantante().equalsIgnoreCase(cantante)){
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    //ordenarMelodiasPorAnio()
    // metodo que busca las melodias por precio
    public ArrayList<Melodia> melodiasPorAnio(int anio) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia melodia : canciones){
            if (melodia.getAnio() == anio){
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    // metodo que ordena las melodias por precio
    public void melodiasPorPrecio(){
        canciones.sort((m1,m2) -> Double.compare(m1.getPrecio(), m2.getPrecio()));
    }

    // metodo que ordena las melodias por cantante
    public ArrayList<Melodia> ordenarMelodiasPorCantante(){
        return canciones.stream()
                .sorted(Comparator.comparing(Melodia::getCantante))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // metodo para actualizar todos los datos de una melodia
    public boolean actualizarMelodia(int id, String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato){
        Melodia melodia = buscarMelodiaPorId(id);
        if(melodia == null){
            return false;
        }
        melodia.setNombre(nombre);
        melodia.setCompositor(compositor);
        melodia.setAnio(anio);
        melodia.setGenero(genero);
        melodia.setCantante(cantante);
        melodia.setPrecio(precio);
        melodia.setFormato(formato);
        return true;
    }
}
