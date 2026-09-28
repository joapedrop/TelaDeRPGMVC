package Model;

public class Habilidade {
    private String nome;
    private String taxaAcerto;

    public Habilidade() {
    }

    public Habilidade(String nome, String taxaAcerto) {
        this.nome = nome;
        this.taxaAcerto = taxaAcerto;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTaxaAcerto() {
        return taxaAcerto;
    }
    public void setTaxaAcerto(String taxaAcerto) {
        this.taxaAcerto = taxaAcerto;
    }

    

}