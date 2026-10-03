package Controller;

import Model.Personagem;
import View.PersonagemView;
import java.util.ArrayList;
import java.util.List;

public class PersonagemController {
    
    private PersonagemView view;
    private List<Personagem> bancoDeDadosPersonagens;

    public PersonagemController(PersonagemView view) {
        this.view = view;
        this.bancoDeDadosPersonagens = new ArrayList<>();
    }

    
    public void cadastrar(Personagem personagem) {
        if (personagem != null) {
            bancoDeDadosPersonagens.add(personagem);
        }
    }
}