package examen1ui.ui;

import java.io.*;
import examen1ui.gestor.Gestor;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor ctrl;

    public static void main(String args[]) throws java.io.IOException, Exception {
        ctrl = new Gestor();
        int opcion = -1;
        do {

            out.println("1. Registrar propiedad");
            out.println("2. Listar propiedades");
            out.println("3. Buscar propiedad");
            out.println("4. Actualizar propiedad");
            out.println("5. Borrar propiedad");
            out.println("6. Registrar inquilino");
            out.println("7. Listar inquilinos");
            out.println("8. Buscar inquilino");
            out.println("9. Actualizar inquilino");
            out.println("10. Borrar inquilinor");
            out.println("11. Registrar contrato de alquiler");
            out.println("12. Listar contratos de alquiler");
            out.println("13. Buscar contrato de alquiler");
            out.println("14. Actualizar contrato de alquiler");
            out.println("15. Borrar contrato de alquiler");
            out.println("16. Programar reparación");
            out.println("17. Registrar reparación");
            out.println("18. Listar reparaciones");
            out.println("0. Salir");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);

        } while (opcion != 0);
    }

    public static void procesarOpcion(int pOpcion) throws java.io.IOException, Exception {
        switch (pOpcion) {
            case 1:
                registrarPropiedad();
                break;
            case 2:
                listarPropiedades();
                break;
            case 3:
                buscarPropiedad();
                break;
            case 4:
                actualizarPropiedad();
                break;
            case 5:
                borrarPropiedad();
                break;
            case 6:
                registrarInquilino();
                break;
            case 7:
                listarInquilinos();
                break;
            case 8:
                buscarInquilino();
                break;
            case 9:
                actualizarInquilino();
                break;
            case 10:
                borrarInquilino();
                break;
            case 11:
                registrarContratoAlquiler();
                break;
            case 12:
                listarContratosAlquiler();
                break;
            case 13:
                buscarContratoAlquiler();
                break;
            case 14:
                actualizarContratoAlquiler();
                break;
            case 15:
                borrarContratoAlquiler();
                break;
            case 16:
                programarReparacion();
                break;
            case 17:
                registrarReparacion();
                break;
            case 18:
                listarReparaciones();
                break;
            case 0:
                out.println("Gracias por usar el sistema");
                break;
            default:
                out.println("Opcion inválida");
                break;
        }
    }

    public static LocalDate crearFecha() throws IOException {
        LocalDate fecha;
        int mes;
        int year;
        int dia;
        out.println("Digite el dia");
        dia = Integer.parseInt(in.readLine());
        out.println("Digite el mes");
        mes = Integer.parseInt(in.readLine());
        out.println("Digite el año");
        year = Integer.parseInt(in.readLine());
        fecha = LocalDate.of(year, mes, dia);
        return fecha;
    }

