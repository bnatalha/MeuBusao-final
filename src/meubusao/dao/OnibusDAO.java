/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import java.sql.*;
import meubusao.model.Onibus;
import meubusao.connection.ConnectionFactory;
import java.util.ArrayList;

/**
 *
 * @author Natália
 */
public class OnibusDAO {
    
    /**
     * Tenta salvar um Onibus no BD.
     * @param t onibus a ser salvo
     * @return true se conseguiu salvar, false se t == null
     * @throws RuntimeException exceção do causada pelo sql
     */
    public static boolean create(Onibus t) throws RuntimeException {     
        if (t != null){
            Connection con = ConnectionFactory.getConnection();
            try{
                PreparedStatement stm = con.prepareStatement("INSERT INTO onibus VALUES (?,?)");
                stm.setString(1,t.getPlaca());
                stm.setInt(2,t.getSituacao());
                // executa o statement
                stm.execute();
                // fecha conexões
                stm.close();
                con.close();
                return true;
            }catch(SQLException e){
                System.err.println(e);
                throw new RuntimeException("erro ao salvar onibus",e);
            }
        }
        return false;
    }
    
    /**
     * Recupera um ArrayList com todos os ônibus do banco.
     * @return Um ArrayList com os possíveis resultados. (pode ser null)
     */    
    public static ArrayList<Onibus> read () throws RuntimeException{        
        ArrayList<Onibus> t_list = null;
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("SELECT * FROM onibus"); // prepara statement de inserção
            ResultSet rs = stm.executeQuery(); // executa statement
            t_list = new ArrayList<Onibus>();
            while (rs.next()){
                Onibus new_t = new Onibus(rs.getNString(1),rs.getInt(2));
                t_list.add(new_t);
            }
            // fecha conexões
            stm.close();
            con.close();
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao recuperar onibus",e);
        }
        return t_list;
    }
    
    /**
     * Atualiza o Onibus passado para o BD (placa e situacao, baseado na placa original)
     * @param t Onibus a ser atualizado
     */
    public static boolean update(Onibus t) throws RuntimeException{        
        Connection con = ConnectionFactory.getConnection();            
        try{
            PreparedStatement stm = con.prepareStatement("UPDATE onibus SET placa =?, situacao=? WHERE placa='" + t.getPlaca() +"'");
            stm.setString(1,t.getPlaca());
            stm.setInt(2,t.getSituacao());
            stm.executeUpdate(); // executa o statement
            // fecha conexões
            stm.close();
            con.close();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            throw new RuntimeException("erro ao atualizar onibus",e);
        }
    }
    
    /**
     * Remove um conjunto Onibus do BD.
     * @param ts onibus a serem removidos.
     * @return true se conseguiu deletar todos.
     * @throws RuntimeException exceção causada pelo sql
     */
    public static boolean delete(ArrayList<Onibus> ts) throws RuntimeException{        
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("DELETE FROM onibus WHERE placa=?");
            for(Onibus bus : ts){ // removendo os onibus um por um
                stm.setString(1,bus.getPlaca());
                stm.executeUpdate();
            }            
            // fecha conexão
            stm.close();
            con.close();
            return true;
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao deletar onibus",e);
        }
    }
}