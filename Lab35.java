import java.util.*;

class Student_Detail{
    int Enrollment_No;
    String Name;
    int Semester;
    float CPI;

    public void displayDetails(){
        System.out.println("Enrollment Number is :- "+Enrollment_No);
        System.out.println("Name of student  is :- "+Name);
        System.out.println("Semester of student is :- "+Semester);
        System.out.println("CPI of student is :- "+CPI);
    }
}
public class Lab35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student_Detail[] student = new Student_Detail[5];
        for(int i=0;i<5;i++){
            student[i]=new Student_Detail();
            System.out.println("Enter Enrollment Number:-");
            student[i].Enrollment_No = sc.nextInt();
            System.out.println("Enter Name :-");
            student[i].Name = sc.nextLine();
            System.out.println("Enter Semester :-");
            student[i].Semester = sc.nextInt();
            System.out.println("Enter CPI :-");
            student[i].CPI = sc.nextInt();
        }
        for(int i=0;i<5;i++){
            student[i].displayDetails();
        }
        sc.close();
    }
}