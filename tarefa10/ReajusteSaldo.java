import java.util.Scanner;

public class ReajusteSaldo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor do saldo: ");
        double saldo = scanner.nextDouble();
        
        double reajuste = saldo * 0.15;
        double saldoReajustado = saldo + reajuste;
        
        System.out.println("Saldo com reajuste: " + saldoReajustado);
    }
}
