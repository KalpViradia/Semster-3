class PhoneBookEntry {
    String name;
    String phoneNumber;
    PhoneBookEntry left, right;

    PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        left = right = null;
    }
}

class PhoneBook {
    private PhoneBookEntry root;

    public void addEntry(String name, String phoneNumber) {
        root = insert(root, name, phoneNumber);
    }

    private PhoneBookEntry insert(PhoneBookEntry root, String name, String phoneNumber) {
        if (root == null) {
            return new PhoneBookEntry(name, phoneNumber);
        }
        if (name.compareTo(root.name) < 0) {
            root.left = insert(root.left, name, phoneNumber);
        } else if (name.compareTo(root.name) > 0) {
            root.right = insert(root.right, name, phoneNumber);
        }
        return root;
    }

    public void removeEntry(String name) {
        root = delete(root, name);
    }

    private PhoneBookEntry delete(PhoneBookEntry root, String name) {
        if (root == null) return root;

        if (name.compareTo(root.name) < 0) {
            root.left = delete(root.left, name);
        } else if (name.compareTo(root.name) > 0) {
            root.right = delete(root.right, name);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            PhoneBookEntry temp = findMin(root.right);
            root.name = temp.name;
            root.phoneNumber = temp.phoneNumber;
            root.right = delete(root.right, temp.name);
        }
        return root;
    }

    private PhoneBookEntry findMin(PhoneBookEntry root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public String searchPhoneNumber(String name) {
        PhoneBookEntry entry = search(root, name);
        return (entry != null) ? entry.phoneNumber : null;
    }

    private PhoneBookEntry search(PhoneBookEntry root, String name) {
        if (root == null || root.name.equals(name)) return root;
        if (name.compareTo(root.name) < 0) return search(root.left, name);
        return search(root.right, name);
    }

    public void listEntriesAscending() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(PhoneBookEntry root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.name + ": " + root.phoneNumber);
            inOrderTraversal(root.right);
        }
    }

    public void listEntriesDescending() {
        reverseInOrderTraversal(root);
    }

    private void reverseInOrderTraversal(PhoneBookEntry root) {
        if (root != null) {
            reverseInOrderTraversal(root.right);
            System.out.println(root.name + ": " + root.phoneNumber);
            reverseInOrderTraversal(root.left);
        }
    }
}

public class Lab84 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addEntry("Alice", "1234567890");
        phoneBook.addEntry("Bob", "9876543210");
        phoneBook.addEntry("Charlie", "5555555555");
        phoneBook.addEntry("David", "4444444444");
        phoneBook.addEntry("Eve", "3333333333");

        System.out.println("Phone number of Bob: " + phoneBook.searchPhoneNumber("Bob"));

        System.out.println("\nPhone book entries in ascending order:");
        phoneBook.listEntriesAscending();

        System.out.println("\nPhone book entries in descending order:");
        phoneBook.listEntriesDescending();

        phoneBook.removeEntry("Charlie");
        System.out.println("\nAfter removing Charlie, entries in ascending order:");
        phoneBook.listEntriesAscending();
    }
}