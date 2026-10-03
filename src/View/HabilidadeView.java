package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Habilidade;

public class HabilidadeView extends JPanel {
    private JCheckBox[] checkHabilidades;
    private JPanel painelFormulario;

    public HabilidadeView() {
        setSize(400, 150);
        montarTela();
    }

    
    public void configurarModelo(List<Habilidade> listaHabilidades) {
      
        checkHabilidades = new JCheckBox[listaHabilidades.size()];

        for (int i = 0; i < listaHabilidades.size(); i++) {
            Habilidade hab = listaHabilidades.get(i);
            String textoExibicao = hab.getNome() + " - Taxa de acerto: " + hab.getTaxaAcerto();
            
            checkHabilidades[i] = new JCheckBox(textoExibicao);
            painelFormulario.add(checkHabilidades[i]);
        }
        
       
        painelFormulario.revalidate();
        painelFormulario.repaint();
    }

    private void montarTela() {
        setLayout(new BorderLayout(10, 10));
        painelFormulario = new JPanel(new GridLayout(0, 1, 10, 10)); // 0 linhas significa dinâmico
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Selecionar Habilidade"));
        painelFormulario.add(new JLabel("Escolha a Habilidade:"));
        add(painelFormulario, BorderLayout.CENTER);
    }

    public JCheckBox[] getCheckHabilidades() {
        return checkHabilidades;
    }
}
