package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//강력한 폭발
public class Exercise3 {
    public static final int BOMB_TYPE_NUM = 3;
    public static final int MAX_N = 20;

    public static int N; //격자 크기
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] bombed = new int[MAX_N][MAX_N];
    public static int[][] bombType = new int[MAX_N][MAX_N];

    public static List<Pair> bombPos = new ArrayList<>();
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                grid[i][j] = input[j];
                if (grid[i][j] == 1) {
                    bombPos.add(new Pair(i, j));
                }
            }
        }

        findMaxArea(bombPos.size());

        System.out.println(answer);
    }

    public static void findMaxArea(int bombCount) {

        choose(0, bombCount);
    }

    public static void choose(int pickCnt, int bombCount) {
        if (pickCnt == bombCount) {
            int count = simulate();
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            int x = bombPos.get(pickCnt).x;
            int y = bombPos.get(pickCnt).y;
            bombType[x][y] = i;
            choose(pickCnt + 1, bombCount);
            bombType[x][y] = 0;
        }
    }

    public static int simulate() {
        // 폭탄이 터진 위치 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bombed[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bombType[i][j] != 0) {
                    bomb(bombType[i][j], i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bombed[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void bomb(int bombType, int x, int y) {
        Pair[][] bombShapes = {
                {},
                {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0),},
                {new Pair(-1, 0), new Pair(0, 1), new Pair(0, 0), new Pair(1, 0), new Pair(0, -1),},
                {new Pair(-1, 1), new Pair(1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(-1, -1),}
        };

        Pair[] bombAffect = bombShapes[bombType];
        for (int i = 0; i < bombAffect.length; i++) {
            int dx = bombAffect[i].x;
            int dy = bombAffect[i].y;

            int nx = x + dx;
            int ny = y + dy;

            if (isInRange(nx, ny)) {
                bombed[nx][ny] = 1;
            }
        }
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
