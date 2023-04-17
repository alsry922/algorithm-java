package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static int[] posX;
    public static int[] posY;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        step = new int[N][N];
        visited = new boolean[N][N];
        posX = new int[2];
        posY = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        posX[0] = Integer.parseInt(st.nextToken())-1;
        posY[0] = Integer.parseInt(st.nextToken())-1;
        posX[1] = Integer.parseInt(st.nextToken())-1;
        posY[1] = Integer.parseInt(st.nextToken())-1;

        visited[posX[0]][posY[0]] = true;
        bfsQ.add(new Pair(posX[0], posY[0]));

        int[] dx = {2,  2,  1, 1, -1, -1, -2, -2};
        int[] dy = {-1, 1, -2, 2, -2,  2, -1,  1};

        while (!bfsQ.isEmpty()) {
            Pair pair = bfsQ.poll();
            int cx = pair.x;
            int cy = pair.y;
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    push(nx, ny, step[cx][cy] + 1);
                }
            }
        }

        System.out.println(visited[posX[1]][posY[1]] ? step[posX[1]][posY[1]] : -1);

    }

    private static void push(int nx, int ny, int dist) {
        visited[nx][ny] = true;
        step[nx][ny] = dist;
        bfsQ.add(new Pair(nx, ny));
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny];
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}