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

    int findMin() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return minValue(root);
    }

    public int minValue(treeNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    int findMax() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return maxValue(root);
    }

    public int maxValue(treeNode root) {
        int maxValue = root.key;
        while (root.right != null) {
            maxValue = root.right.key;
            root = root.right;
        }
        return maxValue;
    }
}

public class Lab83 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBinary Search Tree Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Find minimum");
            System.out.println("4. Find maximum");
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
                 	System.out.println("Minimum value is "+bst.findMin());
                    break;
                case 4:
                    System.out.println("Maximum value is "+bst.findMax());
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