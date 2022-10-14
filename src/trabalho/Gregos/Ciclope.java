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
public class Ciclope extends Guerreiro {

    public Ciclope(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        if (!atacado.isEmpty()) {
            int energiaPrometeano = verificaPrometeano(atacado, i);

            if (ordem == 1) {
                atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 40);
            }
            if (atacado.get(i).getEnergia() <= 0) {
                morre(atacando, atacado, i, energiaPrometeano);
            }
            
            atacado.add(atacado.get(i));
            atacado.remove(i);
        }
        
        recuperaHidra(atacando, i);
        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
