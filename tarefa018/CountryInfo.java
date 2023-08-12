import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CountryInfo {
    public static void main(String[] args) {
        Locale[] locales = {
            Locale.US,
            Locale.UK,
            Locale.GERMANY,
            Locale.FRANCE,
            Locale.ITALY,
            Locale.JAPAN,
            new Locale("es", "ES"),
            new Locale("pt", "BR"),
            new Locale("ru", "RU"),
            new Locale("zh", "CN")
        };

        for (Locale locale : locales) {
            System.out.println("Nome do País: " + locale.getDisplayCountry(locale));
            System.out.println("Linguagem: " + locale.getDisplayLanguage(locale));

            DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
            DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
            DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);

            System.out.println("Data no formato curto: " + shortDateFormat.format(new java.util.Date()));
            System.out.println("Data no formato longo: " + longDateFormat.format(new java.util.Date()));
            System.out.println("Formato de hora: " + timeFormat.format(new java.util.Date()));

            Currency currency = Currency.getInstance(locale);
            System.out.println("Símbolo da moeda local: " + currency.getSymbol(locale));

            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);

            System.out.println("Separador de decimal: " + decimalFormatSymbols.getDecimalSeparator());
            System.out.println("Separador de milhar: " + decimalFormatSymbols.getGroupingSeparator());

            System.out.println("Código de página windows: " + locale.toString());
            System.out.println("----------------------------------------");
        }
    }
}
