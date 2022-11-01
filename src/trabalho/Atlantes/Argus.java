/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Atlantes;

import trabalho.Guerreiro;

import java.util.List;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Argus extends Guerreiro {

    public Argus(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
        this.setEnergia(60);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(0);
    }


        /*
    Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
    imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
    começa em 60 pontos.
     */
}
