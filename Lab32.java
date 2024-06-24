import java.util.*;

public class Lab32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = new String();
        String s2 = new String();
        System.out.println("Enter string 1 :- ");
        s1 = sc.nextLine();
        System.out.println("Enter string 2 :- ");
        s2 = sc.nextLine();
        int temp = 0;
        if(s1.length()!=s2.length()){
            System.out.println("Not Anagram Strings");
        }
        else{
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    if(s1.charAt(i)==s2.charAt(j)){    
                        temp++;
                        break;
                    }
                }    
            }
        }
        if(temp == s1.length()){
            System.out.println("Anagram Strings");
        }
        else{
            System.out.println("Not Anagram Strings");
        }
        sc.close();
    }
}