import java.util.*;
class tempConverter{
    double Celsius_To_Fahrenhit(double Celsius){
        return (Celsius*9/5)+32;
    }
    double Fahrenhit_To_Celsius(double Fahrenhit){
        return (Fahrenhit-32)*9/5;
    }
}

public class Lab36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tempConverter tc = new tempConverter();
        System.out.println("Enter 1 for Celsius to Fahrenhit  or 2 for Fahrenhit to Celsius :-");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            System.out.println("Enter temp in Celsius");
            double Celsius = sc.nextDouble();
            System.out.println("Temperature in Fahrenhit is "+tc.Celsius_To_Fahrenhit(Celsius));;
            break;
            case 2:
            System.out.println("Enter temp in Fahrenhit");
            double Fahrenhit = sc.nextDouble();
            System.out.println("Temperature in Celsius is "+tc.Fahrenhit_To_Celsius(Fahrenhit));;
            break;
            default:
            System.out.println("Invalid Input");
            break;
        } 
        sc.close();
    }   
}