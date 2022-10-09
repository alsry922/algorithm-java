package BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.*;
import java.io.*;

class Vertex {
  int x;
  int y;

  public Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Exercise1 {
  static final int MAX_N = 100, MAX_M = 100;
  static int n, m;    // 격자 크기
  static int[][] grid = new int[MAX_N][MAX_M];    // 격자
  static boolean[][] visited = new boolean[MAX_N][MAX_M];    // 방문 정점
  static int[][] step = new int[MAX_N][MAX_M];    // 특정 시작 정점으로부터 각 정점까지의 최단거리
  static Queue<Vertex> queue = new LinkedList<>();    // bfs에 사용할 큐

  public static boolean isInRange(int x, int y) {
    return 0 <= x && x < n && 0 <= y && y < m;
  }
  public static boolean canGo(int x, int y) {
    return isInRange(x, y) && !visited[x][y] && grid[x][y] == 1;
  }
  /*갈 수 있는 정점을 찾아 방문 표시하고 그 정점의 step배열에 +1을 해주는 함수*/
  public static void bfs() {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    while(!queue.isEmpty()) {
      Vertex currVtx = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = currVtx.x + dx[i];
        int nextY = currVtx.y + dy[i];
        if (canGo(nextX, nextY)) {
          visited[nextX][nextY] = true;
          step[nextX][nextY] = step[currVtx.x][currVtx.y]+1;
          queue.add(new Vertex(nextX,nextY));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    /*grid 초기화*/
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    /*(0,0)정점에서부터 bfs 시작*/
    visited[0][0] = true;
    step[0][0] = 0;
    queue.add(new Vertex(0, 0));
    bfs();
    System.out.println(step[n-1][m-1] > 0 ? step[n-1][m-1] : -1);
  }
}
