import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;
    static int sum;
    static char operator;
    static String result;
    public static void main(String[] args) {
        System.out.println("Введите выражение от 1 до 10 , или римскими от I до X");
        calc(result);

    }
    public static String calc(String input) {
        input = sc.nextLine();
        char[] oper = new char[10];
        for (int i = 0; i < input.length(); i++) {
            oper[i] = input.charAt(i);
            if (oper[i] == '+') {
                operator = '+';
            }
            if (oper[i] == '-') {
                operator = '-';
            }
            if (oper[i] == '/') {
                operator = '/';
            }
            if (oper[i] == '*') {
                operator = '*';

            }
        }
        String input_char = String.valueOf(oper);
        String[] divide = input_char.split("[+-/*]");
        String repres = divide[0];
        String repres1 = divide[1];
        String repres2 = repres1.trim();
        num1 = romanToNumber(repres);
        num2 = romanToNumber(repres2);
        if (num1 < 0 && num2 < 0) {
            sum = 0;
        } else {
            result = String.valueOf(calculated(num1, num2, operator));
            String resultRoman = convertNumToRoman(result);
            System.out.println(input = repres + " " + operator + " " + repres2 + " = " + resultRoman);
            return  input ;
        }

        num1 = Integer.parseInt(repres);
        num2 = Integer.parseInt(repres2);

        sum = calculated(num1, num2, operator);
        if (num1 <= 0 || num1 > 10) {
            throw new InputMismatchException("Цифры ввода должны быть то 1 до 10 ");
        } else if (num2 <= 0 || num2 > 10) {
            throw new InputMismatchException("Цифры ввода должны быть то 1 до 10 ");
        } else if (sum < 0) {
            throw new InputMismatchException("Результат не может быть отрицательным");
        } else if (input.length() > 3) {
            throw new InputMismatchException(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (input.length() < 3) {
            throw new InputMismatchException("строка не является математической операцией");
        }
        System.out.println(input = (num1 + " " + operator + " " + num2 + " = " + sum));
        return input;
    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;

            default:
                System.out.println("Не верный знак операции");
        }
        return result;
    }

    private static String convertNumToRoman(String numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[Integer.parseInt(numArabian)];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
}