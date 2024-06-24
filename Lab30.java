import java.util.*;

public class Lab30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 2;
        int cols = 2;
        int[][] m1 = new int[rows][cols];
        int[][] m2 = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("Enter a array element for matrix 1 :-");
                m1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("Enter a array element for matrix 2 :-");
                m2[i][j]=sc.nextInt();
            }
        }
        int[][] m3 = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                m3[i][j]=m1[i][j]+m2[i][j];
            }
        }
        System.out.println("Addition of matrix is :-");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println(m3[i][j]);
            }
            System.out.println();
        }
        sc.close(); 
    }
}