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

    }

    @Test
    public void testCadastrarPacienteComSucesso() {
        paciente = new Cartao("João", 'v');
        lista.adicionarCartao(paciente);
        assertEquals(1, lista.getTamanho());
        assertEquals(paciente, lista.getHead());
        assertEquals(paciente, lista.getUltimo());
    }

    @Test
    public void testCadastrarPacienteComCorInvalida() {
        paciente = new Cartao("João", 'x');
        lista.adicionarCartao(paciente);
        assertEquals(0, lista.getTamanho());
    }

    @Test
    public void testCadastrarPacienteComNomeInvalido() {
        paciente = new Cartao(" ", 'v');
        lista.adicionarCartao(paciente);
        assertEquals(0, lista.getTamanho());
    }
}
