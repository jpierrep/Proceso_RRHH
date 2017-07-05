package Model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpierre
 */
public class Registro implements Serializable{
    
    private String fecha;
    private int empresa;
    private String variable;
    private int indexColumna;
    private String nombreColumna;
    private String valor;
    private String ficha;
    private String proceso;
    private String valorAnterior;
    private String valorDiferencia;

    public Registro(String fecha, int empresa, String variable, String valor, String ficha) {
        this.fecha = fecha;
        this.empresa = empresa;
        this.variable = variable;
        this.valor = valor;
        this.ficha = ficha;
    }
    
 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getValor() {
        
        
        return valor.replace(",",".");
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIndexColumna() {
        return indexColumna;
    }

    public void setIndexColumna(int indexColumna) {
        this.indexColumna = indexColumna;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public Registro(String fecha, String variable, String nombreColumna,int indexColumna, String valor, String ficha) {
        this.fecha = fecha;
        this.variable = variable;
        this.nombreColumna = nombreColumna;
        this.indexColumna=indexColumna;
        this.valor = valor;
        this.ficha = ficha;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorDiferencia() {
        return valorDiferencia;
    }

    public void setValorDiferencia(String valorDiferencia) {
        this.valorDiferencia = valorDiferencia;
    }

 
    
            
    
    
    
}
