/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;

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
     * Checa se existe motorista com um cpf combinam
     * @param user usuário
     * @param pass senha
     * @return True
    */
    public static boolean saveMotorista (String nome, String cpf, int situacao){
        Motorista m = new Motorista(nome,cpf,situacao);
        return MotoristaDAO.create(m);
    }
}
