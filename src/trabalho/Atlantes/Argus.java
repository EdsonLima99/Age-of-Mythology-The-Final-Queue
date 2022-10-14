/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Atlantes;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author CONEXOS
 */
public class Argus extends Guerreiro {

    public Argus(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.setEnergia(60);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {

        atacado.get(i).setEnergia(0);
        
        if (atacado.get(i).getEnergia() <= 0) {
            morre(atacando, atacado, i, 0);
        }
//        recuperaHidra(atacando, i);
//        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
