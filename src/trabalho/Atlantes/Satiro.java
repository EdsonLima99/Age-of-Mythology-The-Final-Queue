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
public class Satiro extends Guerreiro {

    public Satiro(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int cont;

        for (cont = 0; cont < atacado.size(); cont++) {
            atacado.get(cont).setEnergia(atacado.get(cont).getEnergia() - 5);
            if (atacado.get(cont).getEnergia() <= 0) {
                matar(atacando, atacado, cont, 0);
                cont--;
            }
        }
    }
}
