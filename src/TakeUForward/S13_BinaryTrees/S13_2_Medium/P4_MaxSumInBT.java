package TakeUForward.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
 */
public class P4_MaxSumInBT {

    /**
     * Approach (Post-Order Traversal):
     * 1. At each step find recursively its left max and right max path
     * 2. In the maxi, store the sum of curr.data + lMax + rMax
     * 3. Return the curr.data + Math.max(lMax, rMax)
     * <p>
     * TC: O(N)
     * SC: O(H)
     *
     * @param curr
     * @return
     */
    public int maximumSumInBT(TreeNode curr) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        maximumSumInBT_util(curr, maxPath);

        return maxPath[0];
    }

    public int maximumSumInBT_util(TreeNode curr, int[] maxi) {
        if (curr == null) {
            return 0;
        }

        int lMax = Math.max(0, maximumSumInBT_util(curr.left, maxi));
        int rMax = Math.max(0, maximumSumInBT_util(curr.right, maxi));

        maxi[0] = Math.max(maxi[0], curr.data + lMax + rMax);

        return curr.data + Math.max(lMax, rMax);
    }

    public static void main(String[] args) {
        P4_MaxSumInBT p4_maxSumInBT = new P4_MaxSumInBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(10);
        root.left.left.left.left = new TreeNode(11);

        System.out.println(p4_maxSumInBT.maximumSumInBT(root));
    }
}
