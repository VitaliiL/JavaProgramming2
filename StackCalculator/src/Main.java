import java.util.Scanner;
import java.util.Stack;

//  2 + 3 * 5 - 7

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input expression:");
        String scannerString = scanner.nextLine();

        System.out.println(PolishNotation.ExpressionToPolishNotation(scannerString));
    }
}
