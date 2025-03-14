package view;

import java.util.Scanner;

import model.Cartao;

public class CartaoView {
    Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Remover paciente");
        System.out.println("3 - Pesquisar posição do paciente");
        System.out.println("4 - Visualizar lista completa");
        System.out.println("5 - Visualizar lista por tipo de urgência");
        System.out.println("6 - Consultar situação da lista");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public Cartao formCadastro() {
        System.out.println("Digite o nome do paciente: ");
        String nome = scanner.next();
        System.out.println("Digite a cor do cartão (V, A): ");
        char cor = scanner.next().toLowerCase().charAt(0);
        return new Cartao(nome, cor);
    }
}