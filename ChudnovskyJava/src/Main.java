import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    private static final int DECIMALES = 100;
    private static final int RONDAS = 1000;

    public static void main(String[] args) {

        BigDecimal sumatorio = BigDecimal.ZERO;

        for (int k = 0; k < RONDAS; k++) {
            sumatorio = sumatorio.add(termino(k));
        }

        BigDecimal inverso = BigDecimal.valueOf(12).multiply(sumatorio);

        BigDecimal pi = BigDecimal.ONE.divide(inverso, DECIMALES, RoundingMode.DOWN);

        System.out.println(pi);
    }

    public static BigDecimal termino(int k) {

        BigDecimal bK = BigDecimal.valueOf(k);

        BigDecimal menosUnoK = BigDecimal.valueOf(-1).pow(k);
        BigDecimal seisKFactorial = factorial(BigDecimal.valueOf(6).multiply(bK));
        BigDecimal cincoCuatroCinco = BigDecimal.valueOf(545140134).multiply(bK).add(BigDecimal.valueOf(13591409));

        BigDecimal arriba = menosUnoK.multiply(seisKFactorial).multiply(cincoCuatroCinco);

        BigDecimal tresKFactorial = factorial(BigDecimal.valueOf(3).multiply(bK));
        BigDecimal kFactorialCubo = factorial(bK).pow(3);

        BigDecimal seisCuatroCeroA = BigDecimal.valueOf(640320).pow(3 * k);
        BigDecimal seisCuatroCeroB = BigDecimal.valueOf(Math.pow(640320, 3.0 / 2));
        BigDecimal seisCuatroCero = seisCuatroCeroA.multiply(seisCuatroCeroB);

        BigDecimal abajo = tresKFactorial.multiply(kFactorialCubo).multiply(seisCuatroCero);

        return arriba.divide(abajo, DECIMALES, RoundingMode.DOWN);
    }

    public static BigDecimal factorial(BigDecimal n) {

        BigDecimal factorial = BigDecimal.ONE;

        for (BigDecimal i = BigDecimal.ONE; i.compareTo(n) < 0; i = i.add(BigDecimal.ONE)) {
            factorial = factorial.multiply(i);
        }

        return factorial;
    }
}
