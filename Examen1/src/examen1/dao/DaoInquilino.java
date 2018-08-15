package examen1.dao;

import accesobd.Conector;
import examen1.cl.Inquilino;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoInquilino {

    public ArrayList<Inquilino> listarInquilinos() throws SQLException, Exception {
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        Inquilino miInquilino = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarInquilinos()}", true);

        while (rs.next()) {
            miInquilino = new Inquilino(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("correo"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("identificacion"), rs.getString("genero").charAt(0));
            inquilinos.add(miInquilino);
        }
        rs.close();
        return inquilinos;
    }

    public void registrarInquilino(Inquilino miInquilino) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miInquilino.getIdentificacion());
        data.add(miInquilino.getNombre());
        data.add(miInquilino.getApellidos());
        data.add(miInquilino.getCorreo());
        data.add(miInquilino.getDireccion());
        data.add(miInquilino.getTelefono());
        data.add(new StringBuilder().append("").append(miInquilino.getGenero()).toString());

        (new Conector()).getConector().ejecutarSQL(data, "{call insertInquilino(?,?,?,?,?,?,?)}");
    }

    public Inquilino buscarInquilino(int codigo) throws java.sql.SQLException, Exception {
        Inquilino miInquilino = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(codigo,
                "{call searchInquilino(?)}", true);
        if (rs.next()) {
            miInquilino = new Inquilino(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("correo"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("identificacion"), rs.getString("genero").charAt(0));
        }
        rs.close();
        return miInquilino;
    }

    public void actualizarInquilino(Inquilino miInquilino) throws java.sql.SQLException, Exception {
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(miInquilino.getIdentificacion());
            data.add(miInquilino.getNombre());
            data.add(miInquilino.getApellidos());
            data.add(miInquilino.getCorreo());
            data.add(miInquilino.getDireccion());
            data.add(miInquilino.getTelefono());
            data.add(new StringBuilder().append("").append(miInquilino.getGenero()).toString());

            (new Conector()).getConector().ejecutarSQL(data, "{call updateInquilino(?,?,?,?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarInquilino(int codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(codigo, "{call deleteInquilino(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
