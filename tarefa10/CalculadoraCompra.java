import java.util.Scanner;

public class CalculadoraCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a porcentagem do IPI a ser acrescido: ");
        double ipi = scanner.nextDouble();

        System.out.println("Informe os dados da peça 1:");
        System.out.print("Código da peça: ");
        int codigoPeca1 = scanner.nextInt();
        System.out.print("Valor unitário da peça: ");
        double valorUnitario1 = scanner.nextDouble();
        System.out.print("Quantidade de peças: ");
        int quantidade1 = scanner.nextInt();

        System.out.println("Informe os dados da peça 2:");
        System.out.print("Código da peça: ");
        int codigoPeca2 = scanner.nextInt();
        System.out.print("Valor unitário da peça: ");
        double valorUnitario2 = scanner.nextDouble();
        System.out.print("Quantidade de peças: ");
        int quantidade2 = scanner.nextInt();

        double totalPeca1 = valorUnitario1 * quantidade1;
        double totalPeca2 = valorUnitario2 * quantidade2;

        double valorTotal = (totalPeca1 + totalPeca2) * (ipi / 100 + 1);

        System.out.println("Valor total a ser pago: " + valorTotal);
    }
}
