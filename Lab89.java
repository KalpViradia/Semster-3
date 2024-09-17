import java.util.Arrays;

class HashTable {
    int size = 10;
    String[] keys;
    String[] values;

    public HashTable() {
        keys = new String[size];
        values = new String[size];
        Arrays.fill(keys, null);
        Arrays.fill(values, null);
    }

    public int hashFunction(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(String key, String value) {
        int index = hashFunction(key);
        
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % size;
        }

        keys[index] = key;
        values[index] = value;
    }

    public String get(String key) {
        int index = hashFunction(key);
        
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % size;
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }
}

public class Lab89 {
    public static void main(String[] args) {
        HashTable dictionary = new HashTable();
        
        dictionary.insert("Apple", "A fruit");
        dictionary.insert("Book", "A source of knowledge");
        dictionary.insert("Computer", "An electronic device");
        dictionary.insert("Desk", "A piece of furniture");
        
        System.out.println("Value for 'Book': " + dictionary.get("Book"));
        System.out.println("Value for 'Apple': " + dictionary.get("Apple"));

        System.out.println("\nHash Table:");
        dictionary.display();
    }
}