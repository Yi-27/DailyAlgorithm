package daily;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.compare;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-23 7:56
 * @Description:
 */
public class FindMinArrowShots {

    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;

        // 先排序 定制排序 按右边界来排序
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] pLeft, int[] pRight) {
//                return Integer.compare(pLeft[1], pRight[1]);
//            }
//        });

        // lambda表达式写法
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));

        int position = points[0][1]; // 先把第一支箭指向排序后第一个气球的右边界
        int result = 1; // 气球为0的情况在最顶上已经有了，这里肯定是有气球，所以最少为1
        for(int[] ballon : points){
            // 遍历每个气球
            if(ballon[0] > position){
                // 当气球的左边距大于右边界说明要多射一支箭
                // 同时由于是排过序的，后续的x轴肯定也是大于第一支箭的
                // 因此，第二只箭的位置为放在满足当前判断条件的气球的右边界处，后续的气球的右边界肯定是大于这个气球的
                position = ballon[1];
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

}
