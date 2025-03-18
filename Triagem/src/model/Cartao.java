package model;

public class Cartao {
    private String nome;
    private char cor;
    private Cartao proximo;

    public Cartao(String nome, char cor) {
        this.nome = nome;
        this.cor = cor;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public char getCor() {
        return cor;
    }

    public Cartao getProximo() {
        return proximo;
    }

    public void setProximo(Cartao proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return "Paciente: " + nome + " - Cor: " + cor;
    }
}