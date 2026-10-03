package View;

import Controller.*;
import Model.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.ArrayList;

public class PersonagemView extends JFrame {

    private PersonagemController personagemController;
    private ClasseController classeController;
    private DificuldadeController dificuldadeController;
    private HabilidadeController habilidadeController;

    private ClasseView viewClasse;
    private DificuldadadeView viewDificuldade;
    private HabilidadeView viewHabilidade;

    private JTextField txtNome;
    private JSlider SliderNivel;
    private JLabel lblValorNivel;
    private JTextArea txtResumo;
    private JButton btnSalvar;
    private JButton btnLimpar;

    public PersonagemView(ClasseView viewClasse, DificuldadadeView viewDificuldade, HabilidadeView viewHabilidade,
            ClasseController classeCntrl, DificuldadeController difCntrl, HabilidadeController habCntrl) {

        this.viewClasse = viewClasse;
        this.viewDificuldade = viewDificuldade;
        this.viewHabilidade = viewHabilidade;

        this.classeController = classeCntrl;
        this.dificuldadeController = difCntrl;
        this.habilidadeController = habCntrl;
        this.personagemController = new PersonagemController(this);

        montarTela();
        configurarModelo();
    }

    private void montarTela() {
        setTitle("Criação e Resumo do Personagem");
        setSize(550, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel painelDados = new JPanel(new GridLayout(2, 2, 10, 10));
        painelDados.setBorder(BorderFactory.createTitledBorder("Informações Básicas"));

        JPanel painelNomeAux = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel painelSliderAux = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtNome = new JTextField(15);
        painelNomeAux.add(new JLabel("Nome: "));
        painelNomeAux.add(txtNome);
        SliderNivel = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        SliderNivel.setMajorTickSpacing(1);
        SliderNivel.setMinorTickSpacing(1);
        SliderNivel.setPaintTicks(true);
        SliderNivel.setPaintLabels(true);

        lblValorNivel = new JLabel("1");

        painelSliderAux.add(new JLabel("Nível Inicial: "));
        painelSliderAux.add(SliderNivel);
        painelSliderAux.add(lblValorNivel);
        add(painelSliderAux);

        add(painelNomeAux);
        add(painelSliderAux);

        add(viewClasse);
        add(viewDificuldade);
        add(viewHabilidade);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnSalvar = new JButton("Criar Personagem");
        btnLimpar = new JButton("Limpar Tela");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        add(painelBotoes);

        JPanel painelResumo = new JPanel(new BorderLayout());
        painelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do personagem"));
        txtResumo = new JTextArea(10, 40);
        txtResumo.setEditable(false);
        txtResumo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(txtResumo);
        painelResumo.add(scroll, BorderLayout.CENTER);
        add(painelResumo);
    }

    private void configurarModelo() {
        btnSalvar.addActionListener(e -> salvarEGerarResumo());

        btnLimpar.addActionListener(e -> limparTela());

        SliderNivel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                lblValorNivel.setText(String.valueOf(SliderNivel.getValue()));
            }
        });
    }

    private void salvarEGerarResumo() {
        String nome = txtNome.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "eai cadê o nome?");
            return;
        }

        int nivel = SliderNivel.getValue();

        String nomeClasse = classeController.getClasseSelecionada();
        Dificuldade tipoDif = dificuldadeController.getModelDificuldade();
        ArrayList<Habilidade> nomeshabilidades = habilidadeController.getHabilidadesSelecionadas();
        Classe objetoClasse = new Classe();

        int indiceClasse = 0;
        for (int i = 0; i < objetoClasse.getNome().length; i++) {
            if (objetoClasse.getNome()[i].equalsIgnoreCase(nomeClasse)) {
                indiceClasse = i;
                break;
            }
        }

        Personagem novoPersonagem = new Personagem(nome, objetoClasse, tipoDif, nivel, nomeshabilidades);

        personagemController.cadastrar(novoPersonagem);

        StringBuilder resumo = new StringBuilder();

        resumo.append("★ PERSONAGEM CRIADO ★\n");
        resumo.append("-----------------------\n");
        resumo.append("Nome: " + novoPersonagem.getNome()).append("\n");
        resumo.append("Classe: ").append(novoPersonagem.getClasse().getNome()[indiceClasse]).append("\n");
        resumo.append("Descrição da classe: ").append(novoPersonagem.getClasse().getDescricao()[indiceClasse])
                .append("\n");
        resumo.append("Dificuldade: ").append(novoPersonagem.getDificuldade()).append("\n");
        resumo.append("HABILIDADES SELECIONADAS:\n");

        if (novoPersonagem.getHabilidades().isEmpty()) {
            resumo.append(" - Nenhuma habilidade selecionada.\n");
        } else {
            for (Habilidade h : novoPersonagem.getHabilidades()) {
                resumo.append(" • ").append(h.getNome()).append("\n");
            }
        }
        resumo.append("Nível Inicial:   ").append(novoPersonagem.getNivel()).append("\n");
        resumo.append("------------------------------\n");

        txtResumo.setText(resumo.toString());
        JOptionPane.showMessageDialog(this, "Personagem \"" + nome + "\" criado com sucesso!");
    }

    private void limparTela() {
        txtNome.setText("");
        SliderNivel.setValue(1);

        if (viewClasse.getSelectClasse() != null && viewClasse.getSelectClasse().getItemCount() > 0) {
            viewClasse.getSelectClasse().setSelectedIndex(0);
        }

        if (viewHabilidade.getCheckHabilidades() != null) {
            for (JCheckBox cb : viewHabilidade.getCheckHabilidades()) {
                cb.setSelected(false);
            }
        }

        if (viewDificuldade.getSelectdificuldade() != null && viewDificuldade.getSelectdificuldade().length > 0) {
            viewDificuldade.getSelectdificuldade()[0].setSelected(true);
        }
    }
}