/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.util.ArrayList;
import trabalho.Egipcios.Anubita;

/**
 *
 * @author CONEXOS
 */
public abstract class Guerreiro {

    private String nome;
    private int idade;
    private double peso;
    private int energia;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public abstract void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> guerreiro, int i, int ordem);

    public static void morre(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int energiaPrometeano) {
        if (atacado.get(i).getEnergia() <= 0) {
            switch (atacado.get(i).getClass().getSimpleName()) {
                case "Mumia":
                    Anubita a1 = new Anubita(atacando.get(i).getNome(), 0, 60);
                    Anubita a2 = new Anubita(atacando.get(i).getNome(), 0, 60);
                    Anubita a3 = new Anubita(atacando.get(i).getNome(), 0, 60);

                    atacando.add(a1);
                    atacando.add(a2);
                    atacando.add(a3);
                    break;
                case "Prometeano":
                    if (energiaPrometeano > 1) {
                        atacado.get(i).setEnergia((int) (energiaPrometeano * 0.5));
                        atacado.add(atacado.get(i));
                        atacado.add(atacado.get(i));
                        atacado.remove(i);
                    } else {
                        atacado.remove(i);
                    }
                    break;
                default:
                    atacado.remove(i);
                    break;
            }
        }
    }

    public static void adicionarNoFinal(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int ordem) {
        if (ordem == 2) {
            atacando.add(atacando.get(i));
            atacando.remove(i);
            atacado.add(atacado.get(i));
            atacado.remove(i);
        }
    }

    public static int verificaPrometeano(ArrayList<Guerreiro> guerreiro, int i) {
        int energiaPrometeano = 100;
        if (guerreiro.get(i).getClass().getSimpleName().equals("Prometeano")) {
            energiaPrometeano = guerreiro.get(i).getEnergia();
        }
        return energiaPrometeano;
    }
}
