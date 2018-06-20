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
    public static boolean create(Linha t) throws RuntimeException{ // paramentro String?         
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stm = con.prepareStatement("INSERT INTO linha VALUES(?,?)"); // prepara statement
            stm.setInt(1,t.getId());
            stm.setNString(2,t.getNome());
            stm.execute(); // executa statement
            
            stm = con.prepareStatement("INSERT INTO trajeta VALUES(?,?,?)"); // prepara statement
            int ordem = 0;
            for(Ponto p: t.getPontos()){
                stm.setInt(1,t.getId());
                stm.setInt(2,p.getId());
                stm.setInt(3,ordem++);
                stm.execute(); // executa statement
            }
            stm.close();
            con.close();
            return true;
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao inserir linha",e);
        }
    }
    
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
                ArrayList<Ponto> ap = new ArrayList<Ponto>();
                int linha_id = Integer.parseInt(id);
                String linha_nome = rs.getNString(1);
                ap.add(new Ponto(rs.getInt(2),rs.getNString(3),rs.getNString(4))); // ordem fica subentendido (recupera na ordem cresente)
                while(rs.next()){
                    ap.add(new Ponto(rs.getInt(2),rs.getNString(3),rs.getNString(4))); // ordem fica subentendido (recupera na ordem cresente)
                }                
                t = new Linha(linha_id,linha_nome,ap); // id, nome
            }
            // fecha conexões
            stm.close();
            con.close();
            return t;
        }catch(SQLException e){ 
            System.err.println(e);
            throw new RuntimeException("erro ao recuperar linha",e);
        }
    }
    
    public static void main(String args[]) {
        try{
            ArrayList<Ponto> ps = PontoDAO.read();
            Linha l = new Linha(6,"six",ps);
            System.out.println(l+"\n----------");
            
            LinhaDAO.create(l);
            System.out.println("Recuperado:");
            System.out.println(LinhaDAO.readId((new Integer(l.getId())).toString()));
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
