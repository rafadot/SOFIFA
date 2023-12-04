package org.example;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import java.util.TreeMap;

@Getter
@Setter
public class Jogador implements Comparable<Jogador>{
    //Mapeia os atributos do jogador importado do CSV pela anotação @CsvBindByName passando o campo pelo como parâmetro
    @CsvBindByName(column = "id")
    private long id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "full_name")
    private String fullName;

    @CsvBindByName(column = "birth_date")
    private String birthDate;

    @CsvBindByName(column = "age")
    private int age;

    @CsvBindByName(column = "height_cm")
    private double heightCm;

    @CsvBindByName(column = "weight_kgs")
    private double weightKgs;

    @CsvBindByName(column = "positions")
    private String positions;

    @CsvBindByName(column = "nationality")
    private String nationality;

    @CsvBindByName(column = "overall_rating")
    private int overallRating;

    @CsvBindByName(column = "potential")
    private int potential;

    @CsvBindByName(column = "value_euro")
    private double valueEuro;

    @CsvBindByName(column = "wage_euro")
    private double wageEuro;

    @CsvBindByName(column = "preferred_foot")
    private String preferredFoot;
    //end

    //Imprime o objeto em "formato JSON"
    public String toString(String[] dadosExibicao) {
        StringBuilder sb = new StringBuilder("jogador{");

        for(var jogador : getJogadorMapeado(dadosExibicao).entrySet()){
            sb.append("\n  ").append(jogador.getKey()).append(" : ")
                    .append(jogador.getValue().toString()).append(",");
        }

        sb.append("\n}");

        return sb.toString();
    }
    //end

    //Retorna um Map de todos os atributos do objeto com seus valores
    public TreeMap<String , Object> getJogadorMapeado(String[] dadosExibicao){
        TreeMap<String, Object> jogador = new TreeMap<>();
        jogador.put("id", id);

        for (String dado : dadosExibicao) {
            switch (dado) {
                case "name" -> jogador.put("name", name);
                case "fullName" -> jogador.put("fullName", fullName);
                case "birthDate" -> jogador.put("birthDate", birthDate);
                case "age" -> jogador.put("age", age);
                case "heightCm" -> jogador.put("heightCm", heightCm);
                case "weightKgs" -> jogador.put("weightKgs", weightKgs);
                case "positions" -> jogador.put("positions", positions);
                case "nationality" -> jogador.put("nationality", nationality);
                case "overallRating" -> jogador.put("overallRating", overallRating);
                case "potential" -> jogador.put("potential", potential);
                case "valueEuro" -> jogador.put("valueEuro", valueEuro);
                case "wageEuro" -> jogador.put("wageEuro", wageEuro);
                case "preferredFoot" -> jogador.put("preferredFoot", preferredFoot);
                
                default -> System.out.println("Dado de exibição inválido: " + dado);
            }
        }

        return jogador;
    }
    //end

    //Método de ordenação implementado da interface Comparable
    @Override
    public int compareTo(Jogador outroJogador) {
        return Long.compare(this.getId() , outroJogador.getId());
    }
    //end
}
