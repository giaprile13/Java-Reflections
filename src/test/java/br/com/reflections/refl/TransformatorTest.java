package br.com.reflections.refl;

import br.com.reflections.Endereco;
import br.com.reflections.Pessoa;
import br.com.reflections.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "João", "123456789");

    Endereco endereco = new Endereco("Rua Abril", 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Transformator transformator = new Transformator();

        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    public void shouldNotTransform() {

        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        Pessoa pessoaSemCpf = new Pessoa("João");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTOSemCpf);
        Assertions.assertEquals(pessoaSemCpf.getNome(), pessoaDTOSemCpf.getNome());
        Assertions.assertNull(pessoaDTOSemCpf.getCpf());
    }

}