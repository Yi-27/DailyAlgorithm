package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-19 14:03
 * @Description:
 */
public class Connect {

    public static Node connext(Node root){
        if (root == null) return null;
        // 层序遍历 广度优先遍历
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root); // 先将根节点添加进队列
        while(!queue.isEmpty()){
            List<Node> list = new ArrayList<>();
            int queueSize = queue.size(); // 记录此时的队列的元素个数
            for (int i = 0; i < queueSize; i++) {
                // 取出队列中的节点，放进list中
                Node node = queue.poll();
                list.add(node);

                // 如果node的左右节点存在就放进队列，即为下一层节点
                if(node.left != null) queue.offer(node.left); // 先左再右
                if(node.right != null) queue.offer(node.right);
            }
            // 现在list有每一层的节点，这时候从左往右添加next就行
            for (int i = 0; i < list.size(); i++) {
                if(i+1 == list.size()) list.get(i).next = null;
                else list.get(i).next = list.get(i+1);
            }
        }

        return root;
    }
}
