package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-08 9:04
 * @Description:
 * 842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {

    List<Integer> res;
    public List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        return dfs(0, S, 0, 0, 0) ? res : new ArrayList<>();
    }

    /**
     *
     * @param cur: 当前指向字符串字符的位置
     * @param s：字符串
     * @param preLastLast： 前前数字
     * @param preLast： 前数字
     * @param deep： 当前是第几个数字
     * @return 可拆分成斐波那契数列就返回true
     */
    public boolean dfs(int cur, String s, int preLastLast, int preLast, int deep){
        int len = s.length(); // 字符串长度
        if(cur == len) return deep >= 3; // 如果当前的指向的字符已经是字符串长度，字符串不够三个数字就return false

        // Integer.MAX_VALUE = 2147483647 最多10位数
        for(int i = 1; i <= 10; i++){ // i是控制字符串从cur往后切割出数字的长度的，最多10位数
            // 判断切割时是否会超出字符串的范围
            // 并且不能以0开头，但是可以是单独的0这样的数字，不能01。0123这样，所以要i > 1
            if(cur + i > len || (s.charAt(cur) == '0' && i > 1)) break;
            // 截取字符串
            String sub = s.substring(cur, cur + i);

            long numL = Long.parseLong(sub); // 转成长整型，防止溢出

            // 判断是否超出Integer.MAXVALUE
            // 或者，deep不是0或1
            // 或者大于 前前数字 和 前数字的 和
            if(numL > Integer.MAX_VALUE || (deep != 0 && deep != 1 && numL >(preLastLast + preLast))) break;

            // 到这说明，截取的字符串转成的数字没有整形溢出，所以直接转成整形
            Integer numI = (int) numL;

            // 当当前数是第一个数或者第二个数时，或者前两个数之和等于当前截取得到的数
            // 都要将当前数放进返回list中，并准备截取下一个数
            if(deep == 0 || deep == 1 || numI.equals(preLastLast + preLast)){
                res.add(numI);

                // 这是下一个数字字符串的起始字符是cur+i
                // 下一个数字的lastlast是当前的last，下一个数字的last是当前数字
                // 同时让deep加1，表示res中已有几个数字
                // 满足条件就往下 递归截取
                if(dfs(cur+i, s, preLast, numI, deep+1)) return true;
                // 当截取的数字不满足条件时
                // 比如 下一个数字无论怎么截取都不等于它的前两个数字之和时，会返回false
                // 这时就要使得当前这层递归的当前数字从返回list中移除当前数字
                // 这也就是回溯。
                res.remove(numI);

                /*
                举个例子，字符串为：113243，返回为list
                对于程序来说，就是
                    上来第一个for将 1 放进list
                        第二个for将 1 放进list
                    这时dfs(2, 113243, 1, 1, 2)
                    那么开始第三个for，截取3，不满1 + 1 == 3，截取32不行，324,3243都不行，for循环结束，返回false
                        返回第二个for的中，先将1移除list，再跳到for的下一个循环中
                        即第二个for的i++为2，截取13，放进list
                    这时dfs(3, 113243, 1, 13, 2)
                    开始新的第三个for，截取2，不行截取24不行，截取243不行，for循环结束，返回false
                    。。。
                    第二个for截取一遍后都无法满足条件，就返回false
                    第一个for移除第一个1，进入其下一个i，截取11，再开启新的第二个for循环
                    。。。
                    依次类推
                 */
            }
        }
        return false;
    }
}
