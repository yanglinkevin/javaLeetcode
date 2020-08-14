
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Offer55BalanceTree {
    public static void  main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        Offer55BalanceTree test = new Offer55BalanceTree();
        System.out.println(test.isBalanced(root));

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int helper(TreeNode node) {
        if(node==null) {
            return 0;
        }
        if (node.left==null && node.right==null) {
            return 1;
        }
        return Math.max(helper(node.left), helper(node.right))+1;
    }
}