package examen1.cl;

import java.time.LocalDate;

public class ReparacionNormal extends Reparacion {

    private String proveedor;
    private LocalDate fechaRealiz;
    private int costo;

    public ReparacionNormal() {
        super();
    }

    public ReparacionNormal(String proveedor, LocalDate fechaRealiz, int costo, int codigoPropiedad, int codigo, String descripcion, String encargado) {
        super(codigoPropiedad, codigo, descripcion, encargado);
        this.proveedor = proveedor;
        this.fechaRealiz = fechaRealiz;
        this.costo = costo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaRealiz() {
        return fechaRealiz;
    }

    public void setFechaRealiz(LocalDate fechaRealiz) {
        this.fechaRealiz = fechaRealiz;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reparación normal: " + super.toString() + " Proveedor: " + proveedor + ", Fecha realización: " + fechaRealiz + ", Costo: " + costo;
    }

}
