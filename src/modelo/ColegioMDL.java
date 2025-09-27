/*
 Archivo que contiene los atributos del objeto Colegio
 Programador: Moisés Rigoberto Ajú Xicay
 Fecha: 20/09/2025
 */
package modelo;

/**
 *
 * @author moisesaju
 */
public class ColegioMDL {
    private int col_correlativo;
    private String col_nombre;
    private String col_direccion;
    private String col_codigo;
    private String col_descripcion;
    private String col_estado;
    private int col_usuarioi;
    private int col_usuariom;
    private String col_fechai;
    private String col_fecham;
    
    
    public ColegioMDL(){
        
    }

    public ColegioMDL(int col_correlativo, String col_nombre, String col_direccion, String col_codigo, String col_descripcion, String col_estado, int col_usuarioi, int col_usuariom, String col_fechai, String col_fecham) {
        this.col_correlativo = col_correlativo;
        this.col_nombre = col_nombre;
        this.col_direccion = col_direccion;
        this.col_codigo = col_codigo;
        this.col_descripcion = col_descripcion;
        this.col_estado = col_estado;
        this.col_usuarioi = col_usuarioi;
        this.col_usuariom = col_usuariom;
        this.col_fechai = col_fechai;
        this.col_fecham = col_fecham;
    }
    
    public int getCol_correlativo() {
        return col_correlativo;
    }

    public void setCol_correlativo(int col_correlativo) {
        this.col_correlativo = col_correlativo;
    }

    public String getCol_nombre() {
        return col_nombre;
    }

    public void setCol_nombre(String col_nombre) {
        this.col_nombre = col_nombre;
    }

    public String getCol_direccion() {
        return col_direccion;
    }

    public void setCol_direccion(String col_direccion) {
        this.col_direccion = col_direccion;
    }

    public String getCol_codigo() {
        return col_codigo;
    }

    public void setCol_codigo(String col_codigo) {
        this.col_codigo = col_codigo;
    }

    public String getCol_descripcion() {
        return col_descripcion;
    }

    public void setCol_descripcion(String col_descripcion) {
        this.col_descripcion = col_descripcion;
    }

    public String getCol_estado() {
        return col_estado;
    }

    public void setCol_estado(String col_estado) {
        this.col_estado = col_estado;
    }

    public int getCol_usuarioi() {
        return col_usuarioi;
    }

    public void setCol_usuarioi(int col_usuarioi) {
        this.col_usuarioi = col_usuarioi;
    }

    public int getCol_usuariom() {
        return col_usuariom;
    }

    public void setCol_usuariom(int col_usuariom) {
        this.col_usuariom = col_usuariom;
    }

    public String getCol_fechai() {
        return col_fechai;
    }

    public void setCol_fechai(String col_fechai) {
        this.col_fechai = col_fechai;
    }

    public String getCol_fecham() {
        return col_fecham;
    }

    public void setCol_fecham(String col_fecham) {
        this.col_fecham = col_fecham;
    }
}
