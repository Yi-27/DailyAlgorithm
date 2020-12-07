package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-07 9:53
 * @Description:
 * 5618. K 和数对的最大数目
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int ret = 0;
        for(int i = 1; i <= k/2; i++){ // k=6 1 2 3 4 5
            if(map.containsKey(i) && map.containsKey(k-i)){
                if(i == k-i){
                    ret += map.get(i)/2;
                }else{
                    ret += Math.min(map.get(i), map.get(k-i));
                }

            }
        }
        return ret;
    }
}
