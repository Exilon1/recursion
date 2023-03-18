public class Main {
    public static void main(String[] args) {
        System.out.println("exponent = " + exponentiation(2, 3));
        System.out.println("sumOfDigits = " + sumOfDigits(123));
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

    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        }

        return number % 10 + sumOfDigits(number/10);
    }
}