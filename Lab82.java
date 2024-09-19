import java.util.Scanner;

class TreeNode1 {
    int value;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Lab82 {

    public static TreeNode1 constructTree(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode1 constructTree(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode1 root = new TreeNode1(preorder[preStart]);
        
        if (preStart == preEnd) {
            return root;
        }

        int leftRootValue = preorder[preStart + 1];
        int leftRootIndexInPost = findIndex(postorder, leftRootValue, postStart, postEnd);
        int leftSubtreeSize = leftRootIndexInPost - postStart + 1;

        root.left = constructTree(preorder, postorder, preStart + 1, preStart + leftSubtreeSize, postStart, leftRootIndexInPost);
        root.right = constructTree(preorder, postorder, preStart + leftSubtreeSize + 1, preEnd, leftRootIndexInPost + 1, postEnd - 1);

        return root;
    }

    private static int findIndex(int[] arr, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void inorder(TreeNode1 root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the tree: ");
        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] postorder = new int[n];

        System.out.println("Enter the preorder traversal:");
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        System.out.println("Enter the postorder traversal:");
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }

        TreeNode1 root = constructTree(preorder, postorder);
        System.out.println("Inorder traversal of constructed tree:");
        inorder(root);

        sc.close();
    }
}
