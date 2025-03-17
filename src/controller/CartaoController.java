package controller;

import model.Cartao;
import model.ListaEncadeadaSimples;
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

    // TODO: Ordenar a lista por tipo de urgência
    public void visualizarListaPorTipoDeUrgência() {
        if (lista.getTamanho() == 0) {
            System.out.println("Nenhum paciente cadastrado.");
        }

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
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            opcao = view.showMenu();
        }
    }
}