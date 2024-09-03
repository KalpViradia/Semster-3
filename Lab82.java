import java.util.HashMap;
import java.util.Scanner;

class treeNode {
    int val;
    treeNode left, right;

    public treeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTreeConstruction {
    int preorderIndex;
    HashMap<Integer, Integer> postorderMap;

    public treeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preorderIndex = 0;
        postorderMap = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }

        return constructTree(preorder, postorder, 0, postorder.length - 1);
    }

    public treeNode constructTree(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || preorderIndex >= preorder.length) {
            return null;
        }

        treeNode root = new treeNode(preorder[preorderIndex++]);

        if (postStart == postEnd || preorderIndex >= preorder.length) {
            return root;
        }

        int postIndex = postorderMap.get(preorder[preorderIndex]);

        if (postIndex <= postEnd) {
            root.left = constructTree(preorder, postorder, postStart, postIndex);
            root.right = constructTree(preorder, postorder, postIndex + 1, postEnd - 1);
        }

        return root;
    }

    public void printInorder(treeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}

public class Lab82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the tree: ");
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] postorder = new int[n];
        int count = 0;
        System.out.println("Enter array elements: ");
        for (int i = 0;i < n;i++) {
            System.out.println("Enter value for element in index "+i+" for preorder: ");
            preorder[i] = sc.nextInt();
        }

        for (int i = 0;i < n;i++) {
            System.out.println("Enter value for element in index "+i+" for postorder: ");
            postorder[i] = sc.nextInt();
        }

        for (int i = 0;i < n; i++) {
            for (int j = 0;j < n; j++) {
                if (postorder[j] == preorder[i]) {
                    count++;
                }
            }   
        }

        if (count == n) {
            BinaryTreeConstruction tree = new BinaryTreeConstruction();
            treeNode root = tree.constructFromPrePost(preorder, postorder);

            System.out.println("Inorder traversal of the constructed tree:");
            tree.printInorder(root);
        }
        else {
            System.out.println("Not a valid binary tree");
        }

        sc.close();
    }
}