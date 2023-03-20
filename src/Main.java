import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("exponent = " + exponentiation(2, 3));
        System.out.println("sumOfDigits = " + sumOfDigits(123));

        System.out.println("Sator arepo tenet opera rotas >> "
                + validPalindrome("sator arepo tenet opera rotas"));
        System.out.println("Sator arepo >> "
                + validPalindrome("Sator arepo"));
        System.out.println("Ss >> "
                + validPalindrome("Ss"));
        System.out.println(" a >> "
                + validPalindrome(" a"));
        System.out.println("S >> "
                + validPalindrome("S"));

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

    public static boolean validPalindrome(String s) {
        String string = s.toLowerCase();

        if (s.isBlank()) {
            return true;
        }

        LinkedList<Character> deque = string.chars().mapToObj(
                c -> (char) c).collect(Collectors.toCollection(LinkedList::new)
        );

        Character left;
        try {
            left = deque.removeFirst();
        } catch (NoSuchElementException e) {
            return false;
        }

        Character right;
        try {
            right = deque.removeLast();
        } catch (NoSuchElementException e) {
            return true;
        }

        return left.equals(right) && validPalindrome(s.substring(1, s.length()-1));
    }
}