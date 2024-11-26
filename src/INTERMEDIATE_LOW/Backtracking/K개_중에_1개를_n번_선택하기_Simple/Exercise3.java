package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
//강력한 폭발
public class Exercise3 {
    public static int N; //격자 크기
    public static int[][] grid;
    public static int[][] bombed;
    public static List<Integer> xs = new ArrayList<>();
    public static List<Integer> ys = new ArrayList<>();
    public static List<Integer> pickBomb = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        bombed = new int[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        choose(0);
    }

    public static void choose(int n) {
        if (n == xs.size()) {
            // 영향 받은 갯수 세기
            initBombed();
            bomb();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            pickBomb.add(i);
            choose(n + 1);
            pickBomb.remove(pickBomb.size() - 1);
        }
    }

    public static void initBombed() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bombed[i][j] = 0;
            }
        }
    }

    public static void bomb() {
        for (int i = 0; i < xs.size(); i++) {
            int bombType = pickBomb.get(i);
            int x = xs.get(i);
            int y = ys.get(i);
            bombRange(bombType, x, y);
        }
    }

    public static void bombRange(int bombType, int x, int y) {
        bombed[x][y] = 1;
        if (bombType == 1) {
            int[] dx = {-1, 1};
            int[] dy = {0, 0};
            for (int i = 0; i < dx.length; i++) {
                for (int j = 0; j < 2; j++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isInRange(nx, ny)) {
                        bombed[nx][ny] = 1;
                    }
                }
            }
        } else if (bombType == 2) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInRange(nx, ny)) {
                    bombed[nx][ny] = 1;
                }
            }
        }
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
