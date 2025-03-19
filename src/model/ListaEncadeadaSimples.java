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


    public void exibirLista() {
        Cartao atual = head;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }

    public Cartao localizarPaciente(String nome) {
        Cartao atual = head;
        int posicaoAlta = 0;
        int posicaoBaixa = 0;

        while (atual != null) {
            String nomePaciente = atual.getNome();
            char cor = atual.getCor();//poter metodo Upper

            // Determina qual contador incrementar
            int posicaoAtual;
            switch (cor) {
                case 'A':
                    posicaoAtual = ++posicaoAlta;
                    break;
                case 'V':
                    posicaoAtual = ++posicaoBaixa;//criar um metodo para somar os amarelos na frente dos verdes.
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

    public boolean remover(String nome) {
        Cartao atual = head;
        Cartao anterior = null;

        if (head != null && nome.equalsIgnoreCase(head.getNome())) {
            head = atual.getProximo();
            System.out.println("Paciente removido: " + nome);
            return true;// foi apagado
        }
        while (atual != null && !nome.equalsIgnoreCase(atual.getNome())) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Paciente não encontrado!");
            return false;
        }
        anterior.setProximo(atual.getProximo());
        System.out.println("Paciente removido: " + nome);
        return true;
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

    public void listaIgualAZero() {
        if (tamanho == 0) {
            Mensagem.mensagemNenhumPacienteCadastrado();
            return;
        }
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