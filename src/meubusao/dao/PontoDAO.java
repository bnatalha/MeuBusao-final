/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import java.sql.*;
import java.util.ArrayList;
import meubusao.connection.*;
import meubusao.model.Ponto;

/**
 *
 * @author Automatic
 */
public class PontoDAO {
    
    public static boolean create(Ponto t) throws RuntimeException{     
        if (t != null){
            Connection con = ConnectionFactory.getConnection();
            try{
                PreparedStatement stm = con.prepareStatement("INSERT INTO ponto value (?,?,ST_GeomFromText(?))");  //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
                stm.setInt(1,t.getId());
                stm.setString(2,t.getNome());
                stm.setString(3,t.getCoordenadas());
                stm.execute(); // executa o statement
                // fecha conexões
                stm.close();
                con.close();
                return true;
            }catch(SQLException e){ 
                System.err.println(e);
                throw new RuntimeException("erro ao salvar ponto",e);
            }
        }
        return false;
    }

        /**
     * Recupera um ArrayList com todos os pontos do banco.
     * @return Um ArrayList com os possíveis resultados. (pode ser null)
     */    
    public static ArrayList<Ponto> read () throws RuntimeException{
        ArrayList<Ponto> t_list = null;
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
        try{
            PreparedStatement stm = con.prepareStatement("select id, nome, ST_AsText(coord) from ponto;");
            ResultSet rs = stm.executeQuery(); // executa query
            t_list = new ArrayList<Ponto>(); // lista  aser retornada
            while (rs.next()){
                Ponto new_t = new Ponto(rs.getInt(1),rs.getString(2),rs.getString(3)); //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
                t_list.add(new_t);
            }
            // fechando conexões
            stm.close();
            con.close();
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao recuperar motorista(s)",e);
        }
        return t_list;
    }
    
    public static void main(String args[]) {
        Ponto p = new Ponto(141,"avana","POINT(1 52)");
        PontoDAO.create(p);
        ArrayList<Ponto> ap = PontoDAO.read();
        for(Ponto ip : ap){
            System.out.println(ip);
        }
    }
}
