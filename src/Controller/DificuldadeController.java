package Controller;

import javax.swing.JRadioButton;
import Model.Dificuldade;
import View.DificuldadadeView;

public class DificuldadeController {

    private Dificuldade modelDificuldade;
    private DificuldadadeView ViewDificuldade;

    public DificuldadeController(DificuldadadeView viewDificuldade) {
        this.ViewDificuldade = viewDificuldade;

      this.ViewDificuldade.configurarModelo(this.modelDificuldade);

        JRadioButton[] SD = ViewDificuldade.getSelectdificuldade();
        for (int i = 0; i < SD.length; i++) {
        
            SD[i].addActionListener(e -> ARmazenarDificuldade());
        }
    }

    private void ARmazenarDificuldade() {
    JRadioButton[] SD = ViewDificuldade.getSelectdificuldade();
    
    for (int i = 0; i < SD.length; i++) {
        if (SD[i].isSelected()) {
            String nome = SD[i].getText(); 
            
            
            this.modelDificuldade = Dificuldade.valueOf(nome.toUpperCase());
            
            System.out.println("Dificuldade selecionada: " + this.modelDificuldade);
            break;
        }
    }
}

}
