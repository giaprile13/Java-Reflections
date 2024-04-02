package br.com.reflections;

import br.com.reflections.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Pessoa pessoa = new Pessoa();

        return new Transformator().transform(pessoa);
    }

}
