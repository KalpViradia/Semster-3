import java.util.*;

class Employee_Detail{
    int Employee_ID;
    String Name;
    String Designation;
    int Salary;

    public void displayDetails(){
        System.out.println("Employee Id is :- "+Employee_ID);
        System.out.println("Name of employee is :- "+Name);
        System.out.println("Designation of employee is :- "+Designation);
        System.out.println("Salary of employee is :- "+Salary);
    }
}
public class Lab34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee_Detail employee = new Employee_Detail();
        System.out.println("Enter Employee Id:-");
        employee.Employee_ID = sc.nextInt();
        System.out.println("Enter Name :-");
        employee.Name = sc.nextLine();
        System.out.println("Enter Designation :-");
        employee.Designation = sc.nextLine();
        System.out.println("Enter Salary :-");
        employee.Salary = sc.nextInt();
        employee.displayDetails();
        sc.close();
    }
}