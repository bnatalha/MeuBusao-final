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
}
