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

    void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    public void preOrderRec(treeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    public void postOrderRec(treeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
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

public class Lab78 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\nBinary Search Tree Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    bst.insert(value);
                    break;
                case 2:
                    System.out.println("Inorder Traversal:");
                    bst.inOrder();
                    break;
                case 3:
                    System.out.println("Preorder Traversal:");
                    bst.preOrder();
                    break;
                case 4:
                    System.out.println("Postorder Traversal:");
                    bst.postOrder();
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