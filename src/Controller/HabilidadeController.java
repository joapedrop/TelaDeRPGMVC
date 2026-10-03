package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import Model.Habilidade;
import View.HabilidadeView;

public class HabilidadeController {
    private HabilidadeView view;
    private List<Habilidade> catalogoHabilidades;
    private ArrayList<Habilidade> habilidadesSelecionadas; 

    public HabilidadeController(HabilidadeView view) {
        this.view = view;
        this.catalogoHabilidades = new ArrayList<>();
        this.habilidadesSelecionadas = new ArrayList<>();

        catalogoHabilidades.add(new Habilidade("Furtividade", "67%"));
        catalogoHabilidades.add(new Habilidade("Força", "67%"));
        catalogoHabilidades.add(new Habilidade("Cura", "67%"));
        catalogoHabilidades.add(new Habilidade("Roubo", "67%"));

        this.view.configurarModelo(this.catalogoHabilidades);

       
        JCheckBox[] LCB = view.getCheckHabilidades();
        for (int i = 0; i < LCB.length; i++) {
            if (i < catalogoHabilidades.size()) {
                LCB[i].putClientProperty("objetoHabilidade", catalogoHabilidades.get(i));
            }
            LCB[i].addActionListener(e -> armazenarHabilidades());
        }
    }

    private void armazenarHabilidades() {
        this.habilidadesSelecionadas.clear();
        JCheckBox[] LCB = view.getCheckHabilidades();

        for (int i = 0; i < LCB.length; i++) {
            if (LCB[i].isSelected()) {
               
                Habilidade h = (Habilidade) LCB[i].getClientProperty("objetoHabilidade");
                if (h != null) {
                    this.habilidadesSelecionadas.add(h);
                }
            }
        }
        System.out.println("Habilidades guardadas no Controller: " + habilidadesSelecionadas.size());
    }

    // Retorna exatamente o ArrayList que a PersonagemView precisa
    public ArrayList<Habilidade> getHabilidadesSelecionadas() {
        return this.habilidadesSelecionadas;
    }
}
