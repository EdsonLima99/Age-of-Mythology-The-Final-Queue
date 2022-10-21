/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Nordicos;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Valquiria extends Guerreiro {

    public Valquiria(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public static void recuperarEnergia(ArrayList<Guerreiro> atacando, int i) {
        if (atacando.size() > 1) {
            atacando.get(i + 1).setEnergia(atacando.get(i + 1).getEnergia() + 20);

            if (atacando.get(i + 1).getEnergia() > 100 && !(atacando.get(i + 1).getClass().getPackageName().equals("trabalho.Nordicos"))) {
                atacando.get(i + 1).setEnergia(100);
            }
        }
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int energiaPrometeano = verificaPrometeano(atacado, i);

        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 20);

        if (atacado.get(i).getEnergia() <= 0) {
            morrer(atacando, atacado, i, energiaPrometeano);
        }
        recuperarEnergia(atacando, i);
    }
}
