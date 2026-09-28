package Model;

import java.util.ArrayList;

//classes de Entidade. classe java bean, POJO
public class Personagem {
    private String nome;
    private Classe classe;
    private Dificuldade dificuldade;
    private int nivel;
    private ArrayList<Habilidade> habilidades;
    
    public Personagem() {
    }

    public Personagem(String nome, Classe classe, Dificuldade dificuldade, int nivel,
            ArrayList<Habilidade> habilidades) {
        this.nome = nome;
        this.classe = classe;
        this.dificuldade = dificuldade;
        this.nivel = nivel;
        this.habilidades = habilidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    
    


}