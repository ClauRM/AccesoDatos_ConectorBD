package conector;

import java.sql.*;

public class Conector {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/pruebaconector"; //sintaxis impuesta por el conector
        String usuario = "pruebaconector";
        String contrasena = "pruebaconector";

        //bloque try-catch para la conexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //importar la clase correpondiente a la libreria que acabamos de importar
            Connection miconexion = DriverManager.getConnection(url, usuario, contrasena);//realiza la conexion
            Statement peticion = miconexion.createStatement(); //crear una sentencia
            String sentenciaSQL = "SELECT * FROM personas"; //escribir sentencia SQL
            ResultSet resultado = peticion.executeQuery(sentenciaSQL); //ejecutar la sentencia SQL y almacenar resultado
            
            while (resultado.next()){ //leer el resultado y mientras que haya registros...
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                String email = resultado.getString("email");
                System.out.println(nombre + " "+ apellidos +" "+ email);
            }
            //cerrar todo lo que hayamos abierto
            resultado.close();
            peticion.close();
            miconexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
