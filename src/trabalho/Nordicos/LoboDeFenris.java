/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Nordicos;

import trabalho.Guerreiro;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class LoboDeFenris extends Guerreiro {

    private Integer ataque = 40;

    public LoboDeFenris(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        verificarQtdLobos(atacando);
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - ataque);
    }


    private void verificarQtdLobos(List<Guerreiro> atacando){
        AtomicInteger cont = new AtomicInteger();
        AtomicInteger qtdLobos = new AtomicInteger();

        if (atacando.size() > 1) {
            while (cont.get() < atacando.size() && atacando.get(cont.getAndIncrement()).getClass().getSimpleName().equals("LoboDeFenris")) {
                qtdLobos.getAndIncrement();
            }
        }
        ataque += (int) ((ataque * 0.2) * qtdLobos.get());
    }

    /*
    Lobo de Fenris: são lobos gigantes ferozes. Seu ataque é de 40 pontos de energia. Entretanto
    seu ataque aumenta em 20% para cada Lobo de Fenris que estiver atrás dele. Ou seja, se
    houverem 2 lobos na sequência na fila, o Lobo atual ganha mais 16 pontos de ataque (8 para
    cada lobo) totalizando 56 pontos de ataque.
     */

}
