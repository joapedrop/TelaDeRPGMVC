package Controller;

import javax.swing.JCheckBox;

import Model.Habilidade;
import View.HabilidadeView;

public class HabilidadeController {
    private HabilidadeView view;
    
    private Habilidade modelo;

    public HabilidadeController(HabilidadeView view) {
        this.view = view;

        this.modelo = new Habilidade();

        JCheckBox[] LCB = view.getCheckHabilidades();
        this.view.configurarModelo(this.modelo);

        for (int i = 0; i < LCB.length; i++) {
            LCB[i].addActionListener(e -> ARmazenarHabilidades());
        }
    }

    private void ARmazenarHabilidades() {
        StringBuilder texto = new StringBuilder();
        JCheckBox[] LCB = view.getCheckHabilidades();

        for (int i = 0; i < LCB.length; i++) {
            boolean correto = LCB[i].isSelected();

            if (correto) {
                texto.append(LCB[i].getText() + ", ");
            }
        }
        String Resultado = texto.toString();

        if (Resultado.endsWith(", ")) {
            Resultado = Resultado.substring(0, Resultado.length() - 2);
        }

        System.out.println(Resultado);
    }
}
