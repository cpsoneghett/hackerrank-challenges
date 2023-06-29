import java.util.Arrays;

public class CalculadoraEstatistica {

    public static double calcularMedia(double[] numeros) {
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return (soma / numeros.length);
    }

    public static double calcularMediana(double[] numeros) {
        Arrays.sort(numeros);

        if (numeros.length % 2 == 0) {
            int meio = numeros.length / 2;
            return (numeros[meio - 1] + numeros[meio]) / 2;
        } else {
            int meio = numeros.length / 2;
            return numeros[meio];
        }
    }

    public static double calculateModa(double[] numeros) {
        int maxCount = 0;
        double moda = 0;
        for (int i = 0; i < numeros.length; i++) {
            int contador = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] == numeros[i]) {
                    contador++;
                }
            }
            if (contador > maxCount) {
                maxCount = contador;
                moda = numeros[i];
            }
        }
        return moda;
    }

    public static void main(String[] args) {
        double[] numeros = {2.5, 3.7, 4.1, 5.2, 6.8};

        System.out.println("Média: " + calcularMedia(numeros));
        System.out.println("Mediana: " + calcularMediana(numeros));
        System.out.println("Moda: " + calculateModa(numeros));
    }
}