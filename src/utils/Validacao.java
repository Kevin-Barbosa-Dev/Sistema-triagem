package utils;

public class Validacao {

    public static boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public static boolean validarCor(char cor) {
        return cor != 'a' &&
                cor != 'v' &&
                cor != 'A' &&
                cor != 'V';
    }
}
