package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.ObjectUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FiltroJogadores {
    private final String CAMINHO_CSV = "src/main/java/org/example/entrada/fifa_cleaned.csv";
    private final String CAMINHO_SAIDA_CSV = "src/main/java/org/example/saida/";
    private List<Jogador> jogadores;

    //Contrutor armazena lista com todos os jogadores importados do arquivo CSV
    public FiltroJogadores() throws FileNotFoundException {
        CSVReader leitor;
        leitor =  new CSVReader(new FileReader(CAMINHO_CSV));
        this.jogadores = new CsvToBeanBuilder<Jogador>(leitor)
                .withType(Jogador.class)
                .build().parse();
    }
    //end

    public void imprimeTodosJogadores() {
        for(Jogador j : this.jogadores){
            System.out.println(j.toString());
        }
    }

    //Método para filtrar os jogadores com pase nos parâmetros fornecidos pelo usuário
    public void filtraJogadores(String[] dadosExibicao,String atributoFiltro , String valor,
                                String ordem, int quantidade) throws IOException {

        /* Filtra os jogadores apenas pelo valor do atributo (EX: atributo = positions e valor = LW retorna apenas
         jogadores da posição LW) */
        List<Jogador> jogadoresFiltrados = new ArrayList<>(
                jogadores.stream().filter(jogador -> {
                    TreeMap<String, Object> jogadorMap = jogador.getJogadorMapeado(dadosExibicao);
                    return jogadorMap.get(atributoFiltro).toString().equals(valor);
                }).toList()
        );
        //end

        if(jogadoresFiltrados.isEmpty()){
            System.out.println("Nenhum jogador foi encontrado!");
            return;
        }

        //Faz ordenação da lista filtrada com base no ID do jogador
        if(ordem.equals("DESC")){
            jogadoresFiltrados.sort(Collections.reverseOrder());
        }else if(ordem.equals("ASC")){
            Collections.sort(jogadoresFiltrados);
        }else{
            imprimeErro("ordem");
            return;
        }
        //end

        //Finaliza o filtro com base na quantidade informado
        List<Jogador> listaSaida = new ArrayList<>(jogadoresFiltrados.stream().limit(quantidade).toList());

        for(Jogador j : listaSaida){
            System.out.println(j.toString(dadosExibicao));
        }

        Random r = new Random();
        converteObjetosEmCSV(listaSaida , CAMINHO_SAIDA_CSV+ r.nextInt() + ".csv" , dadosExibicao);
    }
    //end

    //Método para imprimir erro no console
    private void imprimeErro(String campo){
        System.out.println("============================================================");
        System.out.println("ERRO");
        System.out.println("Campo '" + campo + "' está inválido!");
        System.out.println("============================================================");
    }
    //end

    //Recebe uma lista de objetos e converte para csv
    public void converteObjetosEmCSV(List<Jogador> jogadores, String pastaCaminho
            , String[] dadosExibicao) throws IOException {
         Writer writer = new FileWriter(pastaCaminho);
         CSVWriter csvWriter = new CSVWriter(writer);

         // Cria o cabeçalho do CSV
         csvWriter.writeNext(
                 jogadores.get(0).getJogadorMapeado(dadosExibicao).keySet().toArray(new String [0])
         );
         //end

            // Escreve cada objeto Jogador no CSV
            for (Jogador jogador : jogadores) {
                csvWriter.writeNext(
                        jogador.getJogadorMapeado(dadosExibicao)
                                .values()
                                .stream()
                                .map(Object::toString)
                                .toList()
                                .toArray(new String[0])
                );
            }

            csvWriter.close();
            writer.close();
            System.out.println("CSV gerado com sucesso!");

    }
    //end
}
