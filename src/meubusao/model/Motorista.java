package meubusao.model;

/**
 * @author Natália Brito
 */
public class Motorista {
    
    private String cpf;
    private String nome;
    private int situacao;

    public Motorista(String cpf, String nome, int situacao) throws IllegalArgumentException{
        if (isValidNome(nome))
            this.nome = nome;
        if(isValidCpf(cpf))
            this.cpf = cpf;
        if(isValidSituacao(situacao))
            this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        if (isValidNome(nome))
            this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException{
        if(isValidCpf(cpf))
            this.cpf = cpf;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) throws IllegalArgumentException{
        if(isValidSituacao(situacao))
            this.situacao = situacao;
    }
    
    public static boolean isValidNome(String nome) {
        if(nome == null || (nome.length() <= 0 || nome.length() > 45))
            throw new IllegalArgumentException("nome tem que conter entre 1 a 45 caracteres");
        return true;
    }
    
    public static boolean isValidCpf(String cpf) {
        if(cpf == null || cpf.length() != 11) 
            throw new IllegalArgumentException("cpf deve conter 11 caracteres");
        return true;
    }
    
    public static boolean isValidSituacao(int situacao) {
        if(situacao < 0 || situacao > 9) 
            throw new IllegalArgumentException("situação deve ser um valor entre 0 e 9");
        return true;
    }
    
    @Override
    public String toString(){
        return (this.getNome() + " " + this.getCpf());
    }
    
    public static String[] toArrayString(Motorista m){
        String stra[] = null;
        
        if(m != null){
            stra= new String[3];
            stra[0] = m.getNome();
            stra[1] = m.getCpf();
            stra[2] = (new Integer(m.getSituacao())).toString();
        }
        return stra;
    }

}
