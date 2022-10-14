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
public class LoboDeFenris extends Guerreiro {

    private static int ataque = 40;

    public LoboDeFenris(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        if (!atacado.isEmpty()) {
            int energiaPrometeano = verificaPrometeano(atacado, i);
            int cont, qtdLobos = 0;

            for (cont = 0; cont < atacando.size(); cont++) {
                if (atacando.get(i).getClass().getSimpleName().equals("LoboDeFenris")) {
                    qtdLobos += 1;
                }
            }
            ataque += (int) ((ataque * 0.2) * qtdLobos);
            atacado.get(i).setEnergia(atacado.get(i).getEnergia() - ataque);

            if (atacado.get(i).getEnergia() <= 0) {
                morre(atacando, atacado, i, energiaPrometeano);
            }
            //        morre(atacado, i);
        }
        
//        recuperaHidra(atacando, i);
//        recuperaHidra(atacado, i);
        adicionarNoFinal(atacando, atacado, i, ordem);
    }

}
