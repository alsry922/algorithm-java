package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//외판원 순회
public class Exercise4 {
    public static int N; //격자 크기
    public static int[][] grid;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMinCost(1, 0, 0);
        System.out.println(answer);
    }

    private static void findMinCost(int row, int cnt, int cost) {
        if (cnt == N-1) {
            if (grid[row][1] != 0) {
                cost += grid[row][1];
                answer = Math.min(answer, cost);
            }
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (!visited[i] && grid[row][i] != 0) {
                visited[i] = true;
                findMinCost(i, cnt+1, cost+grid[row][i]);
                visited[i] = false;
            }
        }
    }
}
