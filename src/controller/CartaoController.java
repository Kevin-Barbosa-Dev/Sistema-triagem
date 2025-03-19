package controller;

import java.util.List;

import model.Cartao;
import model.ListaEncadeadaSimples;
import utils.Mensagem;
import view.CartaoView;

public class CartaoController {
    private CartaoView view;
    private Cartao paciente;
    private ListaEncadeadaSimples lista;

    public CartaoController() {
        this.view = new CartaoView();
        this.lista = new ListaEncadeadaSimples();
    }

    public void cadastrarPaciente(Cartao paciente) {
        paciente = view.formCadastro();
        lista.adicionarCartao(paciente);
    }

    public void mostrarListaPorTipoDeUrgência() {
        if (lista.getTamanho() == 0) {
            Mensagem.mensagemNenhumPacienteCadastrado();
            return;
        }

        List<Cartao> listaOrdenadaPorUrgencia = lista.listarPorUrgencia();
        view.listarPorUrgencia(listaOrdenadaPorUrgencia);
    }

    public void mostrarSituacaoDaLista() {
        if (lista.getTamanho() == 0) {
            Mensagem.mensagemNenhumPacienteCadastrado();
            return;
        }
        view.imprimirSituacaoDaLista(lista.getCapacidade(), lista.getTamanho());
    }

    public void start() {
        int opcao = view.showMenu();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarPaciente(paciente);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    mostrarListaPorTipoDeUrgência();
                    break;
                case 6:
                    mostrarSituacaoDaLista();
                    break;
                default:
                    Mensagem.mensagemInvalida();
            }
            opcao = view.showMenu();
        }
    }
}