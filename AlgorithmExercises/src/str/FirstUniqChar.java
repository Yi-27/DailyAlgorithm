package str;

import java.util.LinkedHashMap;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-01 14:11
 * @Description:
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> chars = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(chars.containsKey(s.charAt(i))){
                chars.put(s.charAt(i), -1);
            }else{
                chars.put(s.charAt(i), i);
            }
        }
        for(char c : chars.keySet()){
            if(chars.get(c) != -1){
                return chars.get(c);
            }
        }

        return -1;
    }
}
