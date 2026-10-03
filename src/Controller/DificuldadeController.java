package Controller;

import javax.swing.JRadioButton;
import Model.Dificuldade;
import View.DificuldadadeView;

public class DificuldadeController {

    private Dificuldade modelDificuldade;
    private DificuldadadeView ViewDificuldade;

    public DificuldadeController(DificuldadadeView viewDificuldade) {
        this.ViewDificuldade = viewDificuldade;
        
     
        this.modelDificuldade = Dificuldade.FACIL; 
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
                
                
                String nomeTratado = nome.toUpperCase().replace("É", "E").replace("Á", "A");
                this.modelDificuldade = Dificuldade.valueOf(nomeTratado);
                
                System.out.println("Dificuldade atualizada no Controller: " + this.modelDificuldade);
                break;
            }
        }
    }

    
    public Dificuldade getModelDificuldade() {
        return this.modelDificuldade;
    }
}
