/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;

import meubusao.dao.LinhaDAO;
import meubusao.dao.PontoDAO;
import meubusao.model.Linha;
import meubusao.model.Ponto;

/**
 *
 * @author Automatic
 */
public class LinhaController {
    /**
     * Salva uma linha
     * @param user usuário
     * @param pass senha
     * @return True
    */
    public static boolean saveLinha (String id, String nome, ArrayList<String[]>pontos){
        
        Linha m = new Linha(Integer.parseInt(id),nome,);
        return MotoristaDAO.create(m);
    }
    
}
