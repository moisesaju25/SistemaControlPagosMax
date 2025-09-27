/*
 Archivo que realiza la conexion a la base de datos
 Programador: Moisés Rigoberto Ajú Xicay
 Fecha: 20/09/2025
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author moisesaju
 */
public class ConexionBD {
    public String db="sistemacontrolpagov1";
    public String host="127.0.0.1";
    public String port="8889";
    public String url="jdbc:mysql://"+host+":"+port+"/" +db;
    public String user="root";
    public String pass="root";
    

    public ConexionBD() {
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error de conexión: "+e.getMessage());
        }
        
        return link;
    }
    
   
    
    
}