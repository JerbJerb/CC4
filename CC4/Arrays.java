public class FirstArray {
    public static void main(String[] args){
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        int [] grades = new int[size];
        
        for(int i = 0; i < grades.length; i++){
            grades[i] = (int) (Math.random() * 200);
        }
        
//        int ctr;
//        for(ctr = 0; ctr < grades.length; ctr++){
//            System.out.print("Enter Element "+(ctr+1)+": ");
//            grades[ctr] = sc.nextInt();
//        }
        
        //printing all
        
        String elems = "Elements are ";
        String g1 = "Elements greater than 10 is/are ";
        String g2 = "Elements with three digits is/are ";
                
        System.out.print("Elements are ");
        
        for(int i = 0; i < grades.length-1; i++){
                System.out.print(grades[i]+", ");
                elems += grades[i]+", ";
        }
        System.out.println(grades[grades.length-1]);
        elems += grades[grades.length-1];
        
        //printing greater than 10
        System.out.print("Elements greater than 10 is/are ");
        
        String greater = "";
        for(int i = 0; i < grades.length; i++){
            if(grades[i] > 10){
                greater += grades[i]+", ";
            }
        }
        String spl = "";
        if(greater != ""){
            spl = greater.substring(0, greater.length()-2);
        }
        System.out.println(spl);
        
        //printing three digits
        System.out.print("Elements with three digits is/are ");
        
        String greater3 = "";
        for(int i = 0; i < grades.length; i++){
            if(grades[i] > 99){
                greater3 += grades[i]+", ";
            }
        }
        String spl3 = "";
        if(greater3 != ""){
            spl3 = greater3.substring(0, greater3.length()-2);
        }
        System.out.println(spl3);
        
        JOptionPane.showMessageDialog(null, elems+"\n"+g1+spl+"\n"+g2+spl3);
    }
}