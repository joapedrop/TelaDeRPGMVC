package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Classe;

public class ClasseView extends JFrame {
    private JComboBox<String> SelectClasse;

    private Classe ModelClasse;
    private JPanel PainelClasse;

    public ClasseView() {
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        SelectClasse = new JComboBox<>();

        MontarTela();
    }

    public void configurarModelo(Classe ModelClasse) {
        this.ModelClasse = ModelClasse;
        String[] nomeclass = ModelClasse.getNome();
        String[] descricao = ModelClasse.getDescricao();

        for (int i = 0; i < nomeclass.length; i++) {
            String nome = nomeclass[i] + "-Descrição: " + descricao[i];

            SelectClasse.addItem(nome);

        }

    }

    private void MontarTela() {
        setLayout(new BorderLayout(10, 10));

        PainelClasse = new JPanel(new GridLayout(1, 4, 10, 10));
        PainelClasse.setBorder(
                BorderFactory.createTitledBorder("Selecionar classe"));

        PainelClasse.add(new JLabel("Escolha a classe:"));
        PainelClasse.add(SelectClasse);
        add(PainelClasse, BorderLayout.CENTER);
    }

    public JComboBox<String> getSelectClasse() {
        return SelectClasse;
    }

    public void setSelectClasse(JComboBox<String> selectClasse) {
        SelectClasse = selectClasse;
    }
}
