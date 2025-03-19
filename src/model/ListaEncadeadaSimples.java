package model;

import java.util.ArrayList;
import java.util.List;

import utils.Mensagem;
import utils.Validacao;

public class ListaEncadeadaSimples {
    private Cartao head;
    private int tamanho = 0;
    private Cartao ultimo;
    private final int capacidade = 10;

    public void adicionarCartao(Cartao novoCartao) {
        if (tamanho >= capacidade) {
            Mensagem.mensagemListaCheia();
            return;
        }
        if (!Validacao.validarNome(novoCartao.getNome())) {
            Mensagem.mensagemNomeInvalido();
            return;

        }
        if (!Validacao.validarCor(novoCartao.getCor())) {
            Mensagem.mensagemCorInvalida();
            return;
        }
        if (tamanho == 0) {
            head = novoCartao;
        } else {
            ultimo.setProximo(novoCartao);
        }
        ultimo = novoCartao;
        tamanho++;
    }

    public List<Cartao> listarPorUrgencia() {
        List<Cartao> listaOrdenadaPorUrgencia = new ArrayList<>();
        Cartao atual = head;

        while (atual != null) {
            if (atual.getCor() == 'A') {
                listaOrdenadaPorUrgencia.add(atual);
            }
            atual = atual.getProximo();
        }

        atual = head;
        while (atual != null) {
            if (atual.getCor() == 'V') {
                listaOrdenadaPorUrgencia.add(atual);
            }
            atual = atual.getProximo();
        }

        return listaOrdenadaPorUrgencia;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Cartao getHead() {
        return head;
    }

    public Cartao getUltimo() {
        return ultimo;
    }

    public int getCapacidade() {
        return capacidade;
    }

}