package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-05 12:38
 * @Description:
 */
public class LeastInterval {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B', 'B','C', 'B','D', 'D','E', 'E','F', 'F','G', 'G'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for (char task : tasks) {
            buckets[task - 'A']++;
        }
        Arrays.sort(buckets);
        System.out.println(Arrays.toString(buckets));
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
