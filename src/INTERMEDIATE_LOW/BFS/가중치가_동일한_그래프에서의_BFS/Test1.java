package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//상한 귤
public class Test1 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int DIR_NUM = 4;
    public static int N, K; //격자 크기, 초기 상한 귤의 갯수
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        step = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    bfsQ.add(new Pair(i, j));
                }
            }
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    sb.append(-1).append(" ");
                } else {
                    if (visited[i][j]) {
                        sb.append(step[i][j]).append(" ");
                    } else {
                        sb.append(-2).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS() {
        while (!bfsQ.isEmpty()) {
            Pair curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < DIR_NUM; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    push(nx, ny, step[cx][cy] + 1);
                }
            }
        }
    }

    private static void push(int nx, int ny, int newStep) {
        visited[nx][ny] = true;
        step[nx][ny] = newStep;
        bfsQ.add(new Pair(nx, ny));
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
