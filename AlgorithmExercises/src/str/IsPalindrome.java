package str;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-02 14:13
 * @Description:
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i <= j; i++,j--){
            while(!isNumberOrCharater(s.charAt(i))){
                // 当不是字母和数字时i++
                i++;
            }
            while(!isNumberOrCharater(s.charAt(j))){
                // 当不是字母和数字时j--
                j--;
            }
            if(!s.substring(i,i+1).equalsIgnoreCase(s.substring(j,j+1))) return false;
        }
        return true;
    }

    public static boolean isNumberOrCharater(char c){
        return (c >= 'A' && c <= 'Z') ||
               (c >= 'a' && c <= 'z') ||
               (c >= '0' && c <= '9');
    }
}
