/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import meubusao.dao.LoginDAO;
import meubusao.model.Login;

/**
 *
 * @author Automatic
 */
public class LoginController {
    
    /**
     * Checa se senha e usuário combinam
     * @param user usuário
     * @param pass senha
     * @return True
     */
    public static boolean userMatchesPass(String user, String pass){
        Login l = LoginDAO.readUser(user);
        if(l == null)
            throw new RuntimeException("usuario não encontrado");
        return (pass.compareTo(l.getSenha()) == 0);
    }
}
