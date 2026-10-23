package org.example.micatalogodemelodias.Controlador;

import org.example.micatalogodemelodias.Modelo.CatalogoMelodias;
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
        while (opc != 3){
            opc = vista.mostrarMenu();
            switch (opc){
                case 1: vista.mostrarCadena("Registrar una nueva melodia");
                    String n = vista.leerNombreMelodia();
                    String nca = vista.leerCantante();
                    String nco = vista.leerCompositor();
                    String gen = vista.mostrarObtenerGenero();
                    String formato = vista.mostrarObtenerFormato();
                    int anio = vista.leerAnioMelodia();
                    double precio = vista.leerPrecioMelodia();

                    modelo.crearObjetoMelodia(n, nca, nco, anio, precio, formato, gen);
                    break;
                case 2: vista.mostrarCadena(modelo.mostrarTodasLasMelodias());
                    break;
                case 3:
                    vista.mostrarCadena("ADIOS");
                    break;
            }
        }
    }
}
