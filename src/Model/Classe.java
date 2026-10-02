package Model;

public class Classe {
    private String[] nome = new String[4];
    private String[] descricao = new String[4];

    public Classe() {
        this.nome[0] = "Arqueiro";
        this.nome[1] = "Barbáro";
        this.nome[2] = "Clérigo";
        this.nome[3] = "Mago";
        this.descricao[0] = "Sua maior habilidade é sua mira estupenda";
        this.descricao[1] = "Vai lá e mate todos em seu caminho!";
        this.descricao[2] = "Em nome do pai do filho e do espirito do santo o mal caira por terra!";
        this.descricao[3] = "abra kadabra alakazam!";
    }

    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public String[] getDescricao() {
        return descricao;
    }

    public void setDescricao(String[] descricao) {
        this.descricao = descricao;
    }

}