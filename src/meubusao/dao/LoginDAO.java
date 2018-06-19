/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import java.sql.*;
import java.util.ArrayList;
import meubusao.connection.ConnectionFactory;
import meubusao.model.Login;

/**
 *
 * @author Automatic
 */
public class LoginDAO {
    /**
     * Recupera o Login com o usiario requisitado do banco, se existir.
     * @return Um objeto Login. (pode ser null)
     */    
    public static Login readUser (String user) throws RuntimeException{        
        Login t = null;
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("SELECT * FROM login WHERE usuario=?"); // prepara statement de inserção
            stm.setString(1,user);
            ResultSet rs = stm.executeQuery(); // executa statement
            if(rs.next()) // se não for vazio
                t = new Login(rs.getNString(1),rs.getNString(2)); // garantido login e senha válido;
            // fecha conexões
            stm.close();
            con.close();
            return t;
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao recuperar usuario",e);
        }
    }
}
