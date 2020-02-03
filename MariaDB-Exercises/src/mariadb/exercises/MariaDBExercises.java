/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariadb.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBExercises {

    private Connection conexion;

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

        public void consultaAlumnos(String bd) throws SQLException {
        String query = "select * from alumnos where nombre like ? Phillip ?"; // Consulta a ejecutar
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
    
    
    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        MariaDBExercises mdb=new MariaDBExercises();
        mdb.abrirConexion("add", "127.0.0.1", "root", "");
        mdb.consultaAlumnos("add");
    }

}
