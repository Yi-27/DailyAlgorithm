/**
 * @author: Yi-27
 * @projectName: AlgorithmExercises
 * @create: 2020-12-09 8:56
 * @Description:
 * 62. 不同路径
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(25, 9));
    }

    public static int uniquePaths2(int m, int n) { // 10518300
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        /*
        这两行的目的是
        假设为7,3的地盘，就变为
        1 1 1 1 1 1 1
        1
        1
        这些1为边界点，也是到这些1点的行走方案
        那么再往下执行代码就变成
        1 1 1 1  1  1  1
        1 2 3 4  5  6  7
        1 3 6 10 15 21 28
        即(2,2)这个点的方案数，就等于到(1,2)和(2,1)的方案数之和
        其他等同
        这有点类似于杨辉三角
        */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1]; // 返回右下角在数组中的值即为结果
    }

    public static int uniquePaths(int m, int n) {
        // 先一直向右，右边没路了，再回退一格然后向下，再接着向右
        // 起始点是1,1;终止点是m,n
        int ret = 0;

        return ret + go(1, 1, m, n);
    }

    public static int go(int x, int y, int m, int n){
        int ret = 0;
        if(x == m && y == n){
            return 1;
        }else{
            if(x+1 <= m) ret += go(x+1, y, m, n);
            if(y+1 <= n) ret += go(x, y+1, m, n);
        }
        return ret;
    }
}
