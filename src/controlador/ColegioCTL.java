/*
 Archivo que contiene la lógica para realizar el crud
 Programador: Moisés Rigoberto Ajú Xicay
 Fecha: 20/09/2025
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ColegioMDL;

/**
 *
 * @author moisesaju
 */
public class ColegioCTL {
    //realizamos la instancia a la conexion de la base de datos y la llamamos cnxmax
    private ConexionBD cnxmax = new ConexionBD();
    //llamamos al método para conectar
    private Connection conectar = cnxmax.conectar();
    //variable para ingresar instrucción sql
    private String query = "";
    //total de registros y va hacer publico para que este accesible en otras clases
    public Integer totalRegistros = 0;
    
    //método para mostrar datos en la tabla
    public DefaultTableModel consultarColegio(String pBuscar){
        //Creamos un objeto donde se cargarán los datos de una tabla
        DefaultTableModel dtm;
        //titulos para la tabla
        String [] titulos = {"Id","Nombre","Dirección","Código","Descripción","Estado","Ingresado Por","Modificado por","Fecha Ingreso","Fecha Modificación"};
        //registros
        String [] columna = new String[10];
        
        //Inicializamos la tabla sin registros y los títulos del arreglo
        dtm = new DefaultTableModel(null,titulos);
        query = "select * from tra_colegio where col_estado = 'A' order by col_nombre asc";
        //query = "select * from tra_colegio where col_nombre like '%"+pBuscar+"' order by col_nombre asc";
        /*if(!pBuscar.equals("") && !pBuscar.equals(null) && !pBuscar.isEmpty()){
            System.out.println("Uno");
            query = "select * from tra_colegio where col_nombre like '%"+pBuscar+"' order by col_nombre asc";
        }else{
            System.out.println("Dos");
            query = "select * from tra_colegio order by col_nombre asc";
        }*/
        
        //utilizamos un try catch para controlar los errores al intentar obtener los datos de la tabla.
        try{
            //Creamos un objeto para poder crear la sentencia
            Statement st = conectar.createStatement();
            //Creamos un objeto para ejecutar el query y devolver los datos
            ResultSet rs = st.executeQuery(query);
            //recorremos el resultado de ResultSet si hay registros
            while(rs.next()){
                columna [0] = rs.getString("col_correlativo");
                columna [1] = rs.getString("col_nombre");
                columna [2] = rs.getString("col_direccion");
                columna [3] = rs.getString("col_codigo");
                columna [4] = rs.getString("col_descripcion");
                columna [5] = rs.getString("col_estado");
                columna [6] = rs.getString("col_usuarioi");
                columna [7] = rs.getString("col_usuariom");
                columna [8] = rs.getString("col_fechai");
                columna [9] = rs.getString("col_fecham");
                
                //realizamos el conteo de registros y sumamos a la variables totalRegistros cada registro encontrado
                totalRegistros = totalRegistros + 1;
                dtm.addRow(columna);
            }
            return dtm;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e, query, 0);
            return null;
        }
    }
    
    //método para insertar
    public boolean insertar(ColegioMDL pDataColegio){
        //creamos el query para insertar datos a la tabla
        query = "insert into tra_colegio(col_correlativo,col_nombre,col_direccion,col_codigo,col_descripcion,col_estado,col_usuarioi,col_usuariom,col_fechai,col_fecham) values(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conectar.prepareStatement(query);
            ps.setInt(1, pDataColegio.getCol_correlativo());
            ps.setString(2, pDataColegio.getCol_nombre());
            ps.setString(3, pDataColegio.getCol_direccion());
            ps.setString(4, pDataColegio.getCol_codigo());
            ps.setString(5, pDataColegio.getCol_descripcion());
            ps.setString(6, pDataColegio.getCol_estado());
            ps.setInt(7, pDataColegio.getCol_usuarioi());
            ps.setInt(8, pDataColegio.getCol_usuariom());
            ps.setString(9, pDataColegio.getCol_fechai());
            ps.setString(10, pDataColegio.getCol_fecham());
            
            //asignamos en una variable el resultado del insert
            int resultadoInsertar = ps.executeUpdate();
            if(resultadoInsertar != 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    //método para modificar
    public boolean modificar(ColegioMDL pDataColegio){
        query = "update tra_colegio set col_correlativo = ?, col_nombre = ?, col_direccion = ?, col_codigo = ?, col_descripcion = ?, col_estado = ?, col_usuarioi = ?, col_usuariom = ?, col_fechai = ?, col_fecham = ? where col_correlativo = ?";
        try{
            PreparedStatement ps = conectar.prepareStatement(query);
            ps.setString(1, pDataColegio.getCol_nombre());
            ps.setString(2, pDataColegio.getCol_direccion());
            ps.setString(3, pDataColegio.getCol_codigo());
            ps.setString(4, pDataColegio.getCol_descripcion());
            ps.setString(5, pDataColegio.getCol_estado());
            ps.setInt(6, pDataColegio.getCol_usuariom());
            ps.setString(7, pDataColegio.getCol_fecham());
            ps.setInt(8, pDataColegio.getCol_correlativo());
            
            //asignamos en una variable el resultado de la actualizacion
            int resultadoUpdate = ps.executeUpdate();
            if(resultadoUpdate != 0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    //método para eliminar
    public boolean eliminar(ColegioMDL pModelColegio){
        query = "delete from tra_colegio where col_correlativo = ?";
        try{
            PreparedStatement ps = conectar.prepareStatement(query);
            ps.setInt(1, pModelColegio.getCol_correlativo());
            
            //asignamos en una variable el resultado de la eliminación
            int resultadoEliminar = ps.executeUpdate();
            if(resultadoEliminar != 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
