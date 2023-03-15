package Simulation.격자_안에서_단일_객체를_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exercise1 {
    public static int N; //격자 크기
    public static int[][] grid; //격자
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Pair curPair;
    public static List<Integer> visited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        curPair = new Pair(r-1, c-1);
        visited.add(grid[curPair.x][curPair.y]);

        while (true) {
            boolean moved = moveToNextVal();

            if (!moved) break;

            visited.add(grid[curPair.x][curPair.y]);
        }

        for (Integer ele : visited) {
            sb.append(ele).append(" ");
        }

        System.out.println(sb);
    }

    public static boolean moveToNextVal() {
        int currVal = grid[curPair.x][curPair.y];
        for (int i = 0; i < 4; i++) {
            int nextR = curPair.x + dx[i];
            int nextC = curPair.y + dy[i];
            if (isInRange(nextR, nextC) && currVal < grid[nextR][nextC]) {
                curPair = new Pair(nextR, nextC);
                return true;
            }
        }
        return false;
    }

    public static boolean isInRange(int nextR, int nextC) {
        return nextR >= 0 && nextR < N && nextC >= 0 && nextC < N;
    }
}
