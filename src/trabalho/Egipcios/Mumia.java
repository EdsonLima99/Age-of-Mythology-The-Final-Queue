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
public class Mumia extends Guerreiro {

    public Mumia(String nome, Integer idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 50);
        if (atacado.get(posicao).getEnergia() <= 0) {
            atacando.add(new Morto(atacado.get(posicao).getNome(), atacado.get(posicao).getIdade(), atacado.get(posicao).getPeso()));
        }
    }

    @Override
    public void morrer(List<Guerreiro> atacado, int posicao) {
        if(getEnergia() <= 0){
            atacado.add(new Anubita(atacado.get(posicao).getNome(), 0, 60.0));//adiciona no atacado um novo Anubita
            atacado.add(new Anubita(atacado.get(posicao).getNome(), 0, 60.0));//adiciona no atacado um novo Anubita
            atacado.add(new Anubita(atacado.get(posicao).getNome(), 0, 60.0));//adiciona no atacado um novo Anubita
            atacado.add(new Anubita(atacado.get(posicao).getNome(), 0, 60.0));//adiciona no atacado um novo Anubita
            atacado.remove(posicao);
        }
    }


        /*
    Múmia: são antigos faraós mortos. Possuem ataque de 50 pontos de energia. Quando mata
    um adversário gera um morto vivo e acrescenta em sua fila. Esse morto vivo possui ataque
    de 5 pontos de energia e começa com 100 pontos de energia (assim como a maioria dos
    guerreiros). Quando uma Múmia morre ela invoca 4 Anubitas para vinga-la (sendo
    colocadas no final da fila de seus aliados). O morto-vivo “nasce” com o nome, idade e peso
    do guerreiro adversário morto. Já os Anubitas vingadores “nascem” com o nome da múmia
    morta, idade = 0 e peso = 60.
    */
}
