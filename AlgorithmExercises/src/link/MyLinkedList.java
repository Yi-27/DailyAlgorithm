package link;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-25 12:14
 * @Description:
 */
public class MyLinkedList {

    int val;
    MyLinkedList next;
    MyLinkedList prev;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    public MyLinkedList(int val) {
        this.val = val;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        for(int i = 0; i < index; i++){

        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList link = this;
        while(this.prev != null){
            link = this.prev;
        }
        link.val = val;
        link = this;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }



}
