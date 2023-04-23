package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수들의 합 최대화하기
public class Exercise3 {
    public static int N; //격자 크기
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static int[][] grid;
    public static boolean[][] painted;
    public static int answer = INT_MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        painted = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMaxValue(0, 0);
        System.out.println(answer);
    }

    private static void findMaxValue(int row, int sum) {
        if (row == N) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (possible(row, i)) {
                painted[row][i] = true;
                findMaxValue(row + 1, sum + grid[row][i]);
                painted[row][i] = false;
            }
        }
    }

    private static boolean possible(int x, int y) {
        if (x == 0) {
            return true;
        }
        for (int i = x - 1; i >= 0; i--) {
            if (painted[i][y]) {
                return false;
            }
        }
        return true;
    }
}
