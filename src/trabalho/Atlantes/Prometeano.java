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
public class Prometeano extends Guerreiro {

    public Prometeano(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public Prometeano(Guerreiro guerreiro, int energia) {
        super(guerreiro.getNome(), guerreiro.getIdade(), guerreiro.getPeso());
        this.setEnergia(energia);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 10);

        if (atacado.get(i).getEnergia() <= 0) {
            matar(atacando, atacado, i, 0);
        }
    }
}
