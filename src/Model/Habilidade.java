package Model;

public class Habilidade {
    private String[] nome = new String[4];


	private String[] taxaAcerto = new String[4];
    public Habilidade() {
        this.nome[0] = "Furtividade";
        this.nome[1] = "Força";
        this.nome[2] = "Cura";
        this.nome[3] = "Roubo";
        this.taxaAcerto[0] = "67%";
        this.taxaAcerto[1] = "67%";
        this.taxaAcerto[2] = "67%";
        this.taxaAcerto[3] = "67%";
    }

    public String[] getTaxaAcerto() {
        return taxaAcerto;
    }
    
    public String[] getNome() {
		return nome;
	}
}