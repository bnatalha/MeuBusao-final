package meubusao.model;

public class Ponto {

    private int id;
    private String nome;
    private String coordenadas; // "POINT(x y)"

    public Ponto(int id, String nome, String coordenadas) {
        this.id = id;
        this.nome = nome;
        this.coordenadas = coordenadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Ponto{" + "id=" + id + ", nome=" + nome + ", coordenadas=" + coordenadas + '}';
    }
    
    public static String[] toArrayString(Ponto p){
        String stra[] = null;
        
        if(p != null){
            stra = new String[3];
            stra[0] = (new Integer(p.getId())).toString();
            stra[1] = p.getNome();
            stra[2] = p.getCoordenadas();
        }
        return stra;
    }
    
    public static Ponto fromStringArray(String[] ponto){        
        Ponto p = null;
        if(ponto != null){
            p = new Ponto(Integer.parseInt(ponto[0]), // id
                    ponto[1], // nome
                    ponto[2]); // POINT(x x)
        }
        return p;
    }
}
