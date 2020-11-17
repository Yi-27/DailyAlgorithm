import java.util.*;

/**
 * @author: Yi-27
 * @projectName: LearnJavaWeb
 * @create: 2020-11-15 11:14
 * @Description:
 */
public class ClosedString {

    public static boolean closeStrings(String word1, String word2) {
        if(word1 == null || word2 == null || word1.length() != word2.length())
            return false;

        Map<Character, Integer> wordMap1 = new HashMap<>();
        Map<Character, Integer> wordMap2 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++){
            if(!wordMap1.containsKey(word1.charAt(i))){
                wordMap1.put(word1.charAt(i), 1);
            }else{
                wordMap1.put(word1.charAt(i), wordMap1.get(word1.charAt(i))+1);
            }
        }

        for(int i = 0; i < word2.length(); i++){
            if(!wordMap1.containsKey(word2.charAt(i))){
                return false;
            }

            if(!wordMap2.containsKey(word2.charAt(i))){
                wordMap2.put(word2.charAt(i), 1);
            }else{
                wordMap2.put(word2.charAt(i), wordMap2.get(word2.charAt(i))+1);
            }
        }
        for(int i = 0; i < word1.length(); i++) {
            if (!wordMap2.containsKey(word1.charAt(i))) {
                return false;
            }
        }

        Collection<Integer> values = wordMap1.values();
        Collection<Integer> values2 = wordMap2.values();
        List<Integer> l1 = new ArrayList<>();
        l1.addAll(values);
        List<Integer> l2 = new ArrayList<>();
        l2.addAll(values2);
        Collections.sort(l1);
        Collections.sort(l2);
        System.out.println(l1);
        System.out.println(l2);
        if(!l1.equals(l2)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
}
