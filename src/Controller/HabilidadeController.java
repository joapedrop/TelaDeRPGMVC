package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import Model.Habilidade;
import View.HabilidadeView;

public class HabilidadeController {
    private HabilidadeView view;
    private ArrayList<Habilidade> habilidades;
    
    public HabilidadeController(HabilidadeView view) {
        this.view = view;
        habilidades = new ArrayList<>();
        configurarEventos();
    }

    private void configurarEventos(){
        view.getBtnCadastrar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               adicionarHabilidade();
            }
            
        });
    }

    private void adicionarHabilidade(){
        //método trim tira espaços antes e depois do que foi 
        //digitado
        String nome = View.getTxtNome().getText().trim();
        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(view, "Digite a habilidade");
            return;
        }
        Habilidade habilidade = new Habilidade();
        habilidade.setNome(nome);
        habilidades.add(habilidade);
        mostrarHabilidades();//adiciona na textArea
    }

    private void mostrarHabilidades(){
        String texto = "";
        for (Habilidade habilidade : habilidades) {
            texto = habilidade.getNome()+ "\n"; //insere quebra de linha
        }
        View.getHabilidadesCadastradas().setText(texto);

    }

    

}