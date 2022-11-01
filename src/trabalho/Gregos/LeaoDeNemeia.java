/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Gregos;

import trabalho.Guerreiro;

import java.util.List;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class LeaoDeNemeia extends Guerreiro {

    public LeaoDeNemeia(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {

        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 30);

        if (atacado.size() > 1) {
            atacado.get(SEGUNDA_POSICAO).setEnergia(atacado.get(SEGUNDA_POSICAO).getEnergia() - 15);
            if (atacado.size() > 2) {
                atacado.get(TERCEIRA_POSICAO).setEnergia(atacado.get(TERCEIRA_POSICAO).getEnergia() - 5);
                if (atacado.get(TERCEIRA_POSICAO).getEnergia() <= 0) {
                    morrer(atacado, TERCEIRA_POSICAO);
                }
            }
            if (atacado.get(SEGUNDA_POSICAO).getEnergia() <= 0) {
                morrer(atacado, SEGUNDA_POSICAO);
            }
        }
    }

        /*
        Leão da Nemeia: um leão muito forte e com rugido poderoso. Seu ataque é um grande
    rugido que não afeta apenas o adversário sendo atacado, mas também seu sucessor e quem
    sucedê-lo. Esse rugido afeta em 30 pontos de energia o adversário atacado, em 15 quem
    estiver atrás dele na fila e em 5 quem estiver na terceira posição.
         */
}
