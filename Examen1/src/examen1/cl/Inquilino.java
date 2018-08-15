package examen1.cl;

public class Inquilino {

    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private String identificacion;
    private char genero;

    public Inquilino() {
    }

    public Inquilino(String nombre, String apellidos, String correo, String direccion, String telefono, String identificacion, char genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Inquilino: Nombre: " + nombre + ", Apellidos:" + apellidos + ", Correo: " + correo + ", Dirección: " + direccion + ", Teléfono: " + telefono + ", Identificación: " + identificacion + ", Género: " + genero;
    }
}
