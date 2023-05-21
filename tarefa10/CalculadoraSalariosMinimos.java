import java.util.Scanner;

public class CalculadoraSalariosMinimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorSalarioMinimo = 1045.0; // Valor atual do salário mínimo

        System.out.print("Digite o valor do salário do usuário: ");
        double salarioUsuario = scanner.nextDouble();

        double quantidadeSalariosMinimos = salarioUsuario / valorSalarioMinimo;

        System.out.println("O usuário ganha " + quantidadeSalariosMinimos + " salário(s) mínimo(s).");
    }
}
