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
public class Hidra extends Guerreiro {

    private int qtdCabecas = 1;
    private int ataque = 50;

    public Hidra(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    public static void recuperaHidra(Guerreiro guerreiro) {
        guerreiro.setEnergia(guerreiro.getEnergia() + 10);
        if (guerreiro.getEnergia() > 100) {
            guerreiro.setEnergia(100);
        }
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - ataque);
        if (atacado.get(posicao).getEnergia() <= 0) {
            recuperaHidra(this);
            ataque += 10 * qtdCabecas;
            qtdCabecas++;
        }
    }

    /*
    Hidra: parece um dinossauro aquático, ganha uma cabeça para cada inimigo que mata. Seu
    ataque inicial é de 50 pontos de energia, mas ganha mais 10 pontos de ataque para cada
    cabeça nova gerada, além de mais 10 pontos de recuperação de energia para si mesmo (se a
    hidra não tiver sido atacada ainda, ou seja, tiver os 100 pontos de energia, nada acontece).
     */

}
