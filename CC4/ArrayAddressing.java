import java.util.Scanner;
public class ArrayAddress {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Database Dimensions: ");
        int dimen = sc.nextInt();
        
        int [] upperBounds = new int[dimen];
        int [] index = new int [dimen];
        int esize, address, base;
        int Elems = 1;
        
        System.out.println();
        for(int i = 0; i < dimen; i++){
            System.out.print("Enter UB" + (i+1) + ": ");
            upperBounds[i] = sc.nextInt();
            Elems = Elems * upperBounds[i];
        }
        System.out.print("\nEnter Number of Fields: ");
        int numFields = sc.nextInt();
        
        String [] Name = new String[numFields];
        int [] Length = new int[numFields];
        String [] dataType = new String[numFields];
    
        int [] byteSize = new int[numFields];
        int eSize = 0;
        
        sc.nextLine();
        for(int i = 0; i < numFields; i++){
            System.out.print("FIELD " +(i+1)+ " NAME: ");
            Name[i] = sc.nextLine();
            System.out.print("FIELD " +(i+1)+ " LENGTH: ");
            Length[i] = sc.nextInt();
            sc.nextLine();
            System.out.print("FIELD " +(i+1)+ " DATATYPE: ");
            dataType[i] = sc.nextLine();
            
            switch(dataType[i]){
                case "char":
                    byteSize[i] = Length[i] * 1;
                    break;
                case "int":
                    byteSize[i] = Length[i] * 2;
                    break;
                case "double":
                    byteSize[i] = Length[i] * 8;
                    break;
            }
            System.out.println("Data Field " + Name[i] + " is " + byteSize[i] + " bytes in size.");
        }
        System.out.print("Enter Starting Address: ");
        address = sc.nextInt();
        int Esize = 0;
        for(int i = 0; i < numFields; i++){
            Esize = Esize + byteSize[i];
        }
        System.out.println("Esize Per Record: " + Esize);
        System.out.println("Your Database can hold " + numOfElements(upperBounds) +" bytes in size.");
        System.out.println("Your Database consumes " + (numOfElements(upperBounds)*Esize) +" bytes of memory space.");
        
        
        System.out.println("\n\nSEARCH FOR THE ADDRESS OF A FIELD IN A SPECIFIC RECORD FROM THE DATABASE");
        
        for(int a = 0; a < dimen; a++){
            System.out.print("Input search index at Dimension " + (a+1) + ": ");
            index[a] = sc.nextInt();
        }
        sc.nextLine();
        System.out.print("Input Field name to search in the record: ");
        String fieldName = sc.nextLine();
        double bytes = 0;
        for(int i = 0; i < numFields; i++){
            if(fieldName.equals(Name[i])){
                bytes = byteSize[i];
            }
        }
        double result = (getAddress(upperBounds, index, address, Esize) - bytes);
        System.out.println("The address of this record's " + fieldName + " is located at: " + result);
    }
        static int numOfElements(int[] upperBounds){
            int numberOfElements = 1;
            for(int b = 0; b < upperBounds.length; b++){
                numberOfElements = numberOfElements * upperBounds[b];
            }
            return(numberOfElements);
        }
        static double getAddress(int[] upperBounds, int []index, int base, int esize){
            int dimen = upperBounds.length;
            int address = 0;
            
            for(int i = 0; i < dimen; i++){
                int temp = index[i];
                for(int j = i + 1; j < dimen; j++){
                    temp = temp * upperBounds[j];
                }
                address = address + temp;
            }
        address = address * esize + base;
        return address;
        }
}