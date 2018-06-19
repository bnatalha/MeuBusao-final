/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.model;

import java.util.ArrayList;

/**
 *
 * @author Pedro Neto, Natália Brito
 */
public class Linha {
    private int id;
    private String nome;
    private ArrayList<Ponto> pontos;
    
    Linha(){}
    
    public Linha(int id, String nome) throws IllegalArgumentException {
        this.id = id;
        if(isValidNome(nome))
            this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(isValidNome(nome))
            this.nome = nome;
    }
    
    public static boolean isValidNome(String nome) {
        if(nome == null || (nome.length() <= 0 || nome.length() > 45))
            throw new IllegalArgumentException("nome tem que conter entre 1 a 45 caracteres");
        return true;
    }

    @Override
    public String toString() {
        return "Linha{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
