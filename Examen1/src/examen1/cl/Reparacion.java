package examen1.cl;

public class Reparacion {

    private int codigoPropiedad;
    private int codigo;
    private String descripcion;
    private String encargado;

    public Reparacion() {
    }

    public Reparacion(int codigoPropiedad, int codigo, String descripcion, String encargado) {
        this.codigoPropiedad = codigoPropiedad;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.encargado = encargado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(int codigo) {
        this.codigoPropiedad = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return " Código propiedad: " + codigoPropiedad + ", Código: " + codigo + ", Descripción: " + descripcion + ", Encargado: " + encargado + ", ";
    }

}
