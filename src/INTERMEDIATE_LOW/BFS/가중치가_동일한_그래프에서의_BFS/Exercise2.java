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

// 나이트
public class Exercise2 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N; //격자 크기
    public static int[][] step;
    public static boolean[][] visited;
    public static Pair start, dest;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        step = new int[N][N];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        start = new Pair(input[0]-1, input[1]-1);
        dest = new Pair(input[2]-1, input[3]-1);

        push(start.x, start.y, 0);
        bfs();

        if (visited[dest.x][dest.y]) {
            bw.write(String.valueOf(step[dest.x][dest.y]));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void push(int x, int y, int count) {
        visited[x][y] = true;
        step[x][y] = count;
        bfsQ.add(new Pair(x, y));
    }

    public static void bfs() {
        int[] dx = {-2, -1, 1, 2,  2,  1, -1, -2};
        int[] dy = {1,  2,  2, 1, -1, -2, -2, -1};
        while (!bfsQ.isEmpty()) {
            Pair p = bfsQ.poll();
            int x = p.x, y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canMove(nx, ny)) {
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }

    public static boolean canMove(int x, int y) {
        if (!inRange(x, y)) return false;

        return !visited[x][y];
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
