import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yi-27
 * @projectName: LearnJavaWeb
 * @create: 2020-11-15 10:36
 * @Description:
 */
public class OrderedStream {

    String[] ret;
    int ptr = 0; // 指针

    public OrderedStream(int n) {
        this.ptr = 1;
        ret = new String[n];
    }

    public List<String> insert(int id, String value) {
        ret[id-1] = value; // 先添加值

        List<String> retList = new ArrayList<>();

        // 返回值，从当前指针往后所有长度的
        for(int i=ptr-1; i<ret.length; i++){
            System.out.println("i:" + i + ", id:" + id+ ", ptr: " + ptr) ;
            if((id != ptr || ret[i] == null) && ret[ptr-1] == null){
                break;
            }else{
                retList.add(ret[i]);

                ptr++;
//                System.out.println("" + retList + ", " + ptr);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }
}
