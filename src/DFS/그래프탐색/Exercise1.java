package DFS.그래프탐색;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Exercise1 {
//  static final int MAX_N = 1000;
//  static int n; //    정점 수
//  static int m; //    간선 수
//  static ArrayList<Integer>[] graph = new ArrayList[MAX_N + 1];    // 인접리스트
//  static boolean[] visited = new boolean[MAX_N + 1];    // 방문 정보
//  static int answer = 0;    // 도달 가능 정점의 갯수
//
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    n = Integer.parseInt(st.nextToken());
//    m = Integer.parseInt(st.nextToken());
//    /*인접 리스트 초기화*/
//    for (int i = 1; i <= n; i++) {
//      graph[i] = new ArrayList<>();
//    }
//    for (int i = 0; i < m; i++) {
//      st = new StringTokenizer(br.readLine());
//      int start = Integer.parseInt(st.nextToken());
//      int end = Integer.parseInt(st.nextToken());
//      graph[start].add(end);
//      graph[end].add(start);
//    }
//    /*1번 정점부터 dfs 시작*/
//    visited[1] = true;
//    dfs(1);
//    System.out.println(answer);
//  }
//
//  public static void dfs(int curVtx) {
//    /*방문한 곳은 방문하지 않는다.*/
//    for (int i = 0; i < graph[curVtx].size(); i++) {
//      int nextVtx = graph[curVtx].get(i);
//      if (!visited[nextVtx]) {
//        visited[nextVtx] = true;
//        answer++;
//        dfs(nextVtx);
//      }
//    }
//  }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
  static final int MAX_N = 1000;
  static int n; //    정점 수
  static int m; //    간선 수
  static int[][] graph = new int[MAX_N + 1][MAX_N+1];    // 인접 행렬
  static boolean[] visited = new boolean[MAX_N + 1];    // 방문 정보
  static int answer = 0;    // 도달 가능 정점의 갯수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    /*인접 행렬 초기화*/
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph[start][end] = 1;
      graph[end][start] = 1;
    }
    /*1번 정점부터 dfs 시작*/
    visited[1] = true;
    dfs(1);
    System.out.println(answer);
  }

  public static void dfs(int curVtx) {
    /*방문한 곳은 방문하지 않는다.*/
    for (int nextVtx = 1; nextVtx <= n; nextVtx++) {
      if (graph[curVtx][nextVtx] == 1 && !visited[nextVtx]) {
        visited[nextVtx] = true;
        answer++;
        dfs(nextVtx);
      }
    }
  }
}