import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab54 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int numberOfQueries = scnextInt();
        scnextLine();
        String[] queries = new String[numberOfQueries];
        
        for (int i = 0; i < numberOfQueries; i++) {
            queries[i] = scnextLine();
        }

        Deque<String> feathers = new LinkedList<>();

        for (String query : queries) {
            if (query.startsWith("buy_")) {
                String color = query.substring(4);
                feathers.addFirst(color);
            } else if (query.equals("fetch")) {
                if (!feathers.isEmpty()) {
                    String bottomFeather = feathers.removeLast();
                    System.out.println(bottomFeather);
                    feathers.addFirst(bottomFeather);
                } else {
                    System.out.println("No feathers to fetch.");
                }
            }
        }

        scclose();
    }
}