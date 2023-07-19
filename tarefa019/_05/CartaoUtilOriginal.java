package org.example._05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartaoUtilRefatorado {
    public static final int VISA = 1;
    public static final int MASTERCARD = 2;
    public static final int AMEX = 3;
    public static final int DINERS = 4;
    public static final String CARTAO_OK = "Cartão válido";
    public static final String CARTAO_ERRO = "Cartão inválido";

    public String validar(int bandeira, String numero, String validade) {
        // ----- VALIDADE -----
        boolean validadeOK = validarValidade(validade);
        if (!validadeOK) {
            return CARTAO_ERRO;
        }

        // ---- PREFIXO E TAMANHO -----
        boolean formatoOK = validarFormato(bandeira, numero);
        if (!formatoOK) {
            return CARTAO_ERRO;
        }

        // ----- NÚMERO -----
        boolean luhnOK = validarLuhn(numero);
        if (!luhnOK) {
            return CARTAO_ERRO;
        }

        return CARTAO_OK;
    }

    private boolean validarValidade(String validade) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
            Date dataValidade = sdf.parse(validade);

            // Obter a data atual e configurar para o primeiro dia do mês corrente
            Calendar calHoje = Calendar.getInstance();
            calHoje.set(Calendar.DAY_OF_MONTH, 1);

            // Verificar se a data de validade é posterior à data atual
            return dataValidade.after(calHoje.getTime());
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validarFormato(int bandeira, String numero) {
        String regex = "";
        int tamanhoEsperado = 0;

        switch (bandeira) {
            case VISA:
                regex = "^4\\d{12}(\\d{3})?$";
                tamanhoEsperado = 13;
                break;
            case MASTERCARD:
                regex = "^5[1-5]\\d{14}$";
                tamanhoEsperado = 16;
                break;
            case AMEX:
                regex = "^3[47]\\d{13}$";
                tamanhoEsperado = 15;
                break;
            case DINERS:
                regex = "^3(?:0[0-5]|[68]\\d)\\d{11}$";
                tamanhoEsperado = 14;
                break;
            default:
                return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches() && numero.length() == tamanhoEsperado;
    }

    private boolean validarLuhn(String numero) {
        int soma = 0;
        boolean multiplica = false;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Integer.parseInt(numero.substring(i, i + 1));
            if (multiplica) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            soma += digito;
            multiplica = !multiplica;
        }

        return soma % 10 == 0;
    }
}
