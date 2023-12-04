package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        FiltroJogadores filtro = new FiltroJogadores();

        //Diálogo
        print("Digite o nome dos atributos que deseja exibir na busca:");
        String dadosExibicao = entrada.nextLine();

        print("Digite o nome do atributo para filtrar o jogador:");
        String atributoFiltro = entrada.nextLine();

        print("Digite o valor do atributo para filtrar o jogador:");
        String valorFiltrado = entrada.nextLine();

        print("Digite a ordem do filtro (ASC para ascendente / DESC para descendente):");
        String ordem = entrada.next();

        print("Digite a quantidade máxima:");
        int quantidade = entrada.nextInt();
        // end

        print("Dados filtrados abaixo:");
        filtro.filtraJogadores(dadosExibicao.split(" "),atributoFiltro,valorFiltrado,ordem,quantidade);
    }

    static void print(String texto){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(texto);
    }
}
