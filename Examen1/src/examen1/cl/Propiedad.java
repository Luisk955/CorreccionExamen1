package examen1.cl;

import java.util.ArrayList;

public class Propiedad {

    private int codigo;
    private String nombre;
    private int valor;
    private String direccion;
    private String residencial;
    private int numeroCasa;
    private boolean patio;
    private int cantHabitaciones;
    private String nombreInquilino;
    private boolean disponible;
    private ArrayList<Reparacion> listaReparaciones;

    public Propiedad() {
    }

    public Propiedad(int codigo, String nombre, int valor, String direccion,
            String residencial, int numeroCasa, boolean patio, int cantHabitaciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.direccion = direccion;
        this.residencial = residencial;
        this.numeroCasa = numeroCasa;
        this.patio = patio;
        this.cantHabitaciones = cantHabitaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getResidencial() {
        return residencial;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setListaReparaciones(ArrayList<Reparacion> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }

    public void addReparacion(Reparacion miReparacion) {
        this.listaReparaciones.add(miReparacion);
    }

    @Override
    public String toString() {
        return "Propiedad: Código: " + codigo + ", Nombre: " + nombre + ", Valor: " + valor +" dolares" + ", Dirección: " + direccion + ", Residencial: " + residencial + ", Número de casa: " + numeroCasa + ", Patio: " + patio + ", Cantidad de habitaciones: " + cantHabitaciones;
    }
}
