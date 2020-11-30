package daily;

import tree.Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-30 13:32
 * @Description:
 */
public class ReorganizeString {

    public static String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }

        // 26个字母计数数组
        int[] counts = new int[26];
        int maxCount = 0; // 字母最多数量计数
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }

        // 如果最多字符的个数比 字符串+1的一半还要多就说明题目无解
        // 比如 aaab 3 > (4+1)/2 -> 3 > 2 比如 aaa 3 > (3+1)/2 -> 3 > 2
        // 只要不是这种情况，那么肯定能够构造成满足题意的字符串
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        // 优先级队列    字符数量大的放在最前面
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c); // 按顺序将不为0 的字母加进队列中
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) { // 因为一次取两个字符所以控制条件是队列得大于1
            char letter1 = queue.poll(); // 取出一个字母
            char letter2 = queue.poll(); // 再取出一个字母

            // 拼接字符串
            sb.append(letter1);
            sb.append(letter2);

            // 得到该字母在计数数组中的索引
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--; // 拼接了一次就减去一下

            // 如果该字母计数没减到0就放进队列继续排队，等下一轮的--
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }

        // 这时队列中就剩一个字母了
        if (queue.size() > 0) {
            sb.append(queue.poll()); // 拼接到字符串上即可
        }
        return sb.toString();
    }
}
