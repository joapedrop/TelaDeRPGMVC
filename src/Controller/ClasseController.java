package Controller;

import javax.swing.JComboBox;
import Model.Classe; 
import View.ClasseView;

public class ClasseController {
    private ClasseView view;
    private Classe modelo; // Atributo para segurar o modelo
    private String classeSelecionada = ""; 

    public ClasseController(ClasseView view) {
        this.view = view;
        
      
        this.modelo = new Classe();
        
       
        this.view.configurarModelo(this.modelo);
        
        JComboBox SC = view.getSelectClasse();
      
      
        if (SC.getSelectedItem() != null) {
            tratarEArmazenar(SC.getSelectedItem().toString());
        }

        SC.addActionListener(e -> ARmazenarClasse());
    }

    private void ARmazenarClasse() {
        if (view.getSelectClasse().getSelectedItem() != null) {
            String selecionado = view.getSelectClasse().getSelectedItem().toString();
            tratarEArmazenar(selecionado);
        }
    }

  
    private void tratarEArmazenar(String textoComboBox) {
        if (textoComboBox.contains("-")) {
            this.classeSelecionada = textoComboBox.split("-")[0].trim();
        } else {
            this.classeSelecionada = textoComboBox.trim();
        }
        System.out.println("Classe armazenada no Controller: " + this.classeSelecionada);
    }

    public String getClasseSelecionada() {
        return this.classeSelecionada;
    }
}
