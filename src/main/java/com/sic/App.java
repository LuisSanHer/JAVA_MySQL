package com.sic;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        //Try-Catch para manejo de errores
        try {
            //Llamada a la libreria mysql conector
            Class.forName("com.mysql.jdbc.Driver");
            //Nueva conexión                           conexión a localhost |   nombre de bd | ususario mysql | contraseña  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "luissanher", "pass1234");
            //Nuevo statement para llamada de datos
            Statement stmt = con.createStatement();
            //Creación de Query | llamada a todos los datos de la tabla alumnos
            ResultSet rs = stmt.executeQuery("select * from alumnos");
            //Ciclo de todos los elementos obtenidos por el query
            while (rs.next())
                //Impresión de los valores
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            //Se cierra la conexión 
            con.close();
        } catch (Exception e) {
            //Imprimir errores
            System.out.print("Ocurrió un error: ");
            System.out.println(e);
        }
    }

}