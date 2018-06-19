/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import java.sql.*;
import java.util.ArrayList;
import meubusao.connection.ConnectionFactory;
import meubusao.model.Linha;
import meubusao.model.Ponto;

/**
 *
 * @author Automatic
 */
public class LinhaDAO {
    /**
     * Recupera a linha com o id requisitado do banco, se existir.
     * @return Um objeto Linha. (pode ser null)
     */    
    public static Linha readId (String id) throws RuntimeException{ // paramentro String?         
        Linha t = null;
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("select linha.nome,ponto.id,ponto.nome,ST_AsText(coord),trajeta.ordem from linha,trajeta,ponto where linha.id=trajeta.linha_id and trajeta.ponto_id=ponto.id and trajeta.linha_id=?"); // prepara statement de inserção
            stm.setInt(1,Integer.parseInt(id));
            ResultSet rs = stm.executeQuery(); // executa statement
            if(rs.next()) {// se não for vazio
                t = new Linha(Integer.parseInt(id),rs.getNString(1)); // garantido login e senha válido;
                ArrayList<Ponto> ap = new ArrayList<Ponto>();
                ap.add(new Ponto(rs.getInt(2),rs.getNString(3),rs.getNString(4))); // ordem fica subentendido (recupera na ordem cresente)
            }
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
