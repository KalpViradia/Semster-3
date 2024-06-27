import java.util.*;

public class Lab32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = new String();
        String s2 = new String();
        System.out.println("Enter the number of words you want to enter :-");
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the word :-");
            words[i]=sc.nextLine();
        }
        Random r = new Random();
        int random=r.nextInt(n);
        s1=words[random];
        System.out.println("Enter anagram for  "+s1+":-");
        s2 = sc.nextLine();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        boolean flag = true;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(arr1.length!=arr2.length){
            System.out.println("Not Anagram Strings");
        }
        else{
            for(int i=0;i<arr1.length;i++){
                for(int j=0;j<arr2.length;j++){
                    if(arr1[i]!=arr2[j]){
                        flag=false;
                    }
                }
            }
        }
        if(flag=true){
            System.out.println("Anagram Strings");
        }
        else{
            System.out.println("Not Anagram Strings");
        }
        sc.close();
    }
}
