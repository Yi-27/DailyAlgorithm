package tree;

import java.util.*;

/**
 * @author: Yi-27
 * @projectName: LearnJavaWeb
 * @create: 2020-11-16 20:34
 * @Description:
 */
public class SymmetricTree {

    public static void main(String[] args) {
        // [5,4,1,null,1,null,4,2,null,2,null]
        TreeNode n6 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n1 = new TreeNode(4);
        TreeNode n0 = new TreeNode(5);

        n0.left = n1;
        n0.right = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(isSymmetric2(n0));

    }

    // 迭代
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        TreeNode rootroot = root; // 用于标记最顶层根节点
        TreeNode root2 = root; // 复制一份引用

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        // 一个栈装左子树，一个栈装右子树
        // 就是一边直冲最底层左子树，一边直冲最右右子树
        // 就是类似中序遍历一样，左右子树只不过是相反的而已
        while(!stack.isEmpty() || !stack2.isEmpty() || root != null || root2 != null){
            int leftVal = 0, rightVal = 0;
            while(root != null){
                stack.push(root); // 把本身放进栈
                root = root.left;
                // 出这个循环说明达到最左边的节点了
            }
            while(root2 != null){
                stack2.push(root2); // 把本身放进栈
                root2 = root2.right;
                // 出这个循环说明达到最右边的节点了
            }

            // 弹出最上面的节点（即为上行代码比较值的节点）
            root = stack.pop();
            root2 = stack2.pop();
            leftVal = root.val; // 记录值
            rightVal = root2.val; // 记录值

            System.out.println(leftVal + " - " + rightVal);
            // 在判断值前先判断两个栈内的元素是否一样多，对称树应该时一样多的
            if(stack.size() != stack2.size()) return false;

            if (leftVal != rightVal) return false; // 判断左右值，不同即false

            // 有一个回到顶层节点另一个却没回到顶层节点时直接返回false
            if(root == rootroot && root2 != rootroot) return false;
            if(root2 == rootroot && root != rootroot) return false;
            // 判断是否回到了最顶层根节点
            if(root == root2) return true; // 回到了说明左右子树一样，这时就必要再往下判断了

            // 没回到最顶层根节点，就要判断左子树的右节点和右子树的左节点值是否相同
            root = root.right;
            root2 = root2.left;
        }

        return stack.isEmpty() && stack2.isEmpty();
    }




    // 递归
    public static boolean isSymmetric(TreeNode root) {

        return check(root, root);
    }


    public static boolean check(TreeNode leftNode, TreeNode rightNode){

        if(leftNode == null && rightNode == null) return true;
        if(leftNode == null || rightNode == null) return false;

        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }
}



