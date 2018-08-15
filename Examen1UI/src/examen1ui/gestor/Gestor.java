package examen1ui.gestor;

import examen1.cl.*;
import examen1.dao.DaoContratoAlquiler;
import examen1.dao.DaoInquilino;
import examen1.dao.DaoPropiedad;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor {

    CL logic;

    public Gestor() throws Exception {
        logic = new CL();
    }

    //Propiedades
    public String registrarPropiedad(int codigo, String nombre, int valor, String direccion, String residencial, int numeroCasa, boolean patio, int cantHabitaciones) throws Exception {
        Propiedad miPropiedad = new Propiedad(codigo, nombre, valor, direccion, residencial, numeroCasa, patio, cantHabitaciones);
        String resp = "";
        int cont = 0;
        for (Propiedad propiedadTemp : listarPropiedadesIn()) {
            if (miPropiedad.getCodigo() == propiedadTemp.getCodigo()) {
                cont++;
            }
        }
        if (cont == 0) {
            (new DaoPropiedad()).registrarPropiedad(miPropiedad);
            resp = "Propiedad registrada correctamente";
        } else {
            resp = "Propiedad previamente registrada";
        }
        return resp;
    }

    public ArrayList<String> listarPropiedades() throws Exception {
        ArrayList<String> propiedadesString = new ArrayList<>();
        for (Propiedad propiedad : (new DaoPropiedad()).listarPropiedades()) {
            propiedadesString.add(propiedad.toString());
        }
        return propiedadesString;
    }

    public ArrayList<Propiedad> listarPropiedadesIn() throws Exception {
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        for (Propiedad miPropiedad : (new DaoPropiedad()).listarPropiedades()) {
            propiedades.add(miPropiedad);
        }
        return propiedades;
    }

    public void actualizarPropiedad(int codigo, String nombre, int valor, String direccion, String residencial, int numeroCasa, boolean patio, int cantHabitaciones) throws Exception {
        Propiedad miPropiedad = new Propiedad(codigo, nombre, valor, direccion, residencial, numeroCasa, patio, cantHabitaciones);
        new DaoPropiedad().actualizarPropiedad(miPropiedad);
    }

    public void borrarPropiedad(int codigo) throws Exception {
        new DaoPropiedad().borrarPropiedad(codigo);
    }

    public String buscarPropiedad(int codigo) throws Exception {
        Propiedad miPropiedad = new DaoPropiedad().buscarPropiedad(codigo);
        String resp = "";
        if (miPropiedad != null) {
            resp = miPropiedad.toString();

        } else {
            resp = "Propiedad no encontrada";
        }
        return resp;
    }

    public Propiedad buscarPropiedadIn(int codigo) throws Exception {
        Propiedad miPropiedad = new DaoPropiedad().buscarPropiedad(codigo);
        return miPropiedad;
    }
    //Propiedades

    //Inquilinos
    public String registrarInquilino(String nombre, String apellidos, String correo, String direccion, String telefono, String identificacion, char genero) throws Exception {
        Inquilino miInquilino = new Inquilino(nombre, apellidos, correo, direccion, telefono, identificacion, genero);
        String resp = "";
        int cont = 0;
        for (Inquilino in : listarInquilinosIn()) {
            if (in.getIdentificacion() == identificacion) {
                cont++;
            }
        }
        if (cont != 0) {
            resp = "Inquilino previamente registrado.";
        } else {
            new DaoInquilino().registrarInquilino(miInquilino);
            resp = "Inquilino registrado correctamente.";
        }
        return resp;
    }

    public ArrayList<String> listarInquilinos() throws Exception {
        ArrayList<String> inquilinosString = new ArrayList<>();
        for (Inquilino miInquilino : (new DaoInquilino()).listarInquilinos()) {
            inquilinosString.add(miInquilino.toString());
        }
        return inquilinosString;
    }

    public ArrayList<Inquilino> listarInquilinosIn() throws Exception {
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        for (Inquilino miInquilino : (new DaoInquilino()).listarInquilinos()) {
            inquilinos.add(miInquilino);
        }
        return inquilinos;
    }

    public String buscarInquilino(String identificacion) throws Exception {
        Inquilino miInquilino = new DaoInquilino().buscarInquilino(Integer.parseInt(identificacion));
        String resp = "";
        if (miInquilino != null) {
            resp = miInquilino.toString();

        } else {
            resp = "Inquilino no encontrado";
        }
        return resp;
    }

    public Inquilino buscarInquilinoIn(String identificacion) throws Exception {
        Inquilino miInquilino = new DaoInquilino().buscarInquilino(Integer.parseInt(identificacion));

        return miInquilino;
    }

    public void actualizarInquilino(String nombre, String apellidos, String correo, String direccion, String telefono, String identificacion, char genero) throws Exception {
        Inquilino miInquilino = new Inquilino(nombre, apellidos, correo, direccion, telefono, identificacion, genero);
        new DaoInquilino().actualizarInquilino(miInquilino);
    }

    public void borrarInquilino(String identificacion) throws Exception {
        new DaoInquilino().borrarInquilino(Integer.parseInt(identificacion));
    }
    //Inquilinos

    //Contratos de alquiler
    public String registrarContratoAlquiler(int codigo, String identificacionInquilinoCont, int codigoPropiedadCont, LocalDate fechaInicioVigencia, int duracionContrato, int montoAlquiler, String moneda) throws Exception {
        Inquilino miInquilino = buscarInquilinoIn(identificacionInquilinoCont);
        Propiedad miPropiedad = buscarPropiedadIn(codigoPropiedadCont);
        String resp = "";

        if (miInquilino != null) {
            if (miPropiedad != null) {
                int cont = 0;
                int cont2 = 0;
                int idInq = Integer.parseInt(miInquilino.getIdentificacion());
                int codProp = miPropiedad.getCodigo();
                for (ContratoAlquiler ca : new DaoContratoAlquiler().listarContratosAlquiler()) {
                    if (ca.getIdentificacionInquilino() == idInq) {
                        cont++;
                    }
                    if (ca.getCodigoPropiedad() == codProp) {
                        cont2++;
                    }
                }
                if (cont != 0) {
                    resp = "El inquilino se encuentra asociado a un contrato.";
                } else {
                    if (cont2 != 0) {
                        resp = "La propiedad se encuentra en asociada a un contrato.";
                    } else {
                        ContratoAlquiler miContratoAlquiler = new ContratoAlquiler(codigo, miInquilino, miPropiedad, fechaInicioVigencia, duracionContrato, montoAlquiler, moneda);
                        new DaoContratoAlquiler().registrarContratoAlquiler(miContratoAlquiler);
                        resp = "Contrato " + codigo + " registrado exitosamente.";
                    }
                }
            } else {
                resp = "Propiedad no registrada";
            }
        } else {
            resp = "Inquilino no registrado";
        }
        return resp;
    }

    public ArrayList<String> listarContratosAlquiler() throws Exception {
        ArrayList<String> contratosAlquilerString = new ArrayList<>();
        for (ContratoAlquiler miContratoAlquiler : new DaoContratoAlquiler().listarContratosAlquiler()) {
            contratosAlquilerString.add(miContratoAlquiler.toString());
        }
        return contratosAlquilerString;
    }

    public ArrayList<ContratoAlquiler> listarContratosAlquilerIn() throws Exception {
        ArrayList<ContratoAlquiler> contratosAlquiler = new ArrayList<>();
        for (ContratoAlquiler miContratoAlquiler : (new DaoContratoAlquiler()).listarContratosAlquiler()) {
            contratosAlquiler.add(miContratoAlquiler);
        }
        return contratosAlquiler;
    }

    public String buscarContratoAlquiler(int codigo) throws Exception {
        ContratoAlquiler miContratoAlquiler = new DaoContratoAlquiler().buscarContratoAlquiler(codigo);
        String resp = "";
        if (miContratoAlquiler != null) {
            resp = miContratoAlquiler.toString();

        } else {
            resp = "Propiedad no encontrada";
        }
        return resp;
    }

    public void actualizarContratoAlquiler(int codigo, String identificacionInquilinoCont, int codigoPropiedadCont, LocalDate fechaInicioVigencia, int duracionContrato, int montoAlquiler, String moneda) throws Exception {
        ContratoAlquiler miContratoAlquiler = new ContratoAlquiler(codigo, buscarInquilinoIn(identificacionInquilinoCont), buscarPropiedadIn(codigoPropiedadCont), fechaInicioVigencia, duracionContrato, montoAlquiler, moneda);
        new DaoContratoAlquiler().actualizarContratoAlquiler(miContratoAlquiler);
    }

    public void borrarContratoAlquiler(int codigo) throws Exception {
        new DaoContratoAlquiler().borrarContratoAlquiler(codigo);
    }
    //Contratos de alquiler

    //Reparaciones programadas
    public String programarReparacion(LocalDate fechaARealiz, int codigoPropiedad, int codigo, String descripcion, String encargado) throws Exception {
        ReparacionProgramada miReparacionProgramada = new ReparacionProgramada(fechaARealiz, codigoPropiedad, codigo, descripcion, encargado);
        LocalDate date1 = LocalDate.now();
        String resp = "";
        int cont = 0;

        if (date1.isBefore(miReparacionProgramada.getFechaARealiz())) {
            for (Propiedad miPropiedad : listarPropiedadesIn()) {
                if (miPropiedad.getCodigo() == codigoPropiedad) {
                    for (ContratoAlquiler ca : listarContratosAlquilerIn()) {
                        if (ca.getCodigoPropiedad() == codigoPropiedad) {
                            for (ReparacionProgramada rp : listarReparacionesProgramadasIn()) {
                                if (rp.getCodigo() == codigo) {
                                    cont++;
                                }
                            }
                            for (ReparacionNormal rn : listarReparacionesNormalesIn()) {
                                if (rn.getCodigo() == codigo) {
                                    cont++;
                                }
                            }
                        }
                    }
                }
            }
            if (cont != 0) {
                resp = "Reparacion previamente registrada.";
            } else {
                logic.programarReparacion(miReparacionProgramada);
                resp = "Reparacion registrada exitosamente.";
            }

        } else {
            resp = "Fecha incorrecta, ingrese una fecha mayor a hoy";
        }
        return resp;
    }

    public ArrayList<String> listarReparacionesProgramadas() {
        ArrayList<String> reparacionesProgramadas = new ArrayList<>();
        for (ReparacionProgramada miReparacionProgramada : logic.listarReparacionesProgramadas()) {
            reparacionesProgramadas.add(miReparacionProgramada.toString());
        }
        return reparacionesProgramadas;
    }

    public ArrayList<ReparacionProgramada> listarReparacionesProgramadasIn() {
        ArrayList<ReparacionProgramada> reparacionesProgramadas = new ArrayList<>();
        for (ReparacionProgramada miReparacionProgramada : logic.listarReparacionesProgramadas()) {
            reparacionesProgramadas.add(miReparacionProgramada);
        }
        return reparacionesProgramadas;
    }
    //Reparaciones programadas

    //Reparaciones normales
    public String registrarReparacion(String proveedor, LocalDate fechaRealiz, int costo, int codigoPropiedad, int codigo, String descripcion, String encargado) throws Exception {
        ReparacionNormal miReparacionNormal = new ReparacionNormal(proveedor, fechaRealiz, costo, codigoPropiedad, codigo, descripcion, encargado);
        LocalDate date1 = LocalDate.now();
        String resp = "";
        int cont = 0;

        if (date1.isBefore(miReparacionNormal.getFechaRealiz())) {
            for (Propiedad miPropiedad : listarPropiedadesIn()) {
                if (miPropiedad.getCodigo() == codigoPropiedad) {
                    for (ContratoAlquiler ca : listarContratosAlquilerIn()) {
                        if (ca.getCodigoPropiedad() == codigoPropiedad) {
                            for (ReparacionNormal rn : listarReparacionesNormalesIn()) {
                                if (rn.getCodigo() == codigo) {
                                    cont++;
                                }
                            }
                            for (ReparacionProgramada rp : listarReparacionesProgramadasIn()) {
                                if (rp.getCodigo() == codigo) {
                                    cont++;
                                }
                            }
                        }
                    }
                }
            }
            if (cont != 0) {
                resp = "Reparacion previamente registrada.";
            } else {
                logic.registrarReparacion(miReparacionNormal);
                resp = "Reparacion registrada exitosamente.";
            }

        } else {
            resp = "Fecha incorrecta, ingrese una fecha mayor a hoy";
        }
        return resp;
    }

    public ArrayList<String> listarReparacionesNormales() {
        ArrayList<String> reparacionesNormales = new ArrayList<>();
        for (ReparacionNormal miReparacionNormal : logic.listarReparacionesNormales()) {
            reparacionesNormales.add(miReparacionNormal.toString());
        }
        return reparacionesNormales;
    }

    public ArrayList<ReparacionNormal> listarReparacionesNormalesIn() {
        ArrayList<ReparacionNormal> reparacionesNormales = new ArrayList<>();
        for (ReparacionNormal miReparacionNormal : logic.listarReparacionesNormales()) {
            reparacionesNormales.add(miReparacionNormal);
        }
        return reparacionesNormales;
    }
    //Reparaciones normales
}
