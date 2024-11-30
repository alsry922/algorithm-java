package INTERMEDIATE_LOW.DFS.DFS탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//그래프 탐색
public class Exercise1 {
    public static int N, M; //정점 갯수, 간선 갯수
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited[1] = true;
        dfs(1);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int currV) {
        for (int i = 0; i < graph.get(currV).size(); i++) {
            int nextV = graph.get(currV).get(i);
            if (!visited[nextV]) {
                visited[nextV] = true;
                answer++;
                dfs(nextV);
            }
        }
    }
}
