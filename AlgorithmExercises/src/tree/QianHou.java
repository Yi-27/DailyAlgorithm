package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-17 20:35
 * @Description:
 */
public class QianHou {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        // 中序和后序的区别就是，最顶层根节点一个在中间一个在末尾
        // 另外后序遍历其实就是从右开始前序遍历而已
        ArrayList<Integer> intsIn = new ArrayList<>();
        ArrayList<Integer> intsPost = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            intsIn.add(inorder[i]);
            intsPost.add(postorder[i]);
        }
        System.out.println("ints = " + intsIn);
        System.out.println("ints2 = " + intsPost);
        TreeNode root = new TreeNode(intsPost.get(intsPost.size()-1));

        // 分割左右子树
        int rootIndex = intsIn.lastIndexOf(root.val);
        System.out.println(rootIndex);

        List<Integer> ints1LeftTree = intsIn.subList(0, rootIndex);
        List<Integer> ints1RightTree = intsIn.subList(rootIndex+1, intsIn.size());
        List<Integer> ints2LeftTree = intsPost.subList(0, ints1LeftTree.size());
        List<Integer> ints2RightTree = intsPost.subList(ints1LeftTree.size(), intsPost.size()-1);

        root.left = retTree(ints1LeftTree, ints2LeftTree);
        root.right = retTree(ints1RightTree, ints2RightTree);

        return root;
    }

    public static TreeNode retTree(List<Integer> intsIn, List<Integer> intsPost){
        if(intsPost.size()-1 == -1) return null;
        TreeNode root = new TreeNode(intsPost.get(intsPost.size()-1));
        int rootIndex = intsIn.lastIndexOf(root.val);
        List<Integer> ints1LeftTree = intsIn.subList(0, rootIndex);
        List<Integer> ints1RightTree = intsIn.subList(rootIndex+1, intsIn.size());
        List<Integer> ints2LeftTree = intsPost.subList(0, ints1LeftTree.size());
        List<Integer> ints2RightTree = intsPost.subList(ints1LeftTree.size(), intsPost.size()-1);

        root.left = retTree(ints1LeftTree, ints2LeftTree);
        root.right = retTree(ints1RightTree, ints2RightTree);
        return root;
    }


    public static void main(String[] args) {
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

}
