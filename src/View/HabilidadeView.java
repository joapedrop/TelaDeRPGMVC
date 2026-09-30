package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Habilidade;

public class HabilidadeView extends JFrame {
    private JCheckBox[] checkHabilidades;

    private Habilidade habilidademodel;
    private JPanel painelFormulario;

    public HabilidadeView() {
        setTitle("Cadastro de Habilidades");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        checkHabilidades = new JCheckBox[4];

        montarTela();
    }

    public void configurarModelo(Habilidade model) {
        this.habilidademodel = model;

        String[] habilidadesnome = habilidademodel.getNome();
        String[] habilitadetaxadeacerto = habilidademodel.getTaxaAcerto();

        for (int i = 0; i < habilidadesnome.length; i++) {
            String nome = habilidadesnome[i] + "- Taxa de acerto: " + habilitadetaxadeacerto[i];
            checkHabilidades[i] = new JCheckBox(nome);
            painelFormulario.add(checkHabilidades[i]);
        }
    }

    private void montarTela() {
        setLayout(new BorderLayout(10, 10));

        painelFormulario = new JPanel(new GridLayout(1, 2, 10, 10));
        painelFormulario.setBorder(
                BorderFactory.createTitledBorder("Selecionar Habilidade"));

        painelFormulario.add(new JLabel("Escolha a Habilidade:"));

        add(painelFormulario, BorderLayout.CENTER);
    }

    public JCheckBox[] getCheckHabilidades() {
        return checkHabilidades;
    }
}
