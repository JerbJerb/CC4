import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stacks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of the Stack: ");
        int size = Integer.parseInt(br.readLine());

        int[] stack = new int[size];

        for (int i = 0; true; i++) {
            System.out.println("Options:\n"
                    + "[1]PUSH\n"
                    + "[2]POP\n"
                    + "[3]EXIT");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    if (i != size) {
                        System.out.print("Push a number: ");
                        stack[i] = Integer.parseInt(br.readLine());
                    } else {
                        System.out.println("Sorry, the stack is full!");
                        i--;
                    }
                    System.out.print("STACK: [");
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print(stack[j]);
                        if (j != i) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    System.out.println("TOP: " + i);
                    break;
                case 2:
                    if (i == 0) {
                        System.out.println("Sorry, the stack is empty!");
                        i++;
                    }
                    i -= 2;
                    System.out.print("STACK: [");
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print(stack[j]);
                        if (j != i) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    System.out.println("TOP: " + i);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("error");
                    i--;
                    break;
            }
        }
    }
}