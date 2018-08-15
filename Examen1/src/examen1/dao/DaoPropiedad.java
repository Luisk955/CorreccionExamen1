package examen1.dao;

import accesobd.Conector;
import examen1.cl.Propiedad;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoPropiedad {

    public ArrayList<Propiedad> listarPropiedades() throws SQLException, Exception {
        ArrayList<Propiedad> carreras = new ArrayList<>();
        Propiedad miPropiedad = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarPropiedades()}", true);

        while (rs.next()) {
            miPropiedad = new Propiedad(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("valor"),
                    rs.getString("direccion"), rs.getString("residencial"), rs.getInt("numeroCasa"),
                    rs.getBoolean("patio"), rs.getInt("cantidadhabitaciones"));
            carreras.add(miPropiedad);
        }
        rs.close();
        return carreras;
    }

    public void registrarPropiedad(Propiedad miPropiedad) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miPropiedad.getCodigo());
        data.add(miPropiedad.getNombre());
        data.add(miPropiedad.getValor());
        data.add(miPropiedad.getDireccion());
        data.add(miPropiedad.getResidencial());
        data.add(miPropiedad.getNumeroCasa());
        data.add(miPropiedad.isPatio());
        data.add(miPropiedad.getCantHabitaciones());
        data.add(miPropiedad.isDisponible());

        (new Conector()).getConector().ejecutarSQL(data, "{call insertPropiedad(?,?,?,?,?,?,?,?,?)}");
    }

    public Propiedad buscarPropiedad(int codigo) throws java.sql.SQLException, Exception {
        Propiedad miPropiedad = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(codigo,
                "{call searchPropiedad(?)}", true);
        if (rs.next()) {
            miPropiedad = new Propiedad(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("valor"),
                    rs.getString("direccion"), rs.getString("residencial"), rs.getInt("numeroCasa"),
                    rs.getBoolean("patio"), rs.getInt("cantidadhabitaciones"));
        }
        rs.close();
        return miPropiedad;
    }

    public void actualizarPropiedad(Propiedad miPropiedad) throws java.sql.SQLException, Exception {
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(miPropiedad.getCodigo());
            data.add(miPropiedad.getNombre());
            data.add(miPropiedad.getValor());
            data.add(miPropiedad.getDireccion());
            data.add(miPropiedad.getResidencial());
            data.add(miPropiedad.getNumeroCasa());
            data.add(miPropiedad.isPatio());
            data.add(miPropiedad.getCantHabitaciones());
            data.add(miPropiedad.isDisponible());
            (new Conector()).getConector().ejecutarSQL(data, "{call updatePropiedad(?,?,?,?,?,?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarPropiedad(int codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(codigo, "{call deletePropiedad(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
