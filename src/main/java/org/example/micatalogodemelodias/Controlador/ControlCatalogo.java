package org.example.micatalogodemelodias.Controlador;

import org.example.micatalogodemelodias.Modelo.CatalogoMelodias;
import org.example.micatalogodemelodias.Modelo.Melodia;
import org.example.micatalogodemelodias.Vista.CatalogoView;

import java.lang.classfile.instruction.SwitchCase;

public class ControlCatalogo {
    // Catalogo modelo
    // CatalogoView vista
    private CatalogoMelodias modelo;
    private CatalogoView vista;

    public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar(){
        int opc = 0;
        while (opc != 13){
            opc = vista.mostrarMenu();
            switch (opc){
                case 1:
                    vista.mostrarCadena("Registrar una nueva melodia");
                    String n = vista.leerNombreMelodia();
                    String nca = vista.leerCantante();
                    String nco = vista.leerCompositor();
                    String gen = vista.mostrarObtenerGenero();
                    String formato = vista.mostrarObtenerFormato();
                    int anio = vista.leerAnioMelodia();
                    double precio = vista.leerPrecioMelodia();

                    modelo.crearObjetoMelodia(n, nca, nco, anio, precio, formato, gen);
                    break;
                case 2:
                    vista.mostrarCadena(modelo.mostrarTodasLasMelodias());
                    break;
                case 3:
                    String nombre = vista.leerNombreMelodia();
                    Melodia melodia = modelo.buscarMelodia(nombre);
                    if(melodia != null){
                        vista.mostrarCadena(melodia.toString());
                    }else{
                        vista.mostrarCadena("Melodia no encontrada");
                    }
                    break;
                case 4:
                    nombre = vista.leerNombreMelodia();
                    if(modelo.removerMelodiaPorNombre(nombre)){
                        vista.mostrarCadena("Melodia eliminada");
                    }else{
                        vista.mostrarCadena("Melodia no encontrada");
                    }
                    break;
                case 5:
                    vista.mostrarCadena("Valor total de la colleción: $" + modelo.obtenerPrecioColeccion());
                    break;
                case 6:
                    vista.mostrarCantantes(modelo.obtenerCantantes());
                    break;
                case 7:
                    vista.mostrarGeneros(modelo.obtenerTodosLosGenerosIterativo());
                    break;
                case 8:
                    String cantante = vista.leerCantante();
                    vista.mostrarMelodias(modelo.melodiasPorCantante(cantante));
                    break;
                    // agregar los case de las nuevas opciones del menu
                case 9:
                    String compositor = vista.leerCompositor();
                    vista.mostrarMelodias(modelo.melodiasPorCompositor(compositor));
                    break;
                case 10:
                    int anioBuscar = vista.leerAnio();
                    vista.mostrarMelodias(modelo.melodiasPorAnio(anioBuscar));
                    break;
                case 11:
                    vista.mostrarFormatos(modelo.obtenerFormatos());
                    break;
                case 12:
                    modelo.melodiasPorPrecio();
                    vista.mostrarCadena(modelo.mostrarTodasLasMelodias());
                    break;
                case 13:
                    vista.mostrarCadena("ADIOS");
                    break;
            }
        }
    }
}
