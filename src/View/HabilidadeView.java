package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Habilidade;

public class HabilidadeView extends JFrame {
    private JComboBox<String> comboHabilidades;
    private Habilidade habilidademodel;

    public HabilidadeView() {
        setTitle("Cadastro de Habilidades");
        setSize(400, 150); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        
       
        comboHabilidades = new JComboBox<>();
        
        
        
        montarTela();
    }

   
    public void configurarModelo(Habilidade model) {
        this.habilidademodel = model;
        
        String[] habilidadesnome = habilidademodel.getNome();
        String[] habilitadetaxadeacerto = habilidademodel.getTaxaAcerto();
        
    
        for (int i = 0; i < habilidadesnome.length; i++) {
            comboHabilidades.addItem(habilidadesnome[i] + ", Taxa de acerto: " + habilitadetaxadeacerto[i]);
        }
    }

    private void montarTela() {
        setLayout(new BorderLayout(10, 10));

        JPanel painelFormulario = new JPanel(new GridLayout(1, 2, 10, 10));
        painelFormulario.setBorder(
                BorderFactory.createTitledBorder("Selecionar Habilidade"));

        painelFormulario.add(new JLabel("Escolha a Habilidade:"));
        painelFormulario.add(comboHabilidades);

        add(painelFormulario, BorderLayout.CENTER);
    }

    public JComboBox<String> getComboHabilidades() {
        return comboHabilidades;
    }
}
