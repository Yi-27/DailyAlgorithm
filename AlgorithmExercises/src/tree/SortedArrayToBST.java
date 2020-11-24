package tree;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-24 9:10
 * @Description:
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(1/2);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        int mid = 0;
        if (nums.length % 2 == 0){
            // 偶数为中间节点-1
            mid = nums.length/2-1;
        }else{
            // 奇数为中间节点
            mid = nums.length/2;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid, nums.length));
        return root;
    }
}
