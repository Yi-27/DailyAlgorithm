package daily;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-29 9:05
 * @Description:
 */
public class LargestPerimeter {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3, 4, 15, 2, 9, 4}));
    }

    public static int largestPerimeter(int[] A) {
        // 两边之和大于第三边
        Arrays.sort(A);
        for (int i = A.length-1; i >= 2; i--) {
            if(A[i] < 2*A[i-1]) {
                for (int j = i-1; j >= 1; j--) {
                    if(A[j] <= 2*A[j-1] && A[i] < A[j] + A[j-1]){
                        return A[i] + A[j] + A[j-1];
                    }
                }
            }
        }

        return 0;
    }

}
