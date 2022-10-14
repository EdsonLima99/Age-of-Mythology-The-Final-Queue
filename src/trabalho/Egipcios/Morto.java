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
public class Morto extends Mumia {

    public Morto(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 5);
        
        if (atacado.get(i).getEnergia() <= 0) {            
            morre(atacando, atacado, i, 0);
        }

        recuperaHidra(atacando, i);
        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }
    
}
