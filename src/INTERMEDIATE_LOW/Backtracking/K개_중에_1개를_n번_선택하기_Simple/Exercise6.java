package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//2명의 도둑
public class Exercise6 {
    public static int N, M, C; //방 크기, 훔치는 열의 수, 무게
    public static int[][] grid;
    public static int[][] bestVal;
    public static int maxVal;
    public static int answer = -1;
    public static ArrayList<Integer> select = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        bestVal = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bestVal[i][j] = -1;
            }
        }

        for (int x1 = 0; x1 < N; x1++) {
            for (int y1 = 0; y1 < N; y1++) {
                for (int x2 = 0; x2 < N; x2++) {
                    for (int y2 = 0; y2 < N; y2++) {
                        if (possible(x1, y1, x2, y2)) {
                            answer = Math.max(answer, findMax(x1, y1) + findMax(x2, y2));
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int findMax(int x, int y) {
        if (bestVal[x][y] != -1) {
            return bestVal[x][y];
        }

        select.clear();
        for (int i = y; i < y + M; i++) {
            select.add(grid[x][i]);
        }

        maxVal = 0;
        findMaxSum(0, 0, 0);
        bestVal[x][y] = maxVal;
        return maxVal;
    }

    private static void findMaxSum(int idx, int currWeight, int currVal) {
        if (idx == select.size()) {
            if (currWeight <= C) {
                maxVal = Math.max(maxVal, currVal);
            }
            return;
        }

        findMaxSum(idx + 1, currWeight, currVal);
        findMaxSum(idx + 1,
                currWeight + select.get(idx),
                currVal + select.get(idx) * select.get(idx));
    }

    private static boolean possible(int x1, int y1, int x2, int y2) {
        if (!((y1 + M - 1) < N &&
                (y2 + M - 1) < N)) {
            return false;
        }

        if (x1 != x2) {
            return true;
        }

        if (overlap(y1, y1 + M - 1, y2, y2 + M - 1)) {
            return false;
        }

        return true;
    }

    private static boolean overlap(int a, int b, int c, int d) {
        return !((b < c) || (d < a));
    }
}
