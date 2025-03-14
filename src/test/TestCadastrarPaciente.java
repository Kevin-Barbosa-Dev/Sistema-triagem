package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Cartao;
import model.ListaEncadeadaSimples;

public class TestCadastrarPaciente {
    private Cartao paciente;
    private ListaEncadeadaSimples lista;

    @Before
    public void setUp() {
        lista = new ListaEncadeadaSimples();
        paciente = new Cartao("João", 'v');
    }

    @Test
    public void testCadastrarPaciente() {
        lista.adicionarCartao(paciente);
        assertEquals(1, lista.getTamanho());
        assertEquals(paciente, lista.getHead());
        assertEquals(paciente, lista.getUltimo());
    }
}
