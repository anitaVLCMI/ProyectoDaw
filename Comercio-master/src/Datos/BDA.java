/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Horario;
import Modelo.Incidencias;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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

    public int insertarIncidencia(int idIncidencias, int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {
        int numFilas;
        String consulta = "INSERT INTO Incidencias(idIncidencias,idTrabajador,idtienda,fecha ,descripcion) values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, idIncidencias);
        ps.setDouble(2, idTrabajador);
        ps.setInt(3, idTienda);
        ps.setString(4, fecha);
        ps.setString(5, descripcion);
        numFilas = ps.executeUpdate();
        return numFilas;

    }

    public int borrarIncidencia(int idIncidencia) throws SQLException {
        int numFilas;
        String consulta = " DELETE FROM Incidencias WHERE idIncidencias = ?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, idIncidencia);

        numFilas = ps.executeUpdate();
        return numFilas;

    }

    public int cambiarIncidencia(int idIncidencias, int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {
        int numFilas;
        String consulta = "UPDATE Incidencias SET descripcion=?,idTienda=?,idTrabajador=?,fecha=? WHERE idIncidencias =?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(5, idIncidencias);
        ps.setInt(3, idTrabajador);
        ps.setInt(2, idTienda);
        ps.setString(1, descripcion);
        ps.setString(4, fecha);

        numFilas = ps.executeUpdate();
        return numFilas;

    }

    public boolean consultarIDincidencia(int incidencia) throws SQLException {

        boolean existe = false;

        for (Incidencias velementos : listarIncidencias()) {

            if (incidencia == velementos.getIdIncidencias()) {
                existe = true;

            }
        }

        return existe;
    }

    public boolean consultarIDhorario(int idHorario) throws SQLException {

        boolean existe = false;

        for (Horario velementos : listarHorarios()) {

            if (idHorario == velementos.getIdHorarios()) {
                existe = true;

            }
        }

        return existe;
    }

    public ArrayList<Horario> listarHorarios() throws SQLException {
        conectar();
        int id;
        String horaEntrada;
        String horaSalida;
        String fechaInicio;
        String fechasalida;

        ArrayList<Horario> listaHorarios = new ArrayList<>();
        String consulta = "SELECT * FROM horarios";
        PreparedStatement ps = conn.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            id = rs.getInt("idHorario");
            horaEntrada = rs.getString("horaEntrada");
            horaSalida = rs.getString("horaSalida");
            fechaInicio = rs.getString("fechaInicio");
            fechasalida = rs.getString("fechaFin");

            Horario horarios = new Horario(id, horaEntrada, horaSalida, fechaInicio, fechasalida);
            listaHorarios.add(horarios);
        }
        return listaHorarios;
    }

    public int insertarHorario(int idHorario, String horaEntrada, String horaSalida, String fechaInicio, String fechaFin) throws SQLException {
        int numFilas;
        String consulta = "INSERT INTO horarios(idHorario,horaEntrada,horaSalida,fechaInicio,fechaFin) values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setInt(1, idHorario);
        ps.setString(2, horaEntrada);
        ps.setString(3, horaSalida);
        ps.setString(4, fechaInicio);
        ps.setString(5, fechaFin);
        numFilas = ps.executeUpdate();
        return numFilas;

    }

    public int cambiarHorario(int idHorario, String horaEntrada, String horaSalida, String fechaInicio, String fechaFin) throws SQLException {
        int numFilas;
        String consulta = "UPDATE horarios SET HoraEntrada=?,HoraSalida=?,fechaInicio=?,fechaFin=? WHERE idHorario = ?";
        PreparedStatement ps = conn.prepareStatement(consulta);

        ps.setString(1, horaEntrada);
        ps.setString(2, horaSalida);
        ps.setString(3, fechaInicio);
        ps.setString(4, fechaFin);
        ps.setInt(5, idHorario);

        numFilas = ps.executeUpdate();
        return numFilas;

    }

}
