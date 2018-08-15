package examen1.cl;

import examen1.dao.DaoContratoAlquiler;
import examen1.dao.DaoInquilino;
import examen1.dao.DaoPropiedad;
import java.util.ArrayList;

public class CL {

    ArrayList<Propiedad> propiedades;
    ArrayList<Inquilino> inquilinos;
    ArrayList<ContratoAlquiler> contratosAlquiler;
    ArrayList<ReparacionProgramada> reparacionesProgramadas;
    ArrayList<ReparacionNormal> reparacionesNormales;

    public CL() throws Exception {
        this.propiedades = new DaoPropiedad().listarPropiedades();
        this.inquilinos = new DaoInquilino().listarInquilinos();
        this.contratosAlquiler = new DaoContratoAlquiler().listarContratosAlquiler();
        this.reparacionesProgramadas = new ArrayList<>();
        this.reparacionesNormales = new ArrayList<>();

    }

//add
    public void programarReparacion(ReparacionProgramada reparacion) {
        reparacionesProgramadas.add(reparacion);
    }

    public void registrarReparacion(ReparacionNormal reparacion) {
        reparacionesNormales.add(reparacion);
    }
//add

//read
    public ArrayList<ReparacionProgramada> listarReparacionesProgramadas() {
        return reparacionesProgramadas;
    }

    public ArrayList<ReparacionNormal> listarReparacionesNormales() {
        return reparacionesNormales;
    }
//read

}
