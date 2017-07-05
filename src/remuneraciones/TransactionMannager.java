/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import Dao.GetData;
import Model.Registro;
import Model.Transaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpierre
 */
public class TransactionMannager extends FileMannager {
    
    List<Transaccion> transacciones;
    GetData getData=new GetData();
    
    
    
    public List<Transaccion>  getTransacciones(int empresa){
        
        return getData.getTransacciones(empresa);
        
    }
    
    
    public List<Registro> getLiquidoTransacciones (int transaction){
        List<Registro> listReg= new ArrayList<>();
        listReg=getData.getDiffLiquido(transaction);

        return listReg;
    }
    
    
    
    
}
