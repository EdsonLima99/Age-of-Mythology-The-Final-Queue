/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Egipcios;

import trabalho.Guerreiro;

import java.util.List;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Anubita extends Guerreiro {

    public Anubita(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        int ultimoIndex = atacado.size() - 1;
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 15);
        atacado.get(ultimoIndex).setEnergia(atacado.get(ultimoIndex).getEnergia() - 15);

        if (atacado.get(ultimoIndex).getEnergia() <= 0) {
            removerDaFila(atacado, ultimoIndex);
        }
    }

    /*
    Anubita: possui ataque de 15 pontos de energia, mas ataca 2 vezes. Ataca o primeiro
    guerreiro e depois salta para o final da fila e ataca o último guerreiro da fila adversária.
     */
}
