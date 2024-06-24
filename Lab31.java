import java.util.*;

public class Lab31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1 = 3;
        int col1 = 2;
        int row2 = 2;
        int col2 = 3;
        int[][] m1 = new int[row1][col1];
        int[][] m2 = new int[row2][col2];
        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                System.out.println("Enter a array element for matrix 1 :-");
                m1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<row2;i++){
            for(int j=0;j<col2;j++){
                System.out.println("Enter a array element for matrix 2 :-");
                m2[i][j]=sc.nextInt();
            }
        }
        int[][] m3 = new int[row1][col2];
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                for(int k=0;k<col1;k++){
                    m3[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        System.out.println("Multiplication of matrix is :-");
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                System.out.println(m3[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}