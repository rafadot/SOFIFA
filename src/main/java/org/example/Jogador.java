package org.example;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

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
    public String toString() {
        StringBuilder sb = new StringBuilder("jogador{\n");

        sb.append("  \"id\":").append(id).append(",\n");
        sb.append("  \"name\":\"").append(name).append("\",\n");
        sb.append("  \"fullName\":\"").append(fullName).append("\",\n");
        sb.append("  \"birthDate\":\"").append(birthDate).append("\",\n");
        sb.append("  \"age\":").append(age).append(",\n");
        sb.append("  \"heightCm\":").append(heightCm).append(",\n");
        sb.append("  \"weightKgs\":").append(weightKgs).append(",\n");
        sb.append("  \"positions\":\"").append(positions).append("\",\n");
        sb.append("  \"nationality\":\"").append(nationality).append("\",\n");
        sb.append("  \"overallRating\":").append(overallRating).append(",\n");
        sb.append("  \"potential\":").append(potential).append(",\n");
        sb.append("  \"valueEuro\":").append(valueEuro).append(",\n");
        sb.append("  \"wageEuro\":").append(wageEuro).append(",\n");
        sb.append("  \"preferredFoot\":\"").append(preferredFoot).append("\"\n");

        sb.append("}");

        return sb.toString();
    }
    //end

    //Retorna um Map de todos os atributos do objeto com seus valores
    public Map<String , Object> getJogadorMapeado(){
        Map<String, Object> jogador = new HashMap<>();

        jogador.put("id", id);
        jogador.put("name", name);
        jogador.put("fullName", fullName);
        jogador.put("birthDate", birthDate);
        jogador.put("age", age);
        jogador.put("heightCm", heightCm);
        jogador.put("weightKgs", weightKgs);
        jogador.put("positions", positions);
        jogador.put("nationality", nationality);
        jogador.put("overallRating", overallRating);
        jogador.put("potential", potential);
        jogador.put("valueEuro", valueEuro);
        jogador.put("wageEuro", wageEuro);
        jogador.put("preferredFoot", preferredFoot);

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
