public class Avaliacao {

    public String avalia(double nota1, double nota2, int faltas, int cargaHoraria) throws ValoresInvalidosException {
        double percentualFaltas = ((double) faltas / cargaHoraria);
        double media = (nota1 + nota2) / 2;

        if ((nota1 < 0.0 || nota1 > 10) || (nota2 < 0.0 || nota2 > 10) || (faltas < 0.0 || faltas > cargaHoraria) || cargaHoraria < 0.0) {
            throw new ValoresInvalidosException();
        } else if (percentualFaltas > 0.25) {
            return "Reprovado por Falta.";
        } else if (media < 3.0) {
            return "Reprovado por Média.";
        } else if (media >= 3.0 && media < 6.0) {
            return "Recuperação.";
        } else {
            return "Aprovado.";
        }
    }
}
