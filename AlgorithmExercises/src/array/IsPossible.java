package array;

import java.util.*;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-04 8:03
 * @Description:
 *  659. 分割数组为连续子序列
 */
public class IsPossible {

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
    }

    public static boolean isPossible(int[] nums) {
        // 哈希＋最小堆
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>()); // 为每个重复的数创建一个最小堆
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll(); // 前一个数的堆的顶元素弹出来
                if (map.get(x - 1).isEmpty()) { // 如果前一个元素的最小堆是空的
                    map.remove(x - 1); // 就移除这个元素
                }
                map.get(x).offer(prevLength + 1); // 当前一个元素加1（就成当前元素了）添加到当前元素的最小堆上
            } else {
                map.get(x).offer(1); // ？
            }
            System.out.println(map);
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
