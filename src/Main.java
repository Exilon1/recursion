import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
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

        System.out.println("secondMaxValue = " + secondMaxValue(List.of(7,4,3,2,5)));
        System.out.println("secondMaxValue = " + secondMaxValue(List.of(7,4,3,7,5)));
        System.out.println("secondMaxValue = " + secondMaxValue(List.of(7,5)));
        System.out.println("secondMaxValue = " + secondMaxValue(List.of(5,7)));

        System.out.println("generateSequence: ");
        System.out.println("generateSequence: ");
        generateSequence(2, 0, 0, "");
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

        Integer val = numberList.get(index);
        if (val % 2 == 0) {
            System.out.println("even number = " + val);
        }

        printEvenNumbersOnly(numberList, index + 1);
    }

    public static void printValuesWithEvenIndexes(List<Integer> numberList) {
        printValuesWithEvenIndexes(numberList, 0);
    }

    private static void printValuesWithEvenIndexes(List<Integer> numberList, int index) {
        if (numberList.size() < 3 && (numberList.size() <= index || index < 0)) {
            return;
        }

        System.out.println("number with even index = " + numberList.get(index));

        printValuesWithEvenIndexes(numberList, index + 2);
    }

    public static Integer secondMaxValue(List<Integer> numberList) {
        return secondMaxValue(numberList, Integer.MIN_VALUE, Integer.MIN_VALUE,  0);
    }

    private static int secondMaxValue(List<Integer> numberList,
                                          int maxValue, int secondMaxValue, int index) {
        if (numberList.size() < 2) {
            return Integer.MIN_VALUE;
        }

        if (index >= numberList.size()) {
            return secondMaxValue;
        }

        Integer val = numberList.get(index);
        if (val == maxValue || val > secondMaxValue) {
            secondMaxValue = val;
        }
        if (val > maxValue) {
            secondMaxValue = maxValue;
            maxValue = val;
        }

        return secondMaxValue(numberList, maxValue, secondMaxValue, index + 1);
    }

    public static List<File> findFiles(String dirPath) {
      return findFiles(new File(dirPath));
    }

    private static List<File> findFiles(File currentFile) {
        List<File> files = new ArrayList<>();

        if (currentFile.isFile()) {
            files.add(currentFile);
        }

        if (currentFile.isDirectory()) {
            for (File file : Objects.requireNonNull(currentFile.listFiles())) {
                files.addAll(findFiles(file));
            }
        }

        return files;
    }

    public static void generateSequence(int n, int counterOpen, int counterClose, String sequence) {
        if (counterOpen + counterClose == 2 * n) {
            System.out.println(sequence);
            return;
        }

        if (counterOpen < n) {
            generateSequence(n, counterOpen + 1, counterClose, sequence + "(");
        }

        if (counterOpen > counterClose) {
            generateSequence(n, counterOpen, counterClose + 1, sequence + ")");
        }
    }
}