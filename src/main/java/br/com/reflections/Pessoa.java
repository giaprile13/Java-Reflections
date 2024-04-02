package br.com.reflections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer id;
    private String nome;
    private String cpf;
    public Pessoa(String nome) {

        this.nome = nome;
    }

}
