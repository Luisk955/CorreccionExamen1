package examen1.cl;

import java.time.LocalDate;

public class ReparacionProgramada extends Reparacion {

    private LocalDate fechaARealiz;

    public ReparacionProgramada() {
        super();
    }

    public ReparacionProgramada(LocalDate fechaARealiz, int codigoPropiedad, int codigo, String descripcion, String encargado) {
        super(codigoPropiedad, codigo, descripcion, encargado);
        this.fechaARealiz = fechaARealiz;
    }

    public LocalDate getFechaARealiz() {
        return fechaARealiz;
    }

    public void setFechaARealiz(LocalDate fechaARealiz) {
        this.fechaARealiz = fechaARealiz;
    }

    @Override
    public String toString() {
        return "Reparación programada: " + super.toString() + " Fecha a realizar: " + fechaARealiz;
    }

}
