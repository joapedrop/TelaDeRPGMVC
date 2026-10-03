package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import Model.Dificuldade;

public class DificuldadadeView extends JPanel {
    private JRadioButton[] Selectdificuldade;
    private ButtonGroup grupo;
    private Dificuldade dificuldade;
    private JPanel painelDificuldade;

    public DificuldadadeView() {
        setSize(400, 150);

        Selectdificuldade = new JRadioButton[3];
        grupo = new ButtonGroup();

        MontarTela();
    }

    public void configurarModelo(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        Dificuldade[] dificuldades = Dificuldade.values();

        for (int i = 0; i < Selectdificuldade.length; i++) {
            String nome = dificuldades[i].name();

            Selectdificuldade[i] = new JRadioButton(nome);
            grupo.add(Selectdificuldade[i]);
            painelDificuldade.add(Selectdificuldade[i]);
        }
        revalidate();
        repaint();
    }

    private void MontarTela() {
        setLayout(new BorderLayout(10, 10));

        painelDificuldade = new JPanel(new GridLayout(1, 4, 10, 10));
        painelDificuldade.setBorder(
                BorderFactory.createTitledBorder("Selecionar dificuldade"));

        painelDificuldade.add(new JLabel("Escolha a difuculdade:"));

        add(painelDificuldade, BorderLayout.CENTER);
    }

    public JRadioButton[] getSelectdificuldade() {
        return Selectdificuldade;
    }

    public void setSelectdificuldade(JRadioButton[] selectdificuldade) {
        Selectdificuldade = selectdificuldade;
    }

    public ButtonGroup getGrupo() {
        return grupo;
    }

    public void setGrupo(ButtonGroup grupo) {
        this.grupo = grupo;
    }

    public Dificuldade getDificulade() {
        return dificuldade;
    }

    public void setDificulade(Dificuldade dificulade) {
        this.dificuldade = dificulade;
    }

    public JPanel getPainelDificuldade() {
        return painelDificuldade;
    }

    public void setPainelDificuldade(JPanel painelDificuldade) {
        this.painelDificuldade = painelDificuldade;
    }

}
