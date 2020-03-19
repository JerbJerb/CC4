import java.util.Scanner;

public class BubbleSort{
    
  public static void main(String[] args) {
    // TODO code application logic here


    //scanner for user input
    Scanner input = new Scanner(System.in);

    //intro
    System.out.println("Welcome to the partly sorted pogram");
    System.out.println("This will make a partly sorted list of integers");

    //the numbers
   int[] nums = new int[100];

   //how unsorted for it to be
   int shuffles = -1;

   //when to show a typo message 
   boolean firstLoop = true;

   while(shuffles  < 0 || shuffles > 100)
   {
        if(firstLoop) 
        {
           System.out.println("Please enter how sorted sorted you want (0 to 100, no decimals)");
        }
        else
        {
            System.out.println("Looks like you made a typo");
            System.out.println("Please enter a integer from 0 to 100");
        }
        shuffles = input.nextInt();
        firstLoop = false;
   }



   //fill it sorted first

   for(int i = 0; i < nums.length; i++)
   {
       nums[i] = i;
   }

   //suffle the array
   for(int swaps = 0; swaps < shuffles; swaps++)
   {
       int firstPlace = (int)(Math.random() * 100);
       int secondPlace = (int)(Math.random() * 100);

       //swap the places
       int temp = nums[firstPlace];
       nums[firstPlace] = nums[secondPlace];
       nums[secondPlace] = temp;
   } 

   //printing it out
   for(int n: nums)
   {
       System.out.println(n);
   }
  }

}