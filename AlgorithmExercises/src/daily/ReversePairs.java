package daily;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-28 10:44
 * @Description:
 */
public class ReversePairs {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2,4,3,5,1}));
    }

    public static int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;

        return reversePairsRecursive(nums, 0, nums.length-1);
    }

    /**
     *
     * @param nums 要求解的数组
     * @param left 左指针 刚开始指向数据第一个元素
     * @param right 右指针 刚开始指向数组的最后一个元素
     * @return 翻转对数目
     */
    public static int reversePairsRecursive(int[] nums, int left, int right){
        if (left == right) return 0; // 如果左右指针指向同一个元素就返回0

        // 二分思想
        int mid = (left + right) / 2;
        int l = reversePairsRecursive(nums, left, mid);
        int r = reversePairsRecursive(nums, mid + 1, right);
        /*
        假设输入时 [1, 3, 2, 3, 1]
        那么二分第一次 mid=(0+4)/2=2
            左  (nums, 0, 2) 相对应nums就是 [1, 3, 2] 对于这部r为0，但l为
            右  (nums, 3, 4) 相对应nums就是 [3, 1]    对于此情况 l 和 r 的值的值都为 0 ret=0
            左边再二分 mid=(0+2)/2=1
                左左 (nums, 0, 1) 相对应nums就是 [1, 3] 对于此情况 l 和 r 的值都为 0 ret=0
                左右 (nums, 2, 2) 相对应nums就是 [2]   return 0
                左左边再二分 mid=(0+1)/2=0
                    左左左 (nums, 0, 0) 相对应nums就是 [1] return 0
                    左左右 (nums, 1, 1) 相对应nums就是 [3] return 0
            右边再二分 mid=(3+4)/2=3
                右左 (nums, 3, 3) 相对应nums就是 [3] return 0
                右右 (nums, 4, 4) 相对应nums就是 [1] return 0
         */
        int ret = l + r;

        // 当left != right才会继续往下
        // 统计下标对的数量
        int i = left; // 指针i从left开始到mid结束
        int j = mid + 1; // 指针j从mid+1开始到right结束
        /*
        对于上面的数组，到这里来时，第一个nums为[1, 3] left=0，mid=0,right=1
            那么 ret=0, i=0, j=1
            循环都执行一次，j也没++
            ret += 1 - 0 - 1 -> ret = 0

            第二个nums为[3, 1] left=3, mid=3, right=4
            那么ret=0, i=3, j=4
            循环也都执行1次，但是这里j++了
            ret += 5 - 3 - 1 -> ret = 1 这说明存在一个翻转对了

         */
        while (i <= mid){
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]){
                j++;
            }

            ret += j - mid - 1;
            i++;
        }


        // 合并两个排序数组
        int[] sorted = new int[right - left + 1]; // 排序用的数组 长度即为进来的nums的长度
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right){
            if(p1 > mid){
                sorted[p++] = nums[p2++];
            }else if(p2 > right){
                sorted[p++] = nums[p1++];
            }else{
                if(nums[p1] < nums[p2]){
                    sorted[p++] = nums[p1++];
                }else{
                    sorted[p++] = nums[p2++];
                }
            }
        }
        System.out.println("sorted = " + Arrays.toString(sorted));
        // 修改排序后的nums数组
        // 该方法第一个参数为源数组，第二个参数为从原数组的多少索引开始
        // 第三个参数为目标数组，第四个参数为为从目标数组的多少索引开始
        // 第五个参数为要复制的长度
        // 即从源数组指定位置开始复制多长的元素放在目标数组指定位置开始往后多长的地方
        if (sorted.length >= 0) System.arraycopy(sorted, 0, nums, left, sorted.length);
        System.out.println("nums = " + Arrays.toString(nums));
        return ret;
    }
}
