import View.*;
import Controller.*;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        ClasseView viewClasse = new ClasseView();
        DificuldadadeView viewDificuldade = new DificuldadadeView();
        HabilidadeView viewHabilidade = new HabilidadeView();

        
        ClasseController cntrlClasse = new ClasseController(viewClasse);
        DificuldadeController cntrlDificuldade = new DificuldadeController(viewDificuldade);
        HabilidadeController cntrlHabilidade = new HabilidadeController(viewHabilidade);

     
        PersonagemView telaPrincipal = new PersonagemView(
            viewClasse, 
            viewDificuldade, 
            viewHabilidade, 
            cntrlClasse, 
            cntrlDificuldade, 
            cntrlHabilidade
        );

      
        telaPrincipal.setVisible(true);
    }
}
