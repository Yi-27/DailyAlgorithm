package daily;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-30 14:41
 * @Description:
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(2 ^ 2);  // 0
        System.out.println(2 ^ 1);  // 3
        System.out.println(0 ^ 1);  // 1
        System.out.println(0 ^ 2);  // 2
        System.out.println(singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); // 4
        System.out.println(4 ^ 1); // 5
        System.out.println(5 ^ 2); // 7
        System.out.println(7 ^ 1); // 6
        System.out.println(6 ^ 2); // 4
    }

    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^nums[i];
        }

        return nums[0];
    }

}
