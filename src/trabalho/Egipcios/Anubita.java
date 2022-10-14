/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Egipcios;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author CONEXOS
 */
public class Anubita extends Guerreiro {

    public Anubita(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int cont = atacado.size();

        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 15);
        atacado.get(cont).setEnergia(atacado.get(cont).getEnergia() - 15);

        if (atacado.get(i).getEnergia() <= 0) {
            morre(atacando, atacado, i, 0);
        }
        if (atacado.get(cont).getEnergia() <= 0) {
            morre(atacando, atacado, cont, 0);
        }

        atacando.add(this);
        atacando.remove(i);

//        recuperaHidra(atacando, i);
//        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
