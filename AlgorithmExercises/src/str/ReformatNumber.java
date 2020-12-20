package str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-20 22:32
 * @Description:
 * 5629. 重新格式化电话号码
 */
public class ReformatNumber {

    public static void main(String[] args) {

    }

    public static String reformatNumber(String number) {
        int n = number.length();
        if(n == 2) return number;
        StringBuilder sb = new StringBuilder();
        char[] chars = number.toCharArray();
        List<Character> list = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < n; i++){
            if(chars[i] != ' ' && chars[i] != '-')
                list.add(chars[i]);
        }
        System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            if (i != 0 && i % 3 == 0){
                sb.append(list.get(i));
            }else if()
        }
        return sb.toString();
    }
}
