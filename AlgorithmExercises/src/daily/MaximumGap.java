package daily;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-26 9:58
 * @Description:
 */
public class MaximumGap {

    public static void main(String[] args) {
        System.out.println("maximumGap(new int[]{3,6,9,1}) = " + maximumGap(new int[]{3, 6, 9, 1}));
    }

    public static int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0, j = 1; j < nums.length; i++,j++) {
            if(nums[j] - nums[i] > max) max = nums[j] - nums[i];
        }
        return max;
    }
}
