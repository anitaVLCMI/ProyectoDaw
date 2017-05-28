/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Incidencias;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borja
 */
public class BDA {

    private Connection conn;

    public void conectar() throws SQLException {
        String bd = "comercio";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        conn = DriverManager.getConnection(url, "root", "root");
    }

    public Trabajador consultar(int id) throws SQLException {
        Trabajador t = null;
        String consulta = "SELECT * FROM trabajadores";
        PreparedStatement ps = conn.prepareCall(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("idTrabajador");
            String nombre = rs.getString("contraseña");
            t = new Trabajador(id1, nombre);
        }

        return t;
    }

    public void insertarRuta(Integer ruta, Double kilometros, Integer trabajador, Integer minutos, Double gastos) throws SQLException {
        String consulta = "INSERT INTO rutas(IdRuta,kilometros,idTrabajador,Minutos,Gastos) values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, ruta);
        ps.setDouble(2, kilometros);
        ps.setInt(3, trabajador);
        ps.setInt(4, minutos);
        ps.setDouble(5, gastos);
        ps.executeUpdate();

    }

    public List<Trabajador> listarTrabajadores() throws SQLException {
        List<Trabajador> listaTrabajadores = new ArrayList<>();
        Trabajador t = null;
        String consulta = "SELECT * FROM trabajadores";
        PreparedStatement ps = conn.prepareCall(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("idTrabajador");
            String nombre = rs.getString("nombre");
            String puesto = rs.getString("puesto");
            String dni = rs.getString("dniNie");
            Double salario = rs.getDouble("salario");
            String contraseña = rs.getString("contraseña");
            t = new Trabajador(id1, nombre, puesto, dni, salario, contraseña);
            listaTrabajadores.add(t);
        }
        return listaTrabajadores;
    }

    public List<Incidencias> listarIncidencias() throws SQLException {
        List<Incidencias> lista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String consulta;

        conectar();
        if (conn != null) {

            consulta = "SELECT * FROM incidencias";
            ps = conn.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();

            while (rs.next()) {

                int idIncidencias = rs.getInt("idIncidencias");
                String descripcion = rs.getString("Descripcion");
                int idTrabajador = rs.getInt("idTrabajador");
                int idTienda = rs.getInt("idTienda");
                String fecha = rs.getString("fecha");

                Incidencias incidencia = new Incidencias(idIncidencias, descripcion, idTrabajador, idTienda, fecha);
                lista.add(incidencia);
            }
        }
        return lista;
    }

    public void insertarIncidencia(int idIncidencias, int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {

        String consulta = "INSERT INTO Incidencias(idIncidencias,idTrabajador,idtienda,fecha ,descripcion) values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, idIncidencias);
        ps.setDouble(2, idTrabajador);
        ps.setInt(3, idTienda);
        ps.setString(4, fecha);
        ps.setString(5, descripcion);
        ps.executeUpdate();

    }

    public void borrarIncidencia(int idIncidencia) throws SQLException {
        String consulta = " DELETE FROM Incidencias WHERE idIncidencias = ?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, idIncidencia);

        ps.executeUpdate();

    }

    public void cambiarIncidencia(int idIncidencias, int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {
        String consulta = "UPDATE Incidencias SET descripcion=?,idTienda=?,idTrabajador=?,fecha=? WHERE idIncidencias =?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(5, idIncidencias);
        ps.setInt(3, idTrabajador);
        ps.setInt(2,  idTienda);
        ps.setString(1, descripcion);
        ps.setString(4, fecha);

         ps.executeUpdate();

    }

}
