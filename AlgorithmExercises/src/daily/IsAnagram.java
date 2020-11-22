package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-11-22 18:47
 * @Description:
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }


    public static boolean isAnagram(String s, String t) {
        // 只要长度相等，相同字母个数一样就行
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            // 不在即可直接返回false
            if(!t.contains(s.substring(i, i+1))) return false;

            // 在，就替换第一次出现的值
            t = t.replaceFirst(s.substring(i, i+1), "-");
            s = s.replaceFirst(s.substring(i, i+1), "-");
        }
        return s.equals(t);
    }


}
