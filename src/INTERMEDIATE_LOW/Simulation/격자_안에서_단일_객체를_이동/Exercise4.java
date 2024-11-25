package INTERMEDIATE_LOW.Simulation.격자_안에서_단일_객체를_이동;

import java.io.*;
import java.util.*;

// 금 채굴하기
public class Exercise4 {
    public static int[][] grid;
    public static int n, m; // 그리드 크기, 금 가격
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxGold = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int k = 0; k <= 2 * (n-1); k++) {
                    int numOfGold = getNumOfGold(row, col, k);
                    if (numOfGold * m >= getCost(k)) {
                        maxGold = Math.max(maxGold, numOfGold);
                    }
                }
            }
        }
        System.out.println(maxGold);
        br.close();
    }

    public static int getNumOfGold(int row, int col, int k) {
        int numOfGold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - row) + Math.abs(j - col) <= k) {
                    numOfGold += grid[i][j];
                }
            }
        }
        return numOfGold;
    }

    public static int getCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }
}
