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

    // 层序遍历
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


    // next指针链表的方法
    public static Node connext2(Node root){
        if(root == null) return root;

        // 把每一层看做是链表
        Node current = root; // 表示当前链表的节点
        while(current != null){ // 直到最后一个元素
            // 先在准备next连接的链表（层）前加一个哑节点
            // 同时可以方便串联下一层
            Node dummy = new Node(0); // 哑节点只为指明链表起点

            // pre节点用于指明哪个节点 准备 连接next
            Node pre = dummy;

            // 开始遍历当前层的链表
            while(current != null){
                if(current.left != null){
                    // 先从左子树开始
                    // 对于一开始，pre节点在哑节点上，哑节点在当前层链表的前面
                    // 那么可以先将哑节点与第一个节点链接在一起
                    pre.next = current.left;
                    // 然后让pre移动到当前层链表第一个节点上
                    pre = pre.next;
                }

                if(current.right != null){
                    // 右子树同左子树一样
                    // pre连接完左子树，该量级右子树了
                    pre.next = current.right;
                    pre = pre.next;
                }

                // 如果current是root几点那么其next为null，这里赋值后就会跳出循环
                // 但是上面的代码，已经让root节点下的左右节点通过next连接在一起了
                current = current.next;
                // 如果不是root节点，而是root下面的已经连接了next的节点
                // 如果是第二层，上面一次循环将root.left的左右子树通过next连接起来了
                // 那么就要去连接root.right的左右子树
            }

            // 当前层的节点的左右子树都通过next连接起来后
            // 去下一层（即当前层的左右子树的层）准备next连接再下一层的左右子树了
            // 由于哑节点在当前层的链表（即下一层）的前面
            // 那么哑节点的next就是下一层的起点
            current = dummy.next;
        }

        return root;
    }
}
