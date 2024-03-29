package INTERMEDIATE_LOW.DFS.DFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//그래프 탐색
public class Exercise1 {
  public static int N, M; //정점 갯수, 간선 갯수
  public static ArrayList<Integer>[] graph;
  public static boolean[] visited;
  public static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph[start].add(end);
      graph[end].add(start);
    }

    visited[1] = true;
    dfs(1);
    System.out.println(answer);
  }

  private static void dfs(int currV) {
    for (int i = 0; i < graph[currV].size(); i++) {
      int nextV = graph[currV].get(i);
      if (!visited[nextV]) {
        visited[nextV] = true;
        answer++;
        dfs(nextV);
      }
    }
  }
}