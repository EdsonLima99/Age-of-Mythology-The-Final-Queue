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
public class Ciclope extends Guerreiro {

    public Ciclope(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 40);
        if (ordem == 1) {
            atacado.get(posicao).setPronto(0);
            if (atacado.get(posicao).getEnergia() > 0) {
                adicionarNoFinal(atacado);
            }
        }
    }

    /*
    Ciclope: um gigante de um olho só. Promove um ataque que retira 40 pontos de energia e
    depois “joga” o adversário para o final de sua fila (na prática se for o primeiro a atacar não
    vai permitir que o adversário ataque, se for o segundo, esse efeito não terá qualquer impacto
    no que refere a dano ao adversário).
     */
}
