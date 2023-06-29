import java.math.BigDecimal;

public class Calculator {

    static String sum(String... numbers) {
        BigDecimal total = BigDecimal.ZERO;

        for (String number : numbers) {
            total = total.add(new BigDecimal(number));
        }

        return total.toString();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum("99.35", "1.10"));
    }
}
