/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;

import java.util.ArrayList;
import meubusao.dao.PontoDAO;
import meubusao.model.Ponto;
/**
 *
 * @author Automatic
 */
public class PontoController {
    
    /**
     * Salva um ponto no BD
     * @param user usuário
     * @param pass senha
     * @return True
    */
    public static boolean savePonto (String id, String nome, String coordenada){
        Ponto p = new Ponto(Integer.parseInt(id),nome,coordenada);
        return PontoDAO.create(p);
    }
    
            /**
     * Recupera os ônibus do BD como lista de strings.
     * @return null se a lista de onibus recuperada do BD for null
     */
    public static ArrayList<String[]> getAllPonto(){
        ArrayList<Ponto> ts = PontoDAO.read(); // lista de onibus do BD
        ArrayList<String[]> ts_str = null;  // lista a ser retornada
        if(ts != null){
            ts_str = new ArrayList<String[]>();
            for(Ponto t : ts){ 
                String t_str[] = new String[3];
                t_str[0] = (new Integer(t.getId())).toString();
                t_str[1] = t.getNome();
                t_str[2] = t.getCoordenadas();
                ts_str.add(t_str);
            }            
        }
        return ts_str;
    }
}
