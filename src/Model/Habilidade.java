package Model;

public class Habilidade {
    private String nome;
    private String taxaAcerto;

    public Habilidade(String nome, String taxaAcerto) {
        this.nome = nome;
        this.taxaAcerto = taxaAcerto;
    }

    public String getNome() {
        return nome;
    }

    public String getTaxaAcerto() {
        return taxaAcerto;
    }
}
