package trabalho;

import java.util.ArrayList;
import java.util.List;

public class FuncoesUtil {

    public static Integer somarEnergia(List<Guerreiro> guerreiro) {
        return guerreiro.stream().mapToInt(Guerreiro::getEnergia).sum();
    }

    public static void somarPeso(List<Guerreiro> lado1, List<Guerreiro> lado2 ) {
        double pesoLado1 = lado1.stream().mapToDouble(Guerreiro::getPeso).sum();
        double pesoLado2 = lado2.stream().mapToDouble(Guerreiro::getPeso).sum();
        System.out.println("Gregos e Nórdicos pesam - " + pesoLado1 + " unidades");
        System.out.println("Atlantes e Egípcios pesam - " + pesoLado2 + " unidades");
    }

    public static void maiorIdade(List<Guerreiro> lado1, List<Guerreiro> lado2) {
        List<Guerreiro> listaNova = new ArrayList<>();
        listaNova.addAll(lado1);
        listaNova.addAll(lado2);
        final Guerreiro[] maior = {listaNova.get(0)};
        lado1.forEach(u -> {
            if (u.getIdade() > maior[0].getIdade()) {
                maior[0] = u;
            }
        });
        System.out.println(maior[0].getNome() + " é o mais velho (" + maior[0].getIdade() + " unidades)");
    }
}
