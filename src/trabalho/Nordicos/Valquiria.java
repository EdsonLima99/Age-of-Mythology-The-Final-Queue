/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Nordicos;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author CONEXOS
 */
public class Valquiria extends Guerreiro {

    public Valquiria(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public static void recuperarEnergia(ArrayList<Guerreiro> atacando, int i) {
        atacando.get(i).setEnergia(atacando.get(i).getEnergia() + 10);

        if (atacando.get(i).getEnergia() > 100 && !(atacando.get(i).getClass().getSuperclass().getSimpleName().equals("Nordicos"))) {
            atacando.get(i).setEnergia(100);
        }
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        if (!atacado.isEmpty()) {
            int energiaPrometeano = verificaPrometeano(atacado, i);

            atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 20);

            if (atacado.get(i).getEnergia() <= 0) {
                morre(atacando, atacado, i, energiaPrometeano);
            }
        }
        
//        recuperaHidra(atacando, i);
//        recuperaHidra(atacado, i);
        recuperarEnergia(atacando, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
