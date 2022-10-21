/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Egipcios;

import java.util.ArrayList;
import trabalho.Guerreiro;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Mumia extends Guerreiro {

    public Mumia(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - 50);

        if (atacado.get(i).getEnergia() <= 0) {
            atacando.add(new Morto(atacado.get(i).getNome(), atacado.get(i).getIdade(), atacado.get(i).getPeso()));
            morrer(atacando, atacado, i, 0);
        }
    }

}
