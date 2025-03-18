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

    public void cadastrarPaciente() {
        paciente = view.formCadastro();
        lista.adicionarCartao(paciente);
    }

    public void pesquisarPaciente(){
        String nome = view.pesquisar();
        lista.localizarPaciente(nome);
    }
    public void removerPaciente(){
        String nome = view.pesquisar();
        lista.remover(nome);
    }

    public void start() {
        int opcao = view.showMenu();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    removerPaciente();
                    break;
                case 3:
                    pesquisarPaciente();
                    break;
                case 4:
                    lista.exibirLista();
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