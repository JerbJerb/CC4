public class Airplane {

    //How the seat plan will look like at the start
    static void seatplan(int column,int row,char seat[][]){
        for(int i=0; i<column; i++){ 
        for(int j=0; j<row; j++){
        seat[i][j] ='*';
        }
        }
    }
    static void print(int column, int row,char seat[][]){
        System.out.println("______________________________________");
        for(int i = 0; i < column ; i++){
        for(int j = 0; j < row ; j++)                
                System.out.print(seat[i][j]+"   "); 
                System.out.println("\n"); 
        }
        System.out.println("______________________________________");
    }
    
    //Selection of seats by input
    static void chooseSeat(int column,int row,char seat[][]){
    int ticketType = 0;
    int columnChoice = 0;
    int rowChoice = 0;
    
    java.util.Scanner sc = new java.util.Scanner(System.in);
    
    System.out.print("Enter Ticket Type:\n" + "[1] First Class\n" + "[2] Business Class\n" + "[3] Economy\n" + "_____________________________________\n" + "Answer: ");
        ticketType = sc.nextInt();
        System.out.println();
    
        switch (ticketType) {
            case 1:
                System.out.print("Enter the ROW you want [1-3]: ");
                rowChoice = sc.nextInt();
                if(rowChoice >= 1 && rowChoice <= 3){
                    System.out.print("Enter the COLUMN you want [1-6]: ");
                    columnChoice = sc.nextInt();
                    if(columnChoice <= 1 && columnChoice >= 6){
                        System.out.println("Error:\n" + "Number input is invalid\n" + "No changes have been made");
                break;
                
                 }else{
                        if(seat[rowChoice-1][columnChoice-1] == 'X'){
                            System.out.println("_____________________________________\n" + "Seat Taken. Please choose another seat number!\n");
                        }else{
                            seat[rowChoice-1][columnChoice-1] = 'X';
                        }
                    }
                    
                }else{
                    System.out.println("Error:\n" + "Number input is invalid\n" + "No changes have been made");
                break;
                }break;
                
            case 2:
                System.out.print("Enter the ROW you want [4-8]: ");
                rowChoice = sc.nextInt();
                if(rowChoice >= 4 && rowChoice <= 8){
                    System.out.print("Enter the COLUMN you want [1-6]: ");
                    columnChoice = sc.nextInt();
                    if(columnChoice <= 1 && columnChoice >= 6){
                        System.out.println("Error:\n" + "Number input is invalid\n" + "No changes have been made");
                break;
                
                    }else{
                        seat[rowChoice-1][columnChoice-1] = 'X';
                    }
                    
                }else{
                    System.out.println("Error:\n" + "Your answer is invalid\n" + "No changes have been made :)");
                break;
                }break;
            
      
            case 3:
                System.out.print("Enter the ROW you want [9-13]: ");
                rowChoice = sc.nextInt();
                if(rowChoice >= 9 && rowChoice <= 13){
                    System.out.print("Enter the COLUMN you want [1-6]: ");
                    columnChoice = sc.nextInt();
                    if(columnChoice <= 1 && columnChoice >= 6){
                        System.out.println("Error:\n" + "Your answer is invalid\n" + "No changes have been made.");
                break;
                
                    }else{
                        seat[rowChoice-1][columnChoice-1] = 'X';
                    }
                    
                }else{
                    System.out.println("Error:\n" + "Your answer is invalid\n" + "No changes have been made :)");
                break;
                }break;
            
            default:
                System.out.println("Because your Input is Invalid.\n" + "No changes have been made :)");
            break;
        }
    
    }
    //Try again
    public static void main(String[] args) {
        
    java.util.Scanner sc = new java.util.Scanner(System.in);
        
    String tryAgain = "y";
    int row = 13;
    int column = 6;
    char[][] seat = new char[row][column];
    seatplan(row,column,seat);
    print(row,column,seat);
        do{       
            chooseSeat(row,column,seat);
            print(row,column ,seat);

            System.out.print("Do you want to try again? [Y/N]:\n" + "Answer: ");
            tryAgain = sc.nextLine().toLowerCase();
                System.out.println("________________________");
            if(tryAgain.equals("y") || tryAgain.equals("n")){
                if(tryAgain.equals("n"))
                    System.out.println("Thank you! Have a nice day!\n");
            }else{
                System.out.println("________________________\n" + "Your Input is Invalid.\n" + "_________________________");
                System.exit(0);
            }
        }while(!tryAgain.equals("n"));
    }
}
