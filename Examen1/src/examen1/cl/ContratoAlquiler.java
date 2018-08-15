package examen1.cl;

import java.time.LocalDate;

public class ContratoAlquiler {

    private int codigo;
    private Inquilino inquilino;
    private Propiedad propiedad;
    private LocalDate fechaInicioVigencia;
    private int duracionContrato;
    //(calculada por medio de la duración del contrato más la fecha de inicio de vigencia)
    private LocalDate fechaFinalContrato;
    private int montoAlquiler;
    private int porcentajeAnual;
    //alquileres en dólares no aumentan durante el período de vigencia del contrato
    //alquileres en colones aumentan cada año.
    private String moneda;

    public ContratoAlquiler() {
    }

    public ContratoAlquiler(int codigo, Inquilino inquilino, Propiedad propiedad, LocalDate fechaInicioVigencia, int duracionContrato, int montoAlquiler, String moneda) {
        this.codigo = codigo;
        this.inquilino = inquilino;
        this.propiedad = propiedad;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.duracionContrato = duracionContrato;
        this.montoAlquiler = montoAlquiler;
        this.moneda = moneda;
        if ("Dolar".equals(this.moneda)) {
            this.porcentajeAnual = 0;
        } else {
            this.porcentajeAnual = 10;
        }
        this.fechaFinalContrato = fechaInicioVigencia.plusMonths(duracionContrato);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public int getIdentificacionInquilino() {
        return Integer.parseInt(inquilino.getIdentificacion());
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public int getCodigoPropiedad() {
        return propiedad.getCodigo();
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public int getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(int duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    public LocalDate getFechaFinalContrato() {
        return fechaFinalContrato;
    }

    public void setFechaFinalContrato(LocalDate fechaFinalContrato) {
        this.fechaFinalContrato = fechaFinalContrato;
    }

    public int getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(int montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public int getPorcentajeAnual() {
        return porcentajeAnual;
    }

    public void setPorcentajeAnual(int porcentajeAnual) {
        this.porcentajeAnual = porcentajeAnual;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Contrato de alquiler: Código: " + codigo + ", Inquilino: " + getIdentificacionInquilino() + ", Propiedad: " + getCodigoPropiedad() + ", Fecha de inicio de vigencia: " + fechaInicioVigencia + ", Duración del contrato: " + duracionContrato + " meses" + ", Fecha finalización contrato: " + fechaFinalContrato + ", Monto alquiler: " + montoAlquiler + " " + moneda.toLowerCase() + "es" + ", Porcentaje anual: " + porcentajeAnual + " %" + ", Moneda: " + moneda;
    }
}
