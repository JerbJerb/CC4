import java.text.DecimalFormat;
import java.util.Scanner;


public class SalaryCompetition {

    static SimpleEmployee employee1 = new SimpleEmployee();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        
        
        System.out.println("Enter your name");
        employee1.setName(sc.nextLine());
        
        System.out.println("Enter Gross weekly Sales ");
        employee1.setWeeklyGross(sc.nextDouble());
        
        DecimalFormat df = new DecimalFormat("###0.00");
        double net = netweekly(employee1.getWeeklyGross());
        System.out.println("\n\n***SNOW ENTERPRISES ***");
        System.out.println("Employee Name:              " + employee1.getName());
        System.out.println("Gross Salary:               " + employee1.getWeeklyGross());
        System.out.println("Bonus:                      " + df.format(employee1.getBonusRate()));
        System.out.println("Net Weekly Salary:          " + df.format(net));
        System.out.println("Classification:             " + employee1.getClassification());
    }
    
    static double netweekly(double sales){
        double bonus = sales * employee1.BonusRate;
        employee1.BonusRate = bonus;
        double net = bonus + employee1.getFixedSalary();
        employee1.setClassification(classify(net)); 
       
        
        return net;
        
    }
    
    static char classify(double net){
        char classif[] = {'A','B','C','D','E','F'};
        int condition[]  = {1500,2000,2500,3000,3500,4000,10000000};
        
        char Classification = 'x';
        for(int i = 1; i < condition.length; i++){
            if(net >= condition[i-1] && net <condition[i]){
                Classification = classif[i-1];
            }
        }
        return Classification;
        }
        
  
        
    
}

