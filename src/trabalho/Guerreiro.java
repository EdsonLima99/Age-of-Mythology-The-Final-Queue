/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.util.List;

/**
 *
 * @author Edson Lima e Matheus Gonçalves
 */
public abstract class Guerreiro {

    public static final Integer PRIMEIRA_POSICAO = 0;
    public static final Integer SEGUNDA_POSICAO = 2;
    public static final Integer TERCEIRA_POSICAO = 3;

    private String nome;
    private Integer idade;
    private Double peso;
    private Integer energia;
    private Integer pronto;

    public Guerreiro(String nome, Integer idade, Double peso) {
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getPronto() {
        return pronto;
    }

    public void setPronto(Integer pronto) {
        this.pronto = pronto;
    }

    public abstract void atacar(List<Guerreiro> atacando, List<Guerreiro> atacado, Integer posicao, Integer ordem);

    public void morrer(List<Guerreiro> atacado, int posicao){
        if(atacado.get(posicao).getEnergia() <= 0){
            removerDaFila(atacado, posicao);
        }
    }

    public static void removerDaFila(List<Guerreiro> atacado, Integer posicao){
        atacado.remove(posicao);
    }

    public static void adicionarNoFinal(List<Guerreiro> guerreiro) {
        guerreiro.get(PRIMEIRA_POSICAO).setPronto(0);
        guerreiro.add(guerreiro.get(PRIMEIRA_POSICAO));
        guerreiro.remove(guerreiro.get(PRIMEIRA_POSICAO));
    }
}
