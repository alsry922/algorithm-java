package BFS.가중치가_동일한_그래프에서의_BFS;
import java.util.*;
import java.io.*;

class Vertex2 {
  int x;
  int y;
  Vertex2(int x, int y){
    this.x = x;
    this.y = y;
  }
}

public class Exercise2 {
  static final int MAX_N = 100;
  static int n;    // 격자 크기
  static boolean[][] visited = new boolean[MAX_N+1][MAX_N+1];
  static int[][] step = new int[MAX_N+1][MAX_N+1];
  static Queue<Vertex2> queue = new LinkedList<>();
  public static boolean isInRange(int x, int y) {
    return 1 <= x && x <= n && 1 <= y && y <= n;
  }
  public static boolean canGo(int x, int y) {
    return isInRange(x, y) && !visited[x][y];
  }
  public static void bfs() {
    int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    while (!queue.isEmpty()) {
      Vertex2 currVtx = queue.poll();
      for (int i = 0; i < 8; i++) {
        int nextX = currVtx.x + dx[i];
        int nextY = currVtx.y + dy[i];
        int nextStep = step[currVtx.x][currVtx.y]+1;
        if (canGo(nextX, nextY)) {
          push(nextX,nextY,nextStep);
        }
      }
    }
  }
  public static void push(int nextX, int nextY, int nextStep) {
    visited[nextX][nextY] = true;
    step[nextX][nextY] = nextStep;
    queue.add(new Vertex2(nextX, nextY));
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    int startX = Integer.parseInt(st.nextToken());
    int startY = Integer.parseInt(st.nextToken());
    int endX = Integer.parseInt(st.nextToken());
    int endY = Integer.parseInt(st.nextToken());

    push(startX, startY, 0);
    bfs();
    System.out.println(visited[endX][endY] ? step[endX][endY] : -1);
  }
}
