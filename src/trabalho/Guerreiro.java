/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.util.ArrayList;
import trabalho.Atlantes.Prometeano;
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
    private int pronto;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
        this.pronto = 0;
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

    public int getPronto() {
        return pronto;
    }

    public void setPronto(int pronto) {
        this.pronto = pronto;
    }
    
    public abstract void atacar(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> guerreiro, int i, int ordem);
    
    public static void morre(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado, int i, int energiaPrometeano) {
        if (atacado.get(i).getEnergia() <= 0) {//Se a energia do atacado for menor que 0
            switch (atacado.get(i).getClass().getSimpleName()) {//Switch com o nome da Classe
                case "Mumia"://caso Múmia
                    atacado.add(new Anubita(atacando.get(i).getNome(), 0, 60));//adiciona no atacado um novo Anubita
                    atacado.add(new Anubita(atacando.get(i).getNome(), 0, 60));//adiciona no atacado um novo Anubita
                    atacado.add(new Anubita(atacando.get(i).getNome(), 0, 60));//adiciona no atacado um novo Anubita
                    atacado.add(new Anubita(atacando.get(i).getNome(), 0, 60));//adiciona no atacado um novo Anubita
                    atacado.remove(i);
                    break;
                case "Prometeano"://caso Prometeano
                    if (energiaPrometeano > 1) {
                        atacado.add(new Prometeano(atacado.get(i), (int) (energiaPrometeano * 0.5)));//adiciona no atacado um novo Prometeano
                        atacado.add(new Prometeano(atacado.get(i), (int) (energiaPrometeano * 0.5)));//adiciona no atacado um novo Prometeano
                        atacado.remove(i);
                    } else {
                        atacado.remove(i);
                    }//if
                    break;
                default:
                    atacado.remove(i);
                    break;
            }//switch
        }//if
    }//morre

    public static void adicionarNoFinal(ArrayList<Guerreiro> guerreiro, int i) {
        guerreiro.get(i).setPronto(0);
        guerreiro.add(guerreiro.get(i));
        guerreiro.remove(i);
    }

    public static void adicionarNoFinal(ArrayList<Guerreiro> guerreiro, int i, int ordem) {
        if (ordem == 2) {
            guerreiro.add(guerreiro.get(i));
            guerreiro.remove(i);
        }
    }

    public static int verificaPrometeano(ArrayList<Guerreiro> guerreiro, int i) {
        int energiaPrometeano = 100;
        if (guerreiro.get(i).getClass().getSimpleName().equals("Prometeano")) {
            energiaPrometeano = guerreiro.get(i).getEnergia();
        }
        return energiaPrometeano;
    }
    
    public static void rodada(ArrayList<Guerreiro> atacando, ArrayList<Guerreiro> atacado){
        atacando.get(0).setPronto(1);
        atacado.get(0).setPronto(1);
        
        atacando.get(0).atacar(atacando, atacado, 0, 1);
        if(!atacado.isEmpty() && atacado.get(0).getPronto() == 1){
            atacado.get(0).atacar(atacando, atacado, 0, 2);
        }
        
        adicionarNoFinal(atacando, 0);
        if (!atacado.isEmpty() && atacado.get(0).getPronto() == 1) {
            adicionarNoFinal(atacado, 0);
        }
    }
}
