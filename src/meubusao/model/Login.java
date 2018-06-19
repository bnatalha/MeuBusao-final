/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.model;

/**
 *
 * @author Natália Brito
 */
public class Login {
    private String usuario;
    private String senha;

    public Login(String usuario, String senha) throws RuntimeException {
        if (isValidUsuario(usuario))
            this.usuario = usuario;
        if (isValidSenha(senha))
            this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) throws RuntimeException {
        if (isValidUsuario(usuario))
            this.usuario = usuario;
    }

    public void setSenha(String senha) throws RuntimeException {
        if (isValidSenha(senha))
            this.senha = senha;
    }
    
    /**
    * Checa se tem existem caractéres que não sejam lowercase ou digitos uma string
    * @param str string a ser checada
    * @param fld campo a ser checado
    * @throws Exception Caractére inválido detectado na string passada
    * @return false se str == null, true se não possuir caractéres estranhos
    */
    private static boolean isValidField(String str, String fld) throws RuntimeException{
        if(str != null){
            for (char c : str.toCharArray()){
                if (!(Character.isLowerCase(c)) & !(Character.isDigit(c)))  // se não for lower case ou digito
                    throw new RuntimeException("caractere inválido detectado"+ fld);
            }
            return true;
        }
        return false;
    }
    
    public static boolean isValidSenha(String senha) {
        if (senha == null|| (senha.length() < 0 || senha.length() > 45))
            throw new RuntimeException("senha tem que ter entre 1 a 45 caracteres");
        return (isValidField(senha, " na campo senha"));
    }
    
    public static boolean isValidUsuario(String usuario) {
        if (usuario == null|| (usuario.length() < 0 || usuario.length() > 45))
            throw new RuntimeException("nome de usuário tem que ter entre 1 a 45 caracteres");
        return (isValidField(usuario, " no campo usuario"));
    }
}
