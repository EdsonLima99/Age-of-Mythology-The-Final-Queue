/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Atlantes;

import trabalho.Guerreiro;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Satiro extends Guerreiro {

    public Satiro(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer i, Integer ordem) {
        AtomicInteger cont = new AtomicInteger();
        atacado.forEach(guerreiro -> {
            guerreiro.setEnergia(guerreiro.getEnergia() - 5);
            if(guerreiro.getEnergia() <= 0){
                morrer(atacado, cont.getAndIncrement());
                cont.decrementAndGet();
            }
        });
    }

    /*
    Sátiro: são guerreiros que utilizam lanças para atacar a distância. Quando atacam tiram
    apenas 5 pontos de energia, entretanto acertam todos os guerreiros da fila adversária.
     */
}