//Propiedades    
    public static void registrarPropiedad() throws java.io.IOException, Exception {
        int codigoProp;
        String nombreProp;
        int valorProp;
        String direccionProp;
        String residencialProp;
        int numeroCasaProp;
        boolean patioProp;
        int cantHabitacionesProp;
        String patioPropS;

        out.println("Digite el código de la propiedad");
        codigoProp = Integer.parseInt(in.readLine());

        out.println("Digite el nombre de la propiedad");
        nombreProp = in.readLine();

        out.println("Digite la valor de la propiedad en dolares");
        valorProp = Integer.parseInt(in.readLine());

        out.println("Digite la dirección de la propiedad");
        direccionProp = in.readLine();

        out.println("Digite el nombre del residencial en el que se encuentra la propiedad");
        residencialProp = in.readLine();

        out.println("Digite el número de casa asignado a la propiedad");
        numeroCasaProp = Integer.parseInt(in.readLine());

        out.println("Digite y si la propiedad tiene patio o n si no");
        patioPropS = in.readLine();
        if ("y".equals(patioPropS) || "Y".equals(patioPropS)) {
            patioProp = true;
        } else {
            patioProp = false;
        }

        out.println("Digite la cantidad de habitaciones de la propiedad");
        cantHabitacionesProp = Integer.parseInt(in.readLine());
        out.println(ctrl.registrarPropiedad(codigoProp, nombreProp, valorProp, direccionProp, residencialProp, numeroCasaProp, patioProp, cantHabitacionesProp));
    }

    public static void actualizarPropiedad() throws java.io.IOException, Exception {
        int codigoProp;
        String nombreProp;
        int valorProp;
        String direccionProp;
        String residencialProp;
        int numeroCasaProp;
        boolean patioProp;
        int cantHabitacionesProp;

        out.println("Digite el código de la propiedad");
        codigoProp = Integer.parseInt(in.readLine());

        out.println("Digite el nombre de la propiedad");
        nombreProp = in.readLine();

        out.println("Digite la valor de la propiedad");
        valorProp = Integer.parseInt(in.readLine());

        out.println("Digite la dirección de la propiedad");
        direccionProp = in.readLine();

        out.println("Digite el nombre del residencial en el que se encuentra la propiedad");
        residencialProp = in.readLine();

        out.println("Digite el número de casa asignado a la propiedad");
        numeroCasaProp = Integer.parseInt(in.readLine());

        out.println("Digite y si la propiedad tiene patio o n si no");
        if (in.readLine() == "y") {
            patioProp = true;
        } else {
            patioProp = false;
        }

        out.println("Digite la cantidad de habitaciones de la propiedad");
        cantHabitacionesProp = Integer.parseInt(in.readLine());
        ctrl.actualizarPropiedad(codigoProp, nombreProp, valorProp, direccionProp, residencialProp, numeroCasaProp, patioProp, cantHabitacionesProp);
    }

    public static void listarPropiedades() throws java.io.IOException, Exception {
        ArrayList<String> data = ctrl.listarPropiedades();
        for (String info : data) {
            out.println(info);
            out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    public static void buscarPropiedad() throws IOException, Exception {
        int codigoBusqProp;
        out.println("Digite el código de la propiedad que desea buscar");
        codigoBusqProp = Integer.parseInt(in.readLine());
        out.println(ctrl.buscarPropiedad(codigoBusqProp));
    }

    public static void borrarPropiedad() throws IOException, Exception {
        int codigoborrarpropiedad;
        out.println("Digite el código de la propiedad que desea buscar");
        codigoborrarpropiedad = Integer.parseInt(in.readLine());
        ctrl.borrarPropiedad(codigoborrarpropiedad);
    }
//Propiedades

//Inquilinos
    public static void registrarInquilino() throws IOException, Exception {
        String nombreInq;
        String apellidosInq;
        String correoInq;
        String direccionInq;
        String telefonoInq;
        String identificacionInq;
        char generoInq;

        out.println("Digite el nombre del inquilino");
        nombreInq = in.readLine();

        out.println("Digite los apellidos del inquilino");
        apellidosInq = in.readLine();

        out.println("Digite el correo electrónico del inquilino");
        correoInq = in.readLine();

        out.println("Digite la dirección del inquilino");
        direccionInq = in.readLine();

        out.println("Digite número telefónico del inquilino");
        telefonoInq = in.readLine();

        out.println("Digite la identificación del inquilino");
        identificacionInq = in.readLine();

        out.println("Digite el género del inquilino");
        generoInq = in.readLine().charAt(0);

        ctrl.registrarInquilino(nombreInq, apellidosInq, correoInq, direccionInq, telefonoInq, identificacionInq, generoInq);

    }

    public static void listarInquilinos() throws java.io.IOException, Exception {
        ArrayList<String> data = ctrl.listarInquilinos();
        data.forEach((info) -> {
            out.println(info);
            out.println("----------------------------------------------------------------------------------------------------");

        });
    }

    public static void buscarInquilino() throws IOException, Exception {
        String identificacionBusqInq;
        out.println("Digite la identificación del inquilino que desea buscar");
        identificacionBusqInq = in.readLine();
        out.println(ctrl.buscarInquilino(identificacionBusqInq));
    }

    public static void actualizarInquilino() throws IOException, Exception {
        String nombreInq;
        String apellidosInq;
        String correoInq;
        String direccionInq;
        String telefonoInq;
        String identificacionInq;
        char generoInq;

        out.println("Digite la identificación del inquilino");
        identificacionInq = in.readLine();

        out.println("Digite el nombre del inquilino");
        nombreInq = in.readLine();

        out.println("Digite los apellidos del inquilino");
        apellidosInq = in.readLine();

        out.println("Digite el correo electrónico del inquilino");
        correoInq = in.readLine();

        out.println("Digite la dirección del inquilino");
        direccionInq = in.readLine();

        out.println("Digite número telefónico del inquilino");
        telefonoInq = in.readLine();

        out.println("Digite el género del inquilino");
        generoInq = in.readLine().charAt(0);

        ctrl.actualizarInquilino(nombreInq, apellidosInq, correoInq, direccionInq, telefonoInq, identificacionInq, generoInq);

    }

    public static void borrarInquilino() throws IOException, Exception {
        String identificacionBusqInq;
        out.println("Digite la identificación del inquilino que desea buscar");
        identificacionBusqInq = in.readLine();
        ctrl.borrarInquilino(identificacionBusqInq);
    }
//Inquilinos

//Contratos de alquiler
    public static void registrarContratoAlquiler() throws IOException, Exception {
        int codigoCont;
        String identificacionInquilinoCont;
        int codigoPropiedadCont;
        LocalDate fechaInicioVigenciaCont;
        int duracionContratoCont;
        int montoAlquilerCont;
        String monedaCont;

        out.println("Digite la el código del contrato");
        codigoCont = Integer.parseInt(in.readLine());

        out.println("----------------------------------------------------------------------------------------------------");
        listarInquilinos();

        out.println("Digite la identificación del inquilino");
        identificacionInquilinoCont = in.readLine();

        out.println("----------------------------------------------------------------------------------------------------");
        listarPropiedades();

        out.println("Digite el código de la propiedad");
        codigoPropiedadCont = Integer.parseInt(in.readLine());

        out.println("Digite la fecha de inicio de vigencia del contrato");
        fechaInicioVigenciaCont = crearFecha();

        out.println("Digite la duración del contrato en meses");
        duracionContratoCont = Integer.parseInt(in.readLine());

        out.println("Digite la moneda usada en el contrato");
        monedaCont = in.readLine();

        out.println("Digite el monto del alquiler");
        montoAlquilerCont = Integer.parseInt(in.readLine());

        out.println(ctrl.registrarContratoAlquiler(codigoCont, identificacionInquilinoCont, codigoPropiedadCont, fechaInicioVigenciaCont, duracionContratoCont, montoAlquilerCont, monedaCont));
    }

    public static void listarContratosAlquiler() throws Exception {
        ArrayList<String> data = ctrl.listarContratosAlquiler();
        data.forEach((info) -> {
            out.println(info);
            out.println("----------------------------------------------------------------------------------------------------");

        });
    }

    public static void actualizarContratoAlquiler() throws IOException, Exception {
        int codigoCont;
        String identificacionInquilinoCont;
        int codigoPropiedadCont;
        LocalDate fechaInicioVigenciaCont;
        int duracionContratoCont;
        int montoAlquilerCont;
        String monedaCont;

        out.println("Digite la el código del contrato");
        codigoCont = Integer.parseInt(in.readLine());

        out.println("----------------------------------------------------------------------------------------------------");
        listarInquilinos();

        out.println("Digite la identificación del inquilino");
        identificacionInquilinoCont = in.readLine();

        out.println("------------------------------------------------------------------------------------------------------------------");
        listarPropiedades();

        out.println("Digite el código de la propiedad");
        codigoPropiedadCont = Integer.parseInt(in.readLine());

        out.println("Digite la fecha de inicio de vigencia del contrato");
        fechaInicioVigenciaCont = crearFecha();

        out.println("Digite la duración del contrato en meses");
        duracionContratoCont = Integer.parseInt(in.readLine());

        out.println("Digite la moneda usada en el contrato");
        monedaCont = in.readLine();

        out.println("Digite el monto del alquiler");
        montoAlquilerCont = Integer.parseInt(in.readLine());

        ctrl.actualizarContratoAlquiler(codigoCont, identificacionInquilinoCont, codigoPropiedadCont, fechaInicioVigenciaCont, duracionContratoCont, montoAlquilerCont, monedaCont);
    }

    public static void buscarContratoAlquiler() throws IOException, Exception {
        int codigoBusqCont;
        out.println("Digite el código del contrato que desea buscar");
        codigoBusqCont = Integer.parseInt(in.readLine());
        out.println(ctrl.buscarContratoAlquiler(codigoBusqCont));
    }

    public static void borrarContratoAlquiler() throws IOException, Exception {
        int codigo;
        out.println("Digite el código del contrato de alquiler que desea borrar.");
        codigo = Integer.parseInt(in.readLine());
        ctrl.borrarPropiedad(codigo);
    }
//Contratos de alquiler

//Reparaciones
    public static void programarReparacion() throws IOException, Exception {
        LocalDate fechaARealizRepProg;
        int codigoPropiedadRepProg;
        int codigoRepProg;
        String descripcionRepProg;
        String encargadoRepProg;

        out.println("Digite el código de la reparación");
        codigoRepProg = Integer.parseInt(in.readLine());

        out.println("Digite la fecha en la que se debe realizar la reparación");
        fechaARealizRepProg = crearFecha();

        out.println("-----------------------------------------------------------------------------------------------------------------------");
        listarPropiedades();

        out.println("Digite el código de la propiedad a la que se le asignará la reparación");
        codigoPropiedadRepProg = Integer.parseInt(in.readLine());

        out.println("Digite la descripción de la reparación");
        descripcionRepProg = in.readLine();

        out.println("Digite el encargado de la reparación");
        encargadoRepProg = in.readLine();

        out.println(ctrl.programarReparacion(fechaARealizRepProg, codigoPropiedadRepProg, codigoRepProg, descripcionRepProg, encargadoRepProg));

    }

    public static void registrarReparacion() throws IOException, Exception {
        String proveedorRepNorm;
        LocalDate fechaRealizRepNorm;
        int costoRepNorm;
        int codigoPropiedadRepNorm;
        int codigoRepNorm;
        String descripcionRepNorm;
        String encargadoRepNorm;

        out.println("Digite el codigo de la reparacion");
        codigoRepNorm = Integer.parseInt(in.readLine());

        out.println("Digite el proveedor de la reparacion");
        proveedorRepNorm = in.readLine();

        out.println("Digite la fecha de realizacion de la reparacion");
        fechaRealizRepNorm = crearFecha();

        out.println("Digite el costo de la reparacion");
        costoRepNorm = Integer.parseInt(in.readLine());

        out.println("-----------------------------------------------------------------------------------------------------------------------");
        listarPropiedades();

        out.println("Digite el codigo de la propiedad a ser reparada");
        codigoPropiedadRepNorm = Integer.parseInt(in.readLine());

        out.println("Digite la descripcion de la reparacion");
        descripcionRepNorm = in.readLine();

        out.println("Digite el encargado de la reparacion");
        encargadoRepNorm = in.readLine();

        out.println(ctrl.registrarReparacion(proveedorRepNorm, fechaRealizRepNorm, costoRepNorm, codigoRepNorm, codigoRepNorm, descripcionRepNorm, encargadoRepNorm));
    }

    public static void listarReparaciones() throws IOException {
        out.println("Digite N para reparaciones normales o P para reparaciones programadas");
        String opcionListRep = in.readLine();
        switch (opcionListRep) {
            case "n":
                listarReparacionesNormales();
                break;
            case "N":
                listarReparacionesNormales();
                break;
            case "P":
                listarReparacionesProgramadas();
                break;
            case "p":
                listarReparacionesProgramadas();
                break;
            default:
                out.println("Opción incorrecta");
                break;
        }
    }

    public static void listarReparacionesProgramadas() {
        ArrayList<String> data = ctrl.listarReparacionesProgramadas();
        data.forEach((info) -> {
            out.println(info);
        });
    }

    public static void listarReparacionesNormales() {
        ArrayList<String> data = ctrl.listarReparacionesNormales();
        data.forEach((info) -> {
            out.println(info);
        });
    }
//Reparaciones
}
