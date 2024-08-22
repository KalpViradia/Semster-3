import java.util.Scanner;

class treeNode {
    int key;
    treeNode left; 
    treeNode right;

    public treeNode(int data) {
        key = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    treeNode root;
    public BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRecord(root, data);
    }

    public treeNode insertRecord(treeNode root, int data) {
        if (root == null) {
            root = new treeNode(data);
            return root;
        }
        if (data < root.key) {
            root.left = insertRecord(root.left, data);
        }
        else if (data > root.key) {
            root.right = insertRecord(root.right, data);
        }
        return root;
    }

    boolean search(int data) {
        return searchRecord(root,data);
    }

    boolean searchRecord(treeNode root, int data) {
        if (root == null) {
            return false;
        }
        else if (data == root.key) {
            return true;
        }
        else if (data > root.key) {
            return searchRecord(root.right, data);
        }
        else {
            return searchRecord(root.left, data);
        }
    }

    void delete(int data) {
        root = deleteRecord(root, data);
    }

    public treeNode deleteRecord(treeNode root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.key)
            root.left = deleteRecord(root.left, data);
        else if (data > root.key)
            root.right = deleteRecord(root.right, data);
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRecord(root.right, root.key);
        }

        return root;
    }

    public int minValue(treeNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    public void inOrderRec(treeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }
}

public class Lab77 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBinary Search Tree Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = sc.nextInt();
                    bst.insert(insertValue);
                    break;
                case 2:
                    System.out.println("Inorder Traversal:");
                    bst.inOrder();
                    break;    
                case 3:
                    System.out.println("Enter value to search: ");
                    int searchValue = sc.nextInt();
                    System.out.println(searchValue+" is "+bst.search(searchValue));
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    int DeleteValue = sc.nextInt();
                    bst.delete(DeleteValue);
                    break;        
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}