package competition;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-29 10:38
 * @Description:
 */
public class MostCompetitive {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71}, 24)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        /*
        [84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71]
24
[2,4,3,3,5,4,9,6]
4
         */
        int[] copy = Arrays.copyOf(nums, nums.length); // 复制一个数组
        Arrays.sort(copy); // 排序
        for (int value : copy) { // 挨个顺序作为最小竞争子序列的头元素
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == value) {
                    //  判断后续元素个数可够k长度
                    if(k == 1){
                        int[] ret = new int[1];
                        ret[0] = nums[j];
                        return ret;
                    }
                    if (j + k > nums.length) break;
                    else if (j + k == nums.length) return Arrays.copyOfRange(nums, j, nums.length);
                    else {
                        int[] child = Arrays.copyOfRange(nums, j + 1, nums.length);
                        int[] childMost = mostCompetitive(child, k - 1);
                        System.out.println(Arrays.toString(childMost));
                        // 取前k-1即为最优解
                        int[] ret = new int[k];
                        ret[0] = nums[j];
                        System.arraycopy(childMost, 0, ret, 1, k - 1);
                        System.out.println(Arrays.toString(ret));
                        return ret;
                    }
                }
            }
        }
        // [10, 23, 61, 62, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71]
        // [10, 23, 61, 62, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71]
        /*  2
        4 3 3 5 4 9 6     3
        3
        3 5 4 9 6   3
        2
        5 4 9 6
        1
         */
        return Arrays.copyOf(nums, k); // 这步不会执行
    }

    public static int[] compare(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]){
                if(a[i] < b[i]) return a;
                else return b;
            }
        }
        return a; // 都一样就输出其中之一即可
    }
}
