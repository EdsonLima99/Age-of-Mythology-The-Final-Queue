/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Gregos;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author CONEXOS
 */
public class Hidra extends Guerreiro {

    private static int qtdCabecas = 1;
    private static int ataque = 50;

    public Hidra(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public static void recuperaHidra(ArrayList<Guerreiro> guerreiro, int i) {
        int cont;

        for (cont = 1; cont < guerreiro.size(); cont++) {
            if (guerreiro.get(cont).getClass().getSimpleName().equals("Hidra")) {
                guerreiro.get(cont).setEnergia(guerreiro.get(cont).getEnergia() + 10);
            }
            if (guerreiro.get(cont).getEnergia() > 100 && guerreiro.get(cont).getClass().getSimpleName().equals("Hidra")) {
                guerreiro.get(cont).setEnergia(100);
            }

        }
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        if (!atacado.isEmpty()) {
            int energiaPrometeano = verificaPrometeano(atacado, i);

            atacado.get(i).setEnergia(atacado.get(i).getEnergia() - ataque);

            if (atacado.get(i).getEnergia() <= 0) {
                morre(atacando, atacado, i, energiaPrometeano);
                recuperaHidra(atacando, i);
                ataque += 10 * qtdCabecas;
                qtdCabecas++;
            }
            //        ataquemorre(atacado, i, ataque);
        }

//        recuperaHidra(atacando, i);
//        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
