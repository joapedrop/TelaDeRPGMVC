package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HabilidadeView extends JFrame {
    private JTextField txtNome;
    private JTextField taxaAcerto;

    private JTextArea habilidadesCadastradas;
    private JButton btnCadastrar;
    private JButton btnLimpar;


    public HabilidadeView() {
        setTitle("Cadastro de Habilidades");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);//vai deixar no centro
        criarComponentes();
        montarTela(); 
    }

    private void criarComponentes(){
        txtNome = new JTextField(20);//define o tamanho em 20 colunas
        taxaAcerto = new JTextField(10);
        habilidadesCadastradas = new JTextArea();
        habilidadesCadastradas.setEditable(false);//area não editavel
        //padrao da fonte é 11
        habilidadesCadastradas.setFont(new Font("Monospaced", Font.PLAIN, 14));

    }

    private void montarTela(){
        setLayout(new BorderLayout(10,10));
        JPanel painelFormulario = new JPanel(new GridLayout());
        painelFormulario.setBorder(
            BorderFactory.createTitledBorder("Cadastrar Habilidade")
        );

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        painelFormulario.add(new JLabel("Nome da habilidade"), gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtNome, gbc);


        // Painel de listagem
        JPanel painelLista =new JPanel(new BorderLayout());

        painelLista.setBorder(
            BorderFactory.createTitledBorder("Habilidades cadastradas"));

        JScrollPane scroll = new JScrollPane(habilidadesCadastradas);
        painelLista.add(scroll,BorderLayout.CENTER);

        //adiciona o painel no JFrame
        add(painelFormulario,BorderLayout.NORTH);

        add(painelLista,BorderLayout.CENTER);
}

// GETTERS
   public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTaxaAcerto() {
        return taxaAcerto;
    }

    public JTextArea getHabilidadesCadastradas() {
        return habilidadesCadastradas;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnLimpar() {
        return btnLimpar;
    }

}

    
