package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> ret = new ArrayList<>();
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{3, 9, 20, 15, 7}, ret);
        System.out.println(ret);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.left.val);
        System.out.println(treeNode.right.right.val);
    }


    public static TreeNode buildTree(int[] inorder, int[] preorder, List<Integer> ret) {
        if(inorder.length == 0 || preorder.length == 0) return null;

        // 另外后序遍历其实就是从右开始前序遍历而已
        // 先创建好最顶层根节点
        TreeNode root = new TreeNode(preorder[0]);
        ret.add(preorder[0]);
        // 得到最顶层根节点在中序遍历中的位
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }


        // 分割数组
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex); // 左子树的中序遍历
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length+1); // 左子树的前序遍历
        int[] inorderRight = Arrays.copyOfRange(inorder, inorderLeft.length+1, inorder.length); // 右子树的中序遍历
        int[] preorderRight = Arrays.copyOfRange(preorder, preorderLeft.length+1, preorder.length); // 右子树的前序遍历


        root.left = buildTree(inorderLeft, preorderLeft, ret);
        root.right = buildTree(inorderRight, preorderRight, ret);

        return root;
    }
}