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
public class Morto extends Mumia {

    public Morto(String nome, Integer idade, Double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem) {
        atacado.get(posicao).setEnergia(atacado.get(posicao).getEnergia() - 5);
    }
}
