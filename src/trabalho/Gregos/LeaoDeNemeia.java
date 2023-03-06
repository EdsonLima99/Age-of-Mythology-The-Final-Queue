/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Gregos;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author Edson Lima
 */
public class LeaoDeNemeia extends Guerreiro {

    public LeaoDeNemeia(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int energiaPrometeano1 = verificaPrometeano(atacado, i);

        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 30);

        if (atacado.size() > 1) {
            int energiaPrometeano2 = verificaPrometeano(atacado, (i + 1));

            atacado.get(i + 1).setEnergia(atacado.get(i + 1).getEnergia() - 15);

            if (atacado.size() > 2) {
                int energiaPrometeano3 = verificaPrometeano(atacado, (i + 2));

                atacado.get(i + 2).setEnergia(atacado.get(i + 2).getEnergia() - 5);

                if (atacado.get(i + 2).getEnergia() <= 0) {
                    morrer(atacando, atacado, (i + 2), energiaPrometeano3);
                }
            }

            if (atacado.get(i + 1).getEnergia() <= 0) {
                morrer(atacando, atacado, (i + 1), energiaPrometeano2);
            }
        }

        if (atacado.get(i).getEnergia() <= 0) {
            morrer(atacando, atacado, i, energiaPrometeano1);
        }
    }

}
