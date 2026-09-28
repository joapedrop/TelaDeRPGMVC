import View.HabilidadeView;
import Controller.HabilidadeController;

public class App {
    public static void main(String[] args) throws Exception {
       
        HabilidadeView tela = new HabilidadeView();

        HabilidadeController controle = new HabilidadeController(tela);

        tela.setVisible(true);
    }
}
