package br.com.reflections.refl;

import br.com.reflections.Pessoa;
import com.fasterxml.jackson.core.JsonProcessingException;

class ObjectToJsonTester {


    public static void main(String... x) throws JsonProcessingException {

        Pessoa pessoa = new Pessoa(1, "João", "12232435");

        ObjectToJson objectToJson = new ObjectToJson();

        System.out.println(objectToJson.transform(pessoa));
    }

}