/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Gregos;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Hidra extends Guerreiro {

    private int qtdCabecas = 1;
    private int ataque = 50;

    public Hidra(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public static void recuperaHidra(Guerreiro guerreiro, int i) {
        guerreiro.setEnergia(guerreiro.getEnergia() + 10);
        if (guerreiro.getEnergia() > 100) {
            guerreiro.setEnergia(100);
        }
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int energiaPrometeano = verificaPrometeano(atacado, i);

        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - ataque);

        if (atacado.get(i).getEnergia() <= 0) {
            morrer(atacando, atacado, i, energiaPrometeano);
            recuperaHidra(this, i);
            ataque += 10 * qtdCabecas;
            qtdCabecas++;
        }
    }

}
