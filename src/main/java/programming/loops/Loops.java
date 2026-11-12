package programming.loops;

/**
 * Laboratorio de estructuras de repetición. Completa el cuerpo de cada método con while,
 * do-while, for, for-each, break o continue, y devuelve el resultado con return.
 *
 * Cada método tiene pruebas en src/test/java. Ejecútalas con "mvn test" o desde el IDE.
 * Mientras un método no esté completo, sus pruebas fallan: es lo esperado.
 */

public class Loops {

    // Constantes para usar en los métodos, en lugar de escribir los números sueltos.

    /** Base para separar los dígitos con % y /. */
    private static final int DECIMAL_BASE = 10;
    /** Base del sistema binario. */
    private static final int BINARY_BASE = 2;
    /** El menor primo; también el primer divisor que se prueba. */
    private static final int SMALLEST_PRIME = 2;
    /** Último multiplicador de la tabla de multiplicar. */
    private static final int TABLE_LIMIT = 10;

    // ---------------------------------------------------------------- Parte A ★

    /** A1. Suma 1 + 2 + … + limit. Si limit es 0 o negativo, devuelve 0. */
    public static int sumTo(int limit) {
        if (limit <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i;
        }
        return sum;
    }

    /** A2. number! = 1 × 2 × … × number, para number de 0 a 20. 0! es 1. */
    public static long factorial(int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    /** A3. Cantidad de dígitos de number. El 0 tiene un dígito; el signo no cuenta (-450 tiene 3). */
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            temp /= DECIMAL_BASE;
            count++;
        }
        return count;
    }

    /**
     * A4. Cuenta regresiva desde start hasta 1 seguida de "¡Despegue!", separada por espacios.
     * Ejemplo: 3 → "3 2 1 ¡Despegue!". Con 0 → "¡Despegue!".
     */
    public static String countdown(int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("¡Despegue!");
        return sb.toString();
    }

    // ---------------------------------------------------------------- Parte B ★★

    /** B1. Suma de los dígitos de number (sin el signo). Ejemplo: 4721 → 14. */
    public static int digitSum(int number) {
        int sum = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            sum += temp % DECIMAL_BASE;
            temp /= DECIMAL_BASE;
        }
        return sum;
    }

    /** B2. El número con sus dígitos al revés, para number no negativo. Ejemplos: 1234 → 4321; 120 → 21. */
    public static int reverse(int number) {
        int rev = 0;
        int temp = number;
        while (temp > 0) {
            rev = rev * DECIMAL_BASE + (temp % DECIMAL_BASE);
            temp /= DECIMAL_BASE;
        }
        return rev;
    }

    /** B3. true si number es primo: mayor que 1 y sin divisores entre 2 y number - 1. */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = SMALLEST_PRIME; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** B4. Máximo común divisor de dos enteros positivos (algoritmo de Euclides). */
    public static int gcd(int first, int second) {
        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }

    /**
     * B5. Tabla de multiplicar de number del 1 al TABLE_LIMIT (10), una línea por resultado terminada
     * en "\n". Ejemplo de la primera línea con number = 7: "7 x 1 = 7".
     */
    public static String multiplicationTable(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= TABLE_LIMIT; i++) {
            sb.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
        }
        return sb.toString();
    }

    // ---------------------------------------------------------------- Parte C ★★★

    /** C1. true si number es perfecto: igual a la suma de sus divisores menores que él (6 = 1 + 2 + 3). */
    public static boolean isPerfect(int number) {
        if (number <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    /** C2. Representación binaria de number (no negativo) como texto. Ejemplos: 13 → "1101"; 0 → "0". */
    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int temp = number;
        while (temp > 0) {
            sb.insert(0, temp % BINARY_BASE);
            temp /= BINARY_BASE;
        }
        return sb.toString();
    }

    /**
     * C3. Pasos de la conjetura de Collatz hasta llegar a 1, para number positivo: si es par se divide
     * entre 2; si es impar, se reemplaza por 3n + 1. Ejemplo: 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1: 8 pasos.
     */
    public static int collatzSteps(int number) {
        int steps = 0;
        int current = number;
        while (current > 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = 3 * current + 1;
            }
            steps++;
        }
        return steps;
    }

    /** C4. Triángulo de asteriscos de rows filas; cada fila termina en "\n". Ejemplo: 3 → "*\n**\n***\n". */
    public static String triangle(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}