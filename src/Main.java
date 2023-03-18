public class Main {
    public static void main(String[] args) {
        System.out.println("exponent = " + exponentiation(2, 3));
    }

    public static int exponentiation(int number, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Illegal exponent = " + exponent);
        }

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return number;
        }

        return number * exponentiation(number, exponent - 1);
    }
}