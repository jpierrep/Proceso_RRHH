/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author jpierre
 */
public class Transaccion {
    
    private int idTransac;
    private Timestamp fechaTransac;
    private String fechaDatos;
    private int empresa;
    private String nombreArchivo;
    private String rutaArchivo;
    private String proceso;

    public Transaccion(int idTransac, Timestamp fechaTransac, String fechaDatos, int empresa, String nombreArchivo, String rutaArchivo, String proceso) {
        this.idTransac = idTransac;
        this.fechaTransac = fechaTransac;
        this.fechaDatos = fechaDatos;
        this.empresa = empresa;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.proceso = proceso;
    }
    
    

    public int getIdTransac() {
        return idTransac;
    }

    public void setIdTransac(int idTransac) {
        this.idTransac = idTransac;
    }

    public Timestamp getFechaTransac() {
        return fechaTransac;
    }

    public void setFechaTransac(Timestamp fechaTransac) {
        this.fechaTransac = fechaTransac;
    }

    public String getFechaDatos() {
        return fechaDatos;
    }

    public void setFechaDatos(String fechaDatos) {
        this.fechaDatos = fechaDatos;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    
    
    
    
    
    
}
