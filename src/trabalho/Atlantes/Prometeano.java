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
public class Prometeano extends Guerreiro {

    private Integer energiaInicial = 100;

    public Prometeano(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    public Prometeano(Guerreiro guerreiro, Integer energia) {
        super(guerreiro.getNome(), guerreiro.getIdade(), guerreiro.getPeso());
        this.setEnergia(energia);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 10);
    }

    @Override
    public void morrer(List<Guerreiro> atacado, int posicao) {
        if (getEnergia() <= 1) {
            this.energiaInicial /= 2;
            atacado.add(new Prometeano(atacado.get(posicao), (this.energiaInicial)));//adiciona no atacado um novo Prometeano
            atacado.add(new Prometeano(atacado.get(posicao), (this.energiaInicial)));//adiciona no atacado um novo Prometeano
            atacado.remove(posicao);
        }
    }


        /*
    Prometeano: são guerreiros de barro que se dividem em 2 quando morrem (cada um com
    50% da energia original do prometeano e ambos colocados no final da fila do prometeano
    original). Quando um prometeano chega a 1 ponto de energia, quando morre ele
    efetivamente é eliminado. O ataque de um prometeano é de 10 unidades de energia. Peso e
    idade passam do prometado morto para seus descendentes
     */
}