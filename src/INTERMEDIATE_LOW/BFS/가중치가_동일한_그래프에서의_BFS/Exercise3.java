package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//비를 피하기
public class Exercise3 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, H, M; //격자 크기, 사람 수, 피할 수 있는 공간 수
    public static int DIR_NUM = 4;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;
    public static int[][] answer;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static ArrayList<Pair> starts = new ArrayList<>();
    public static ArrayList<Pair> ends = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        step = new int[N][N];
        answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    starts.add(new Pair(i, j));
                    answer[i][j] = -1;
                }
                if (grid[i][j] == 3) {
                    ends.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < starts.size(); i++) {
            initVisited();
            initStep();
            BFS(starts.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void initStep() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                step[i][j] = 0;
            }
        }
    }

    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void BFS(Pair pair) {
        bfsQ.add(pair);
        while (!bfsQ.isEmpty()) {
            Pair curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;

            for (int i = 0; i < DIR_NUM; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    push(nx, ny, step[cx][cy]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ends.size(); i++) {
            Pair end = ends.get(i);
            if (visited[end.x][end.y]) {
                min = Math.min(min, step[end.x][end.y]);
            }
        }
        if (min != Integer.MAX_VALUE) {
            answer[pair.x][pair.y] = min;
        }
    }

    private static void push(int nx, int ny, int dist) {
        visited[nx][ny] = true;
        step[nx][ny] = dist + 1;
        bfsQ.add(new Pair(nx, ny));
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] != 1;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
