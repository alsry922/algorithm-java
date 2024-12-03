package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 갈 수 있는 곳들
public class Exercise2 {
    static class Vertex {
        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, K; // 격자 크기, 시작점 갯수
    public static int[][] grid;
    public static boolean[][] visited;
    public static List<Vertex> startVertex = new ArrayList<>();
    public static Queue<Vertex> queue = new LinkedList<>();
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            visited[x][y] = true;
            answer++;
            queue.add(new Vertex(x, y));
        }

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Vertex currV = queue.poll();
            int cx = currV.x;
            int cy = currV.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canMove(nx, ny)) {
                    visited[nx][ny] = true;
                    answer++;
                    queue.add(new Vertex(nx, ny));
                }
            }
        }
    }

    public static boolean canMove(int x, int y) {
        if (!inRange(x, y)) return false;

        return !visited[x][y] && grid[x][y] == 0;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}

