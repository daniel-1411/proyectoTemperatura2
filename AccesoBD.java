/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP Mañana A
 */
class AccesoBD {

    private static Connection conexcion=null;
    private static Statement stmt=null;
    
    static void conectar() {
        try {
            conexcion=DriverManager.getConnection("jdbc:mysql://localhost:3306/espanita", "root", "");
            stmt= conexcion.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    static boolean mirarProvincias() {
            Boolean n = null;
        String sql="SELECT COUNT(*) as numero FROM provincias;";
        
		try {
                    int nprovincias=0;
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
                        {
			 nprovincias=rs.getInt("numero");
                        }
                        if (nprovincias!=0) {
                        n=true;
                    }else{
                        n=false;    
                        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
    }

    static void introducirProvincias(ClaseRaiz a) {     
       try {
           conexcion.setAutoCommit(false);
        for (Provinciero p : a.getProvinciero()) {
           String query="INSERT INTO provincias(codigo,nombre) VALUES('"+p.getCodigo()+"','"+p.getNombre()+"');";
           stmt.executeUpdate(query);
           conexcion.commit();
        }
        } catch (SQLException ex) {
           Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    static ArrayList<String> recogerDatosProvincias() {
        
        ArrayList<String> lista_provincias=new ArrayList<String>();
		
		String sql="SELECT * FROM provincias;";
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String nombre_pro=rs.getString("nombre");			
				lista_provincias.add(nombre_pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_provincias;
    }
    
}