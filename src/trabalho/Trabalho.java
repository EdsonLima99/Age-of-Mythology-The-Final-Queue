/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import trabalho.Atlantes.Argus;
import trabalho.Atlantes.Prometeano;
import trabalho.Atlantes.Satiro;
import trabalho.Egipcios.Anubita;
import trabalho.Egipcios.Mumia;
import trabalho.Gregos.Ciclope;
import trabalho.Gregos.Hidra;
import trabalho.Gregos.LeaoDeNemeia;
import trabalho.Nordicos.LoboDeFenris;
import trabalho.Nordicos.Valquiria;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public class Trabalho {

    private static final int PRIMEIRA_POSICAO = 0;

    public static void rodada(List<Guerreiro> atacando, List<Guerreiro> atacado) {

        atacando.get(PRIMEIRA_POSICAO).setPronto(1);
        atacado.get(PRIMEIRA_POSICAO).setPronto(1);

        atacando.get(PRIMEIRA_POSICAO).atacar(atacando, atacado, 0, 1);
        atacado.get(PRIMEIRA_POSICAO).morrer(atacado, 0);

        if (!atacado.isEmpty() && atacado.get(PRIMEIRA_POSICAO).getPronto() == 1) {
            atacado.get(PRIMEIRA_POSICAO).atacar(atacado, atacando, 0, 2);
            atacando.get(PRIMEIRA_POSICAO).morrer(atacando, 0);
        }

        if (!atacando.isEmpty() && atacando.get(PRIMEIRA_POSICAO).getPronto() == 1) {
            Guerreiro.adicionarNoFinal(atacando);
        }

        if (!atacado.isEmpty() && atacado.get(PRIMEIRA_POSICAO).getPronto() == 1) {
            Guerreiro.adicionarNoFinal(atacado);
        }
    }

    public static void guerra(List<Guerreiro> lado1, List<Guerreiro> lado2) throws FileNotFoundException {
        Random aleatorio = new Random();
        Guerreiro perdedor = null;
        Guerreiro vencedor = null;
        int somaEnergia1 = FuncoesUtil.somarEnergia(lado1);
        int somaEnergia2 = FuncoesUtil.somarEnergia(lado2);

        while (somaEnergia1 > 0 && somaEnergia2 > 0) {
            boolean ordem = aleatorio.nextBoolean();

            if (somaEnergia1 > 0 && somaEnergia1 > somaEnergia2) {
                perdedor = lado2.get(0);
                vencedor = lado1.get(0);
            } else {
                perdedor = lado1.get(0);
                vencedor = lado2.get(0);
            }

            if (ordem) {
                if (!lado2.isEmpty()) {
                    rodada(lado1, lado2);
                }
            } else {
                if (!lado1.isEmpty()) {
                    rodada(lado2, lado1);
                }

            }

            somaEnergia1 = FuncoesUtil.somarEnergia(lado1);
            somaEnergia2 = FuncoesUtil.somarEnergia(lado2);
        }

        if (somaEnergia1 > 0) {
            System.out.println("Gregos e Nórdicos venceram.");
            System.out.println(perdedor.getNome() + ", " + perdedor.getIdade() + ", " + perdedor.getPeso());
            System.out.println(vencedor.getNome() + ", " + vencedor.getIdade() + ", " + vencedor.getPeso());
        } else {
            System.out.println("Atlantes e Egípcios venceram.");
            System.out.println(perdedor.getNome() + ", " + perdedor.getIdade() + ", " + perdedor.getPeso());
            System.out.println(vencedor.getNome() + ", " + vencedor.getIdade() + ", " + vencedor.getPeso());
        }
    }

    public static void lerArquivo(List<Guerreiro> guerreiro, Integer identificador) throws FileNotFoundException {
        if (identificador == 1) {
            Scanner arquivo = new Scanner(new FileReader("lado1.txt"));
            while (arquivo.hasNextLine()) {
                switch (arquivo.nextInt()) {
                    case 1:
                        Ciclope ciclope = new Ciclope(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(ciclope);
                        break;
                    case 2:
                        LeaoDeNemeia leaoDeNemeia = new LeaoDeNemeia(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(leaoDeNemeia);
                        break;
                    case 3:
                        Hidra hidra = new Hidra(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(hidra);
                        break;
                    case 4:
                        Valquiria valquiria = new Valquiria(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(valquiria);
                        break;
                    default:
                        LoboDeFenris loboDeFenris = new LoboDeFenris(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(loboDeFenris);
                        break;
                }
            }
        } else {
            Scanner arquivo = new Scanner(new FileReader("lado2.txt"));
            while (arquivo.hasNextLine()) {
                switch (arquivo.nextInt()) {
                    case 1:
                        Prometeano prometeano = new Prometeano(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(prometeano);
                        break;
                    case 2:
                        Satiro satiro = new Satiro(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(satiro);
                        break;
                    case 3:
                        Argus argus = new Argus(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(argus);
                        break;
                    case 4:
                        Anubita anubita = new Anubita(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(anubita);
                        break;
                    default:
                        Mumia mumia = new Mumia(arquivo.next(), arquivo.nextInt(), arquivo.nextDouble());
                        guerreiro.add(mumia);
                        break;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ArrayList<Guerreiro> lado1 = new ArrayList<>();
        ArrayList<Guerreiro> lado2 = new ArrayList<>();

        lerArquivo(lado1, 1);//Ler arquivo lado1.txt
        lerArquivo(lado2, 2);//Ler arquivo lado2.txt

        FuncoesUtil.somarPeso(lado1, lado2);//Cálcula soma dos pesos de cada lado e imprimir
        FuncoesUtil.maiorIdade(lado1, lado2);//Definir qual o guerreiro com a maior idade
        guerra(lado1, lado2);//Guerra entre os lados
    }

}
