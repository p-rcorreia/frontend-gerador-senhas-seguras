package geradorDeSenhas;
import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorDeSenhas {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;:,.<>?";

    public static String gerarSenha(int comprimento) {
        if (comprimento <= 0) {
            throw new IllegalArgumentException("O comprimento da senha deve ser maior que zero.");
        }

        SecureRandom geradorDeNumeroAleatorio = new SecureRandom();
        StringBuilder senha = new StringBuilder(comprimento);

        for (int i = 0; i < comprimento; i++) {
            int indice = geradorDeNumeroAleatorio.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(indice));
        }

        return senha.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o comprimento da senha desejada: ");
            int comprimentoDesejado = scanner.nextInt();
            String senhaGerada = gerarSenha(comprimentoDesejado);
            System.out.println("Senha Gerada: " + senhaGerada);
        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
