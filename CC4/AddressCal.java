import java.util.Scanner;

/**
 *
 * @author m304user
 */
public class AddressCal{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int n = 0, sum = 0;
        float average;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter length of array");
        int i = s.nextInt();
        int[] a = new int[i];
        for (int x = 0; x < a.length; x++) {

            System.out.println("Enter Value");
            a[x] = s.nextInt();
        }
        System.out.println("Enter Base Address");
        int base = s.nextInt();
        System.out.println("enter Elements");
        int elements = s.nextInt();
        System.out.println("Input Esize");
        int esize = s.nextInt();

        {

            sum = sum + a[i];
            System.out.println("sum =" + sum);
        }

        int address = base + (elements) * esize;
        System.out.println("base address of" + address);

        average = (float) sum / n;

    }

}
