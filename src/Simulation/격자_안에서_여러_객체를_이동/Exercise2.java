package Simulation.격자_안에서_여러_객체를_이동;
// 숫자의 순차적 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exercise2 {
    public static int n, m;
    public static int[][] grid;
    public static int[][] nextState;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // grid size;
        m = Integer.parseInt(st.nextToken()); // rep;

        grid = new int[n + 1][n + 1];
        nextState = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                grid[i][j] = value;
                nextState[i][j] = value;
            }
        }

        while (m-- > 0) {
            for (int i = 1; i <= (int) Math.pow(n, 2); i++) {
                Pair currPos = new Pair(0, 0);
                Pair maxPos = new Pair(0, 0);
                for (int x = 1; x <= n; x++) {
                    for (int y = 1; y <= n; y++) {
                        if (grid[x][y] == i) {
                            currPos = new Pair(x, y);
                            maxPos =  swapToMaxVal(currPos);
                        }
                    }
                }
                grid[currPos.x][currPos.y] = nextState[currPos.x][currPos.y];
                grid[maxPos.x][maxPos.y] = nextState[maxPos.x][maxPos.y];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static Pair swapToMaxVal(Pair currPos) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0 , 1, 1, 1, 0, -1, -1};
        int max = 0;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < 8; i++) {
            int nextX = currPos.x + dx[i];
            int nextY = currPos.y + dy[i];
            if (isInRange(nextX, nextY)
                    && max != Math.max(max, grid[nextX][nextY])) {
                max = grid[nextX][nextY];
                maxX = nextX;
                maxY = nextY;
            }
        }
        int temp = nextState[currPos.x][currPos.y];
        nextState[currPos.x][currPos.y] = nextState[maxX][maxY];
        nextState[maxX][maxY] = temp;

        return new Pair(maxX, maxY);
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}
