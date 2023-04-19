package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//강력한 폭발
public class Exercise3 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int DIR_NUM = 4;
    public static int N; //격자 크기
    public static int[][] grid;
    public static boolean[][] popped;
    public static ArrayList<Integer> bombTypes = new ArrayList<>();
    public static ArrayList<Pair> bombs = new ArrayList<>();
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        popped = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    bombs.add(new Pair(i, j));
                }
            }
        }

        chooseBombTypes(0);
        System.out.println(answer);
    }

    private static void chooseBombTypes(int cnt) {
        if (cnt == bombs.size()) {
            answer = Math.max(answer, calc());
            initPopped();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            bombTypes.add(i);
            chooseBombTypes(cnt + 1);
            bombTypes.remove(bombTypes.size() - 1);
        }
    }

    private static void initPopped() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                popped[i][j] = false;
            }
        }
    }

    private static int calc() {
        int[][] bombTypeOne = {{-2, -1, 1, 2}, {0, 0, 0, 0}};
        int[][] bombTypeTwo = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        int[][] bombTypeThree = {{-1, -1, 1, 1}, {-1, 1, -1, 1}};

        for (int i = 0; i < bombs.size(); i++) {
            Pair bomb = bombs.get(i);
            int x = bomb.x, y = bomb.y;
            popped[x][y] = true;
            int bombType = bombTypes.get(i);
            if (bombType == 1) {
                bomb(x, y, bombTypeOne);
            } else if (bombType == 2) {
                bomb(x, y, bombTypeTwo);
            } else {
                bomb(x, y, bombTypeThree);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (popped[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

    private static void bomb(int x, int y, int[][] bombType) {
        for (int i = 0; i < DIR_NUM; i++) {
            int nx = x + bombType[0][i];
            int ny = y + bombType[1][i];
            if (canPop(nx, ny)) {
                popped[nx][ny] = true;
            }
        }
    }

    private static boolean canPop(int nx, int ny) {
        return isInRange(nx, ny) && !popped[nx][ny];
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
