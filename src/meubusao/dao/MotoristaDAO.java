/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import meubusao.connection.ConnectionFactory;
import meubusao.model.Motorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Automatic
 */
public class MotoristaDAO {
    
    public static boolean create(Motorista t) throws RuntimeException{     
        if (t != null){
            Connection con = ConnectionFactory.getConnection();
            try{
                PreparedStatement stm = con.prepareStatement("INSERT INTO motorista VALUES (?,?,?)");  //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
                stm.setInt(1,Integer.parseInt(t.getCpf()));
                stm.setString(2,t.getNome());
                stm.setInt(3,t.getSituacao());
                stm.execute(); // executa o statement
                // fecha conexões
                stm.close();
                con.close();
                return true;
            }catch(SQLException e){ 
                System.err.println(e);
                throw new RuntimeException("erro ao salvar motorista",e);
            }
        }
        return false;
    }
    
    /**
     * Recupera um ArrayList com todos os motoristas do banco.
     * @return Um ArrayList com os possíveis resultados. (pode ser null)
     */    
    public static ArrayList<Motorista> read () throws RuntimeException{
        ArrayList<Motorista> t_list = null;
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
        try{
            PreparedStatement stm = con.prepareStatement("SELECT * FROM motorista");
            ResultSet rs = stm.executeQuery(); // executa query
            t_list = new ArrayList<Motorista>(); // lista  aser retornada
            while (rs.next()){
                Motorista new_t = new Motorista(rs.getString(1),rs.getString(2),rs.getInt(3)); //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
                t_list.add(new_t);
            }
            // fechando conexões
            stm.close();
            con.close();
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao recuperar motorista",e);
        }
        return t_list;
    }
    
    /**
     * Atualiza o Motorista passado para o BD (placa e situacao, baseado na placa original)
     * @param o 
     */
    public static boolean update(Motorista t) throws RuntimeException{
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("UPDATE motorista SET cpf =?, nome='?', situacao=? WHERE cpf='" + t.getCpf() +"'");
            stm.setInt(1,Integer.parseInt(t.getCpf()));
            stm.setString(2,t.getNome());
            stm.setInt(3,t.getSituacao());
            stm.executeUpdate();    // executa update
            // fecha conexões
            stm.close();
            con.close();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            throw new RuntimeException("erro ao atualizar motorista",e);
        }
    }
    
    /**
     * Remove um conjunto Motorista do BD.
     * @param ts motorista a serem removidos.
     * @throws RuntimeException exceção causada pelo sql
     */
    public static boolean delete(ArrayList<Motorista> ts) throws RuntimeException{
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
        try{
            PreparedStatement stm = con.prepareStatement("DELETE FROM motorista WHERE cpf=?");
            for(Motorista t : ts){  // removendo um a um
                stm.setInt(1,Integer.parseInt(t.getCpf()));;
                stm.executeUpdate();    // executa query 
            }
            // fecha conexão
            stm.close();
            con.close();
            return true;
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao deletar motorista",e);
        }
    }
}
