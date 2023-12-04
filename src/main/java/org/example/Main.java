package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        FiltroJogadores filtro = new FiltroJogadores();

        //Diálogo
        System.out.println("Digite o nome do atributo para filtrar o jogador");
        String atributoFiltro = entrada.nextLine();

        System.out.println("Digite o valor do atributo para filtrar o jogador");
        String valorFiltrado = entrada.nextLine();

        System.out.println("Digite a ordem do filtro (ASC para ascendente / DESC para descendente)");
        String ordem = entrada.next();

        System.out.println("Digite a quantidade máxima");
        int quantidade = entrada.nextInt();
        // end

        filtro.filtraJogadores(atributoFiltro,valorFiltrado,ordem,quantidade);

//        filtro.imprimeTodosJogadores();
    }
}
