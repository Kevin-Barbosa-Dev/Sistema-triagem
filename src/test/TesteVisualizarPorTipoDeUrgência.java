package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Cartao;
import model.ListaEncadeadaSimples;

public class TesteVisualizarPorTipoDeUrgência {
    private ListaEncadeadaSimples lista;

    @Before
    public void setUp() {
        lista = new ListaEncadeadaSimples();
        lista.adicionarCartao(new Cartao("João", 'V'));
        lista.adicionarCartao(new Cartao("Maria", 'A'));
        lista.adicionarCartao(new Cartao("Pedro", 'V'));
        lista.adicionarCartao(new Cartao("Ana", 'A'));
        lista.adicionarCartao(new Cartao("Cleiton", 'V'));
    }

    @Test
    public void testVisualizarPorTipoDeUrgenciaSucesso() {
        List<Cartao> listaOrdenada = lista.listarPorUrgencia();

        assertEquals("Maria", listaOrdenada.get(0).getNome());
        assertEquals("Cleiton", listaOrdenada.get(4).getNome());
    }

    @Test
    public void testVisualizarPorTipoDeUrgenciaVazia() {
        ListaEncadeadaSimples listaVazia = new ListaEncadeadaSimples();
        List<Cartao> listaOrdenada = listaVazia.listarPorUrgencia();
        assertEquals(0, listaOrdenada.size());
    }

}
