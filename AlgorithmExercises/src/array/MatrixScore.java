package array;

import java.util.Arrays;

/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-07 8:42
 * @Description:
 */
public class MatrixScore {

    public static void main(String[] args) {
        int[][] A = new int[3][4];

        System.out.println(matrixScore(A));
    }
    public static int matrixScore(int[][] A) {
        // 1.反转行使得，第一列都为1
        for(int[] a : A){
            if(a[0] != 1){
                lineFlip(a);
            }
        }

        // 从第二列开始，判断列中0和1的数量
        // 0的数量大于1的数据就要进行翻转
        for(int i = 1; i< A[0].length; i++){
            int zeros = 0; // 用于记录0的个数
            int ones = 0; // 用于记录1的个数
            boolean flip = false;
            for(int[] a : A){
                if(a[i] == 0){
                    if(++zeros > a.length/2){
                        flip = true; // 要反转
                        break;
                    }
                }else{
                    if(++ones > a.length/2) break;
                }
            }

            if(flip) columnFlip(A, i);
        }
        int ret = 0;
        for(int[] a : A){
            StringBuilder binaryStr = new StringBuilder();
            for(int num : a){
                binaryStr.append(num);
            }
            ret += Integer.parseInt(binaryStr.toString(), 2);
        }
        return ret;
    }

    public static void lineFlip(int[] line){
        for(int i = 0; i < line.length; i++){
            if(line[i] == 0) line[i] = 1;
            else line[i] = 0;
        }
    }

    public static void columnFlip(int[][] A, int i){
        for(int[] a : A){
            if(a[i] == 0) a[i] = 1;
            else a[i] = 0;
        }
    }
}
