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
    public static List<Pair> bombPos = new ArrayList<>();
    public static List<Integer> pickBomb = new ArrayList<>();
    public static int maxArea = 0;
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
                    bombPos.add(new Pair(i, j));
                }
            }
        }

        choose(0);
        System.out.println(maxArea);
        br.close();
        bw.close();
    }

    public static void choose(int n) {
        if (n == bombPos.size()) {
            int area = getArea();
            maxArea = Math.max(area, maxArea);
            initBombed();
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

    public static int getArea() {
        for (int i = 0; i < bombPos.size(); i++) {
            int bombType = pickBomb.get(i);
            Pair pos = bombPos.get(i);
            simulate(bombType, pos.x, pos.y);
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bombed[i][j] == 1) {
                    area += 1;
                }
            }
        }

        return area;
    }

    public static void simulate(int bombType, int x, int y) {
        if (bombType == 1) {
            Pair[] area = {
                    new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)};
            for (int i = 0; i < area.length; i++) {
                int nx = x + area[i].x;
                int ny = y + area[i].y;
                if (isInRange(nx, ny)) {
                    bombed[nx][ny] = 1;
                }
            }
        } else if (bombType == 2) {
            Pair[] area = {
                    new Pair(-1, 0), new Pair(0, 1), new Pair(0, 0), new Pair(1, 0), new Pair(0, -1)
            };
            for (int i = 0; i < area.length; i++) {
                int nx = x + area[i].x;
                int ny = y + area[i].y;
                if (isInRange(nx, ny)) {
                    bombed[nx][ny] = 1;
                }
            }
        } else {
            Pair[] area = {
                    new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, 1), new Pair(1, -1)
            };
            for (int i = 0; i < area.length; i++) {
                int nx = x + area[i].x;
                int ny = y + area[i].y;
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
