package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소 경로로 탈출하기
public class Exercise1 {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static int[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        step = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited[0][0] = true;
        queue.add(new Node(0, 0));
        bfs();

        bw.write(visited[N - 1][M - 1] ? String.valueOf(step[N - 1][M - 1]) : String.valueOf(-1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.x, y = node.y;
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canMove(nx, ny)) {
                    visited[nx][ny] = true;
                    step[nx][ny] = step[x][y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean canMove(int x, int y) {
        if (!inRange(x, y)) return false;

        return !visited[x][y] && grid[x][y] == 1;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
