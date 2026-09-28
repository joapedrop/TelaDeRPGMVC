package Controller;

import java.util.ArrayList;

import Model.Habilidade;
import View.HabilidadeView;

public class HabilidadeController {
    private HabilidadeView view;
    private ArrayList<Habilidade> habilidades;

    public HabilidadeController(HabilidadeView view) {
        this.view = view;
        habilidades = new ArrayList<>();

        habilidades.add(new Habilidade("Furtividade", "67%"));
        habilidades.add(new Habilidade("Cura", "67%"));
        habilidades.add(new Habilidade("Força", "67%"));
    }

    private void mostrarHabilidades() {
        String texto = "";
        for (Habilidade habilidade : habilidades) {
            texto = habilidade.getNome() + "\n"; // insere quebra de linha
        }

    }

}