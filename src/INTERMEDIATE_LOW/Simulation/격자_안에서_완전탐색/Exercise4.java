package INTERMEDIATE_LOW.Simulation.격자_안에서_완전탐색;
// 금 채굴하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4 {
    public static int n, m; //grid size, gold price
    public static int limit; //중심점으로부터 최대 길이
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        limit = 2 * (n - 1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= limit; k++) {
                    int cost = k * k + (k + 1) * (k + 1);
                    int numOfGold = getNumOfGold(i, j, k);
                    if (numOfGold * m >= cost) {
                        answer = Math.max(answer, numOfGold);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int getNumOfGold(int centerX, int centerY, int length) {
        int income = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(Math.abs(centerX - i) + Math.abs(centerY - j) <= length)) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    income++;
                }
            }
        }
        return income;
    }
}
