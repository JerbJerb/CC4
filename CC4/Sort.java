import java.util.Scanner;

public class Sorttt {

    public static void main(String[] args) {
    Scanner scan1=new Scanner(System.in);
    System.out.print("How many numbers you want to sort: ");
    int a=scan1.nextInt();

    int i,j,k=0; // i and j is used in various loops.
    int num[]=new int[a];
    int great[]= new int[a];    //This array elements will be used to store "the number of being greater."  

    Scanner scan2=new Scanner(System.in);
    System.out.println("Enter the numbers: ");

    for(i=0;i<a;i++)    
        num[i] = scan2.nextInt();

    for (i=0;i<a;i++) {
        for(j=0;j<a;j++) {
            if(num[i]>num[j])   //first time when executes this line, i=0 and j=0 and then i=0;j=1 and so on. each time it finishes second for loop the value of num[i] changes.
            k++;} 
        great[i]=k++;  //At the end of each for loop (second one) k++ contains the total of how many times a number is greater than the others.
        k=0;}  // And then, again k is forced to 0, so that it can collect (the total of how many times a number is greater) for another number.

        System.out.print("Ascending Order: ");
        for(i=0;i<a;i++)
        for(j=0;j<a;j++)
            if(great[j]==i) System.out.print(num[j]+","); //there is a fixed value for each great[j] that is, from 0 upto number of elements(input numbers).
        System.out.print("Descending Order: ");
        for(i=0;i<=a;i++)
        for(j=0;j<a;j++)
            if(great[j]==a-i) System.out.print(+num[j]+",");    
    }
    
}