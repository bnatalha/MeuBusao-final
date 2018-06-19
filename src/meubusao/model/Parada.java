package meubusao.model;

public class Parada extends Ponto {
    private boolean terminal;

    public Parada(boolean terminal, int id, String nome, String coordenadas) {
        super(id, nome, coordenadas);
        this.terminal = terminal;
    }

    public boolean getTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }
    
}
