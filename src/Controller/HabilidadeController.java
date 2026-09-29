package Controller;

import Model.Habilidade;
import View.HabilidadeView;

public class HabilidadeController {
    private HabilidadeView view;
    // 1. Criamos o atributo para o modelo de habilidade
    private Habilidade modelo;

    public HabilidadeController(HabilidadeView view) {
        this.view = view;
        
       
        this.modelo = new Habilidade();
        
        
        this.view.configurarModelo(this.modelo);
    }

    private void ARmazenarHabilidades() {
       
        String HabilidadeSelect = view.getComboHabilidades().getSelectedItem().toString();
    }
}
