import View.ClasseView;
import Controller.ClasseController;

public class App {
    
    public static void main(String[] args) throws Exception {
       
        ClasseView tela = new ClasseView();

        ClasseController controle = new ClasseController(tela);

        tela.setVisible(true);
    }
}
