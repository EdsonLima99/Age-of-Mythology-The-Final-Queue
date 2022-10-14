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
public class Mumia extends Guerreiro {

    public Mumia(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 50);
        
        if (atacado.get(i).getEnergia() <= 0) {
            Morto morto = new Morto(atacado.get(i).getNome(), atacado.get(i).getIdade(), 100);
            atacando.add(morto);
            
            morre(atacando, atacado, i, 0);
        }

        recuperaHidra(atacando, i);
        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
