/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;

import java.util.ArrayList;
import meubusao.dao.MotoristaDAO;
import meubusao.model.Motorista;
/**
 *
 * @author Automatic
 */
public class MotoristaController {
    
    /**
     * Checa se existe motorista com um cpf combinam
     * @param user usuário
     * @param pass senha
     * @return True
    */
    public static boolean revocerMotorista (String cpf){
        Motorista m = MotoristaDAO.readCpf(cpf);
        if(m == null)
            throw new RuntimeException("motorista não encontrado");
        return true;
    }
    
        /**
     * Recupera os ônibus do BD como lista de strings.
     * @return null se a lista de onibus recuperada do BD for null
     */
    public static ArrayList<String[]> getAllMotorista(){
        ArrayList<Motorista> ms = MotoristaDAO.read(); // lista de onibus do BD
        ArrayList<String[]> ms_str = null;  // lista a ser retornada
        if(ms != null){
            ms_str = new ArrayList<String[]>();
            for(Motorista m : ms){ // converte onibus para string e os adiciona a 'os_str'
                ms_str.add(m.toArrayString(m));
            }            
        }
        return ms_str;
    }
}
