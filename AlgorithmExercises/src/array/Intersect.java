package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-30 15:15
 * @Description:
 */
public class Intersect {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{9,4,9,8,4}, new int[]{4,9,5})));
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i : nums1){
            count.put(i, count.getOrDefault(i, 0)+1);
        }

        List<Integer> ret = new ArrayList<>();
        for(int i : nums2){
            if(count.get(i) != null && count.get(i) != 0){
                ret.add(i);
                count.put(i, count.get(i)-1);
            }
        }

        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }


}
