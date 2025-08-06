import java.util.*;

public class MatrixCalculator {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] add = new int[2][2];
        int[][] mul = new int[2][2];
        int[][] transpose = new int[2][2];
        int max = a[0][0], min = a[0][0];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                add[i][j] = a[i][j] + b[i][j];
                for (int k = 0; k < 2; k++) mul[i][j] += a[i][k] * b[k][j];
                transpose[j][i] = a[i][j];
                if (a[i][j] > max) max = a[i][j];
                if (a[i][j] < min) min = a[i][j];
            }
        System.out.println("加法:");
        for (int[] row : add) System.out.println(Arrays.toString(row));
        System.out.println("乘法:");
        for (int[] row : mul) System.out.println(Arrays.toString(row));
        System.out.println("轉置:");
        for (int[] row : transpose) System.out.println(Arrays.toString(row));
        System.out.println("最大: " + max);
        System.out.println("最小: " + min);
    }
}
