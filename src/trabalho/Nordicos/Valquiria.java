/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Nordicos;

import trabalho.Guerreiro;

import java.util.List;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Valquiria extends Guerreiro {

    public Valquiria(String nome, Integer idade, double peso) {
        super(nome, idade, peso);
    }

    public static void recuperarEnergia(List<Guerreiro> atacando) {
        if (atacando.size() > 1) {
            atacando.get(SEGUNDA_POSICAO).setEnergia(atacando.get(SEGUNDA_POSICAO).getEnergia() + 20);
            if (atacando.get(SEGUNDA_POSICAO).getEnergia() > 100 && !(atacando.get(SEGUNDA_POSICAO).getClass().getPackageName().equals("trabalho.Nordicos"))) {
                atacando.get(SEGUNDA_POSICAO).setEnergia(100);
            }
        }
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 20);
        recuperarEnergia(atacando);
    }


    /*
    Valquíria: é uma espécie de amazona montada num cavalo branco. Possuem poder de cura e
    seu ataque retira 20 pontos de energia. Após atacar, o aliado que estiver após ela, na fila,
    recupera 20 pontos de energia.
     */
}
