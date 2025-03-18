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
    public void exibirLista(){
        Cartao atual = head;
        while(atual != null){
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }
    public Cartao localizarPaciente(String nome){
        Cartao atual = head;
        int posicaoAlta = 0;
        int posicaoBaixa = 0;

        while (atual != null) {
            String nomePaciente = atual.getNome();
            char cor = atual.getCor();

            // Determina qual contador incrementar
            int posicaoAtual;
            switch (cor) {
                case 'A':
                    posicaoAtual = ++posicaoAlta;
                    break;
                case 'V':
                    posicaoAtual = ++posicaoBaixa;
                    break;
                default:
                    posicaoAtual = -1;
            }

            if (nomePaciente.equalsIgnoreCase(nome)) {
                System.out.println("Paciente encontrado: " + nomePaciente + " | Urgência: " + cor);
                System.out.println("Posição na fila de sua urgência: " + posicaoAtual);
                return atual;
            }

            atual = atual.getProximo();
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }

    public boolean remover(String nome){
        Cartao atual = head;
        Cartao anterior = null;

        if (head != null && nome.equalsIgnoreCase(head.getNome())){
            head = atual.getProximo();
            System.out.println("Paciente removido: "+ nome);
            return true;//foi apagado
        }
        while(atual != null && !nome.equalsIgnoreCase(atual.getNome())){
            anterior = atual;
            atual = atual.getProximo();
        }

        if(atual == null){
            System.out.println("Paciente não encontrado!");
            return false;
        }
        anterior.setProximo(atual.getProximo());
        System.out.println("Paciente removido: "+ nome);
        return true;
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