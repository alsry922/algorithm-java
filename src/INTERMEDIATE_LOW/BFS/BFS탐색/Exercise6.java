package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//우리는 하나
public class Exercise6 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, K, U, D; //격자 크기, 고를 도시의 수, u이상, d이하 방문가능
    public static int DIR_NUM = 4;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Pair[] cities;
    public static ArrayList<Pair> selected = new ArrayList<>();
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N][N];
        cities = new Pair[N * N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                grid[i][j] = input;
                cities[idx++] = new Pair(i, j);
            }
        }

        selectCity(0, 0);
        System.out.println(answer);
    }

    private static void selectCity(int idx, int cnt) {
        if (cnt > K) {
            return;
        }
        if (idx == N * N) {
            if (cnt == K) {
                BFS();
            }
            return;
        }

        selected.add(cities[idx]);
        selectCity(idx + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        selectCity(idx + 1, cnt);
    }

    private static void BFS() {
        initVisited();

        int visitCnt = 0;

        for (int i = 0; i < selected.size(); i++) {
            Pair pair = selected.get(i);
            bfsQ.add(pair);
            visited[pair.x][pair.y] = true;
            visitCnt++;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!bfsQ.isEmpty()) {
            Pair curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < DIR_NUM; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(cx, cy, nx, ny)) {
                    visited[nx][ny] = true;
                    visitCnt++;
                    bfsQ.add(new Pair(nx, ny));
                }
            }
        }
        answer = Math.max(answer, visitCnt);
    }

    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean canGo(int cx, int cy, int nx, int ny) {
        if (!isInRange(nx, ny)) {
            return false;
        }
        int height = Math.abs(grid[cx][cy] - grid[nx][ny]);

        return !visited[nx][ny] && height >= U && height <= D;

    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
