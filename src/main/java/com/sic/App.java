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
            ResultSet rs;

            System.out.println("\t\tDatos sin ordenar");
            rs = stmt.executeQuery("select * from alumnos");
            while (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));

            System.out.println("\t\tDatos ordenados por edad");
            rs = stmt.executeQuery("SELECT * FROM alumnos ORDER BY Edad ASC");
            while (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));

            System.out.println("\t\tDatos ordenados por Unidad");
            rs = stmt.executeQuery("SELECT * FROM alumnos ORDER BY Unidad ASC");
            while (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));

            System.out.println("\t\tDatos ordenados por Apellido");
            rs = stmt.executeQuery("SELECT * FROM alumnos ORDER BY ApPaterno ASC");
            while (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));

            con.close();
        } catch (Exception e) {
            //Imprimir errores
            System.out.print("Ocurrió un error: ");
            System.out.println(e);
        }
    }

}