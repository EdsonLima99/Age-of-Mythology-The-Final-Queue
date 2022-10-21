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
public class LoboDeFenris extends Guerreiro {

    private int ataque = 40;

    public LoboDeFenris(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        int energiaPrometeano = verificaPrometeano(atacado, i);

        int cont = 1, qtdLobos = 0;

        if (atacando.size() > 1) {
            while (cont < atacando.size() && atacando.get(cont).getClass().getSimpleName().equals("LoboDeFenris")) {
                qtdLobos += 1;
                cont++;
            }
        }

        ataque += (int) ((ataque * 0.2) * qtdLobos);
        atacado.get(i).setEnergia(atacado.get(i).getEnergia() - ataque);

        if (atacado.get(i).getEnergia() <= 0) {
            morrer(atacando, atacado, i, energiaPrometeano);
        }
    }

}
