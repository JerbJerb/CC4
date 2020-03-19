import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queues {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of the Queue: ");
        int size = Integer.parseInt(br.readLine());

        int[] queue = new int[size];

        for (int i = 0; true; i++) {
            System.out.println("Options:\n"
                    + "[1]INSERT\n"
                    + "[2]DELETE\n"
                    + "[3]EXIT");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    if (i != size) {
                        System.out.print("Insert a number: ");
                        queue[i] = Integer.parseInt(br.readLine());
                    } else {
                        System.out.println("Sorry, the queue is full!");
                        i--;
                    }
                    System.out.print("QUEUE: [");
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print(queue[j]);
                        if (j != i) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    System.out.println("REAR: " + i);
                    break;
                case 2:
                    if (i == 0) {
                        System.out.println("Sorry, the queue is empty!");
                        i++;
                    }
                    i--;
                    System.out.print("QUEUE: [");
                    for (int j = size - i; j < size; j++) {
                        System.out.print(queue[j]);
                        if (j != size - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    i--;
                    System.out.println("REAR: " + i);
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