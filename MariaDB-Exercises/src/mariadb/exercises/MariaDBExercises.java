/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariadb.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBExercises {

    private Connection conexion;
    private PreparedStatement ps = null;

    public void abrirConexion(String bd, String servidor, String usuario, String password) {
        try {
            String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
            this.conexion = DriverManager.getConnection(url, usuario, password);//Establecemos la conexión con la BD
            if (this.conexion != null) {
                System.out.println("Conectado a la base de datos " + bd + " en " + servidor);
            } else {
                System.out.println("No se ha conectado a la base de datos " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        }
    }

    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    public void ejemplo(String bd) throws SQLException {
        String query = "select * from aulas"; // Consulta a ejecutar
        abrirConexion("add", "localhost", "root", "");
        Statement stmt = this.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(query); // Se ejecuta la consulta
        while (rs.next()) { // Mientras queden filas en rs (el método next devuelve true) recorremos las filas
            System.out.println(rs.getInt(1) + "\t"
                    + // Se obtiene datos en función del número de columna
                    rs.getString("nombreAula") + "\t" + rs.getInt("puestos")); // o de su nombre
        }
        stmt.close(); // Se cierra el Statement
        cerrarConexion(); // Se cierra la conexión
    }

    public void consultaAlumnosPatronNombre(String patron) throws SQLException {
        String query = "SELECT nombre,cant FROM alumnos,(SELECT count(nombre) AS cant FROM alumnos WHERE nombre LIKE ?) AS subCon WHERE nombre LIKE ?;";
        abrirConexion("add", "localhost", "root", "");
        Statement stmt = this.conexion.createStatement();
        if (this.ps == null) {
            this.ps = this.conexion.prepareStatement(query);
        }
        ps.setString(1, "%" + patron + "%");
        ps.setString(2, "%" + patron + "%");
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()) {
            System.out.println("\t" + resultado.getString("nombre"));
            if (resultado.isLast()) {

                System.out.println("\t -Cantidad: " + resultado.getString("cant"));
            }

        }
        stmt.close();
        cerrarConexion();
    }

    public void insertarAlumno(String codigo, String nombre, String apellido, String altura, String aula) {
        try {
            Statement sta = this.conexion.createStatement();
            String query = String.format("INSERT INTO alumnos VALUES (%s,'%s','%s',%s,%s)", codigo, nombre, apellido, altura, aula);
            int filasAfectadas = sta.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
            sta.close();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        }
    }

    public void insertarAsignatura(String codigo, String asignatura) {
        try {
            Statement sta = this.conexion.createStatement();
            String query = String.format("INSERT INTO asignaturas VALUES (%s,'%s')", codigo, asignatura);
            int filasAfectadas = sta.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
            sta.close();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        }
    }

    public void consultaAlumnosAprobados() throws SQLException {
        String query = " SELECT distinct alumnos.nombre, asignaturas.NOMBRE as AsiNombre,notas.NOTA FROM alumnos,asignaturas JOIN notas WHERE alumnos.codigo=notas.alumno AND asignaturas.COD=notas.asignatura AND notas.NOTA >=5";
        abrirConexion("add", "localhost", "root", "");
        Statement stmt = this.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("nombre") + " - " + rs.getString("AsiNombre") + " - " + rs.getString("nota"));
        }
        stmt.close();
        cerrarConexion();
    }

    public void consultaAlumnoPatronesCon(String nombre, String altura) throws SQLException {
        String query = "SELECT nombre,altura FROM alumnos WHERE nombre LIKE ? and altura>?;";
        abrirConexion("add", "localhost", "root", "");
        Statement stmt = this.conexion.createStatement();
        if (this.ps == null) {
            this.ps = this.conexion.prepareStatement(query);
        }
        ps.setString(1, "%" + nombre + "%");
        ps.setString(2, "%" + altura + "%");
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()) {
            System.out.println("\t" + resultado.getString("nombre") + " - " + resultado.getString("altura"));
        }
        stmt.close();
        cerrarConexion();
    }

    public void consultaAlumnoPatronesSin(String nombre, String altura) throws SQLException {
        Statement sta = this.conexion.createStatement();
        String query = String.format("SELECT nombre,altura FROM alumnos WHERE nombre LIKE '%s' and altura>%s;", nombre, altura);
        abrirConexion("add", "localhost", "root", "");
        if (this.ps == null) {
            this.ps = this.conexion.prepareStatement(query);
        }
        this.ps = this.conexion.prepareStatement(query);
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()) {
            System.out.println("\t" + resultado.getString("nombre") + " - " + resultado.getString("altura"));
        }
        sta.close();
        cerrarConexion();

    }

    public static void main(String[] args) throws SQLException {
        MariaDBExercises mdb = new MariaDBExercises();
        mdb.abrirConexion("add", "127.0.0.1", "root", "");
//        mdb.consultaAlumnosPatronNombre("h");
//        mdb.insertarAlumno("10", "Natalie", "Paquette", "175", "20");
//        mdb.insertarAsignatura("9", "Algo");
//        mdb.consultaAlumnosAprobados();
//        mdb.consultaAlumnoPatronesCon("h", "150");
//        mdb.consultaAlumnoPatronesSin("%h%", "150");

    }

}
