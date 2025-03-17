package model;

import utils.Mensagem;
import utils.Validacao;

public class ListaEncadeadaSimples {
    private Cartao head;
    private int tamanho = 0;
    private Cartao ultimo;
    private static final int capacidade = 10;

    // se o tamanho for 0 o inicio(head) e fim(ultimo) permanecem na mesma celula,
    // se o tamanho for maior que 0, o ultimo aponta para a novo celula e o ultimo
    // recebe a nova celula e tamanho é incrementado
    // Exemplo:
    // tamanho é 0
    // |inicio|
    // |fim|
    // tamanho é 1
    // |inicio| -> |novo|
    // |fim|
    // |inicio| -> |novo|
    // |fim|

    public void adicionarCartao(Cartao novoCartao) {
        if (tamanho >= capacidade) {
            Mensagem.mensagemListaCheia();
            return;
        }
        if (!Validacao.validarNome(novoCartao.getNome())) {
            Mensagem.mensagemNomeInvalido();
            return;

        }
        if (Validacao.validarCor(novoCartao.getCor())) {
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

    public int getTamanho() {
        return tamanho;
    }

    public Cartao getHead() {
        return head;
    }

    public Cartao getUltimo() {
        return ultimo;
    }

}