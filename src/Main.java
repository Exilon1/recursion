import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

        if (string.isBlank()) {
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

    public static void printEvenNumbersOnly(List<Integer> numberList) {
        printEvenNumbersOnly(numberList, 0);
    }

    private static void printEvenNumbersOnly(List<Integer> numberList, int index) {
        if (numberList.size() <= index || index < 0) {
            return;
        }

        Integer val = numberList.get(0);
        if (val % 2 == 0) {
            System.out.println("even number = " + val);
        }

        printEvenNumbersOnly(numberList, index + 1);
    }

    public static void printValuesWithEvenIndexes(List<Integer> numberList) {
        printValuesWithEvenIndexes(numberList, 2);
    }

    private static void printValuesWithEvenIndexes(List<Integer> numberList, int index) {
        if (numberList.size() >= 2 && (numberList.size() <= index || index < 0)) {
            return;
        }

        System.out.println("number with even index = " + numberList.get(index));

        printValuesWithEvenIndexes(numberList, index + 2);
    }
}