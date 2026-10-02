package Controller;

import javax.swing.JComboBox;

import Model.Classe;
import View.ClasseView;
public class ClasseController {
    private Classe Modelo;
    private ClasseView view;


    public ClasseController(ClasseView view) {
        this.view = view;

        this.Modelo = new Classe();

        JComboBox SC = view.getSelectClasse();

        this.view.configurarModelo(Modelo);

          SC.addActionListener(e -> ARmazenarClasse());
    }

    private void ARmazenarClasse() {
        String selecionado = view.getSelectClasse().getSelectedItem().toString();
        String nome = "";

        if (selecionado.contains("Arqueiro")) {
            nome = selecionado;
        }

        if (selecionado.contains("Barbáro")) {
            nome = selecionado;
        }

        if (selecionado.contains("Clérigo")) {
            nome = selecionado;
        }

        if (selecionado.contains("Mago")) {
            nome = selecionado;
        }

        System.out.println(nome);
    }
}
