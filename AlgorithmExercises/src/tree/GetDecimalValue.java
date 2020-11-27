package tree;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-27 13:24
 * @Description:
 */
public class GetDecimalValue {
    public static int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        StringBuilder str = new StringBuilder();
        while(head != null){
            str.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(str.toString(), 2);
    }
}
