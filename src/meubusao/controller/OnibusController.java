/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;


import java.util.ArrayList;
import meubusao.dao.OnibusDAO;
import meubusao.model.Onibus;

/**
 * Classe controller de Onibus
 * @author Natália Brito
 */
public class OnibusController {

    /**
     * Tenta salvar um ônibus no BD.
     * @param placa placa do ônibus
     * @param situacao situação do ônibus
     * @return true se conseguiu salvar
     */
    public static boolean saveOnibus (String placa, Integer situacao){
        Onibus o = new Onibus(placa,situacao);
        return OnibusDAO.create(o);
    }
    
    /**
     * Recupera os ônibus do BD como lista de strings.
     * @return null se a lista de onibus recuperada do BD for null
     */
    public static ArrayList<String[]> getAllOnibus(){
        ArrayList<Onibus> os = OnibusDAO.read(); // lista de onibus do BD
        ArrayList<String[]> os_str = null;  // lista a ser retornada
        if(os != null){
            os_str = new ArrayList<String[]>();
            for(Onibus o : os){ // converte onibus para string e os adiciona a 'os_str'
                os_str.add(o.toArrayString(o));
            }            
        }
        return os_str;
    }
}
