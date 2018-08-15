package examen1.dao;

import accesobd.Conector;
import examen1.cl.ContratoAlquiler;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoContratoAlquiler {

    public ArrayList<ContratoAlquiler> listarContratosAlquiler() throws SQLException, Exception {
        ArrayList<ContratoAlquiler> contratosAlquiler = new ArrayList<>();
        ContratoAlquiler miContratoAlquiler = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarContratosAlquiler()}", true);

        while (rs.next()) {
            miContratoAlquiler = new ContratoAlquiler(rs.getInt("codigo"), new DaoInquilino().buscarInquilino(rs.getInt("identificacioninquilino")), new DaoPropiedad().buscarPropiedad(rs.getInt("codigopropiedad")), rs.getDate("fechaInicioVigencia").toLocalDate(), rs.getInt("duracionContrato"), rs.getInt("montoAlquiler"), rs.getString("moneda"));
            contratosAlquiler.add(miContratoAlquiler);
        }
        rs.close();
        return contratosAlquiler;
    }

    public void registrarContratoAlquiler(ContratoAlquiler miContratoAlquiler) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miContratoAlquiler.getCodigo());
        data.add(miContratoAlquiler.getIdentificacionInquilino());
        data.add(miContratoAlquiler.getCodigoPropiedad());
        data.add(miContratoAlquiler.getFechaInicioVigencia());
        data.add(miContratoAlquiler.getDuracionContrato());
        data.add(miContratoAlquiler.getFechaFinalContrato());
        data.add(miContratoAlquiler.getMontoAlquiler());
        data.add(miContratoAlquiler.getPorcentajeAnual());
        data.add(miContratoAlquiler.getMoneda());

        (new Conector()).getConector().ejecutarSQL(data, "{call insertContratoAlquiler(?,?,?,?,?,?,?,?,?)}");
    }

    public ContratoAlquiler buscarContratoAlquiler(int codigo) throws java.sql.SQLException, Exception {
        ContratoAlquiler miContratoAlquiler = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(codigo,
                "{call searchContratoAlquiler(?)}", true);
        if (rs.next()) {
            miContratoAlquiler = new ContratoAlquiler(rs.getInt("codigo"), new DaoInquilino().buscarInquilino(rs.getInt("identificacioninquilino")), new DaoPropiedad().buscarPropiedad(rs.getInt("codigopropiedad")), rs.getDate("fechaInicioVigencia").toLocalDate(), rs.getInt("duracionContrato"), rs.getInt("montoAlquiler"), rs.getString("moneda"));
        }
        rs.close();
        return miContratoAlquiler;
    }

    public void actualizarContratoAlquiler(ContratoAlquiler miContratoAlquiler) throws java.sql.SQLException, Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miContratoAlquiler.getCodigo());
        data.add(miContratoAlquiler.getIdentificacionInquilino());
        data.add(miContratoAlquiler.getCodigoPropiedad());
        data.add(miContratoAlquiler.getFechaInicioVigencia());
        data.add(miContratoAlquiler.getDuracionContrato());
        data.add(miContratoAlquiler.getFechaFinalContrato());
        data.add(miContratoAlquiler.getMontoAlquiler());
        data.add(miContratoAlquiler.getPorcentajeAnual());
        data.add(miContratoAlquiler.getMoneda());

        (new Conector()).getConector().ejecutarSQL(data, "{call updateContratoAlquiler(?,?,?,?,?,?,?,?,?)}");
    }

    public void borrarContratoAlquiler(int codigo) throws java.sql.SQLException, Exception {
        new Conector().getConector().ejecutarSQL(codigo, "{call deleteContratoAlquiler(?)}");
    }
}
