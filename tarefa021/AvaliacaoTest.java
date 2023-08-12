import org.junit.Assert;
import org.junit.Test;

public class AvaliacaoTest {

    @Test
    public void testAvalia() {
        Avaliacao avaliacao = new Avaliacao();

        // Casos de teste com nota1 inválida (fora do intervalo [0, 10])
        try {
            avaliacao.avalia(-2.00, 8.00, 128, 12);
            Assert.fail("Teste com nota1 inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        Assert.assertEquals("Aprovado.", avaliacao.avalia(0.00, 8.00, 128, 12));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(2.99, 8.00, 128, 12));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(3.00, 8.00, 128, 12));
        Assert.assertEquals("Recuperação.", avaliacao.avalia(4.00, 8.00, 128, 12));
        Assert.assertEquals("Recuperação.", avaliacao.avalia(5.99, 8.00, 128, 12));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(6.00, 8.00, 128, 12));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(10.00, 8.00, 128, 12));

        // Teste com nota1 inválida (fora do intervalo [0, 10])
        try {
            avaliacao.avalia(12.00, 8.00, 128, 12);
            Assert.fail("Teste com nota1 inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        // Teste com nota2 inválida (fora do intervalo [0, 10])
        try {
            avaliacao.avalia(5.00, -2.00, 128, 12);
            Assert.fail("Teste com nota2 inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        Assert.assertEquals("Aprovado.", avaliacao.avalia(5.00, 0.00, 128, 12));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(5.00, 10.00, 128, 12));

        // Teste com nota2 inválida (fora do intervalo [0, 10])
        try {
            avaliacao.avalia(5.00, 12.00, 128, 12);
            Assert.fail("Teste com nota2 inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        // Teste com cargaHoraria inválida (valor negativo)
        try {
            avaliacao.avalia(5.00, 8.00, -1, 12);
            Assert.fail("Teste com cargaHoraria inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        // Teste com cargaHoraria inválida (valor igual a 0)
        try {
            avaliacao.avalia(5.00, 8.00, 0, 12);
            Assert.fail("Teste com cargaHoraria inválida não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        // Teste com faltas inválidas (valor negativo)
        try {
            avaliacao.avalia(5.00, 8.00, 128, -1);
            Assert.fail("Teste com faltas inválidas não lançou exceção");
        } catch (ValoresInvalidosException e) {
            Assert.assertEquals("Valores Inválidos.", e.getMessage());
        }

        Assert.assertEquals("Aprovado.", avaliacao.avalia(5.00, 8.00, 128, 0));
        Assert.assertEquals("Aprovado.", avaliacao.avalia(5.00, 8.00, 128, 10));

        // Casos de teste com reprovação por falta
        Assert.assertEquals("Reprovado por Falta.", avaliacao.avalia(5.00, 8.00, 100, 400));
        Assert.assertEquals("Reprovado por Falta.", avaliacao.avalia(5.00, 8.00, 101, 400));
        Assert.assertEquals("Reprovado por Falta.", avaliacao.avalia(5.00, 8.00, 200, 800));
        Assert.assertEquals("Reprovado por Falta.", avaliacao.avalia(5.00, 8.00, 201, 800));

        // Casos de teste com reprovação por média
        Assert.assertEquals("Reprovado por Média.", avaliacao.avalia(2.00, 3.00, 10, 40));
        Assert.assertEquals("Reprovado por Média.", avaliacao.avalia(0.00, 4.00, 15, 60));
        Assert.assertEquals("Reprovado por Média.", avaliacao.avalia(1.50, 3.00, 5, 20));

        // Casos de teste em recuperação
        Assert.assertEquals("Recuperação.", avaliacao.avalia(3.00, 4.00, 5, 20));
        Assert.assertEquals("Recuperação.", avaliacao.avalia(3.50, 5.00, 5, 20));
        Assert.assertEquals("Recuperação.", avaliacao.avalia(4.00, 4.00, 10, 40));
    }
}
