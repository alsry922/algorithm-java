package BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex {
  int x;
  int y;

  Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Exercise2 {
  static final int MAX_N = 100;    // 최대 격자 크기
  static int n, k;    // 격자 크기, 탐색 시작점 갯수
  static int[][] grid = new int[MAX_N + 1][MAX_N + 1];    // 격자
  static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
  static Queue<Vertex> queue = new LinkedList<>();
  static int answer = 0;

  /*해당 위치가 유효한 격자 범위 내에 있는지 판단하는 함수
   * @parameter int x: 격자 x 위치
   * @parameter int y: 격자 y 위치
   * @return boolean: 유효한 격자 범위 내에 있다면 true 아니라면 false*/
  public static boolean isInRange(int x, int y) {
    return 1 <= x && x <= n && 1 <= y && y <= n;
  }

  /*
   * 해당 위치의 정점이 유효한지 판단하는 함수로
   * 해당 위치의 정점이 격자 범위 내에 있는지, 방문했는지, 갈 수 있는 정점인지 확인
   * @parameter int x: 격자 x 위치
   * @parameter int y: 격자 y 위치
   * return boolean: 유효하다면 true 아니라면 false*/
  public static boolean canGo(int x, int y) {
    return isInRange(x, y) && !visited[x][y] && grid[x][y] == 0;
  }

  /*
   * 시작 정점으로부터 갈 수 있는 모든 곳을 bfs 탐색 진행하는 함수
   * */
  public static void bfs() {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    /*큐가 빌 때까지 진행*/
    while (!queue.isEmpty()) {
      Vertex currVtx = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = currVtx.x + dx[i];
        int nextY = currVtx.y + dy[i];
        /*다음 정점을 방문할 수 있는 경우에만 다음 정점 방문*/
        if (canGo(nextX, nextY)) {
          visited[nextX][nextY] = true;
          queue.add(new Vertex(nextX, nextY));
          answer++;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    /*격자 초기화*/
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    /*시작 정점으로부터 bfs 시작*/
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      /*이미 방문한 정점이라면 탐색하지 않음*/
      if (!visited[x][y]) {
        visited[x][y] = true;
        queue.add(new Vertex(x, y));
        answer++;
        bfs();
      }
    }
    System.out.println(answer);
  }
}
