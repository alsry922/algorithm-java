package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//수들 중 최솟값 최대화하기
public class test1 {
    public static int N; //격자 크기
    public static int[][] grid;
    public static boolean[] visited;
    public static int answer = -1;
    public static ArrayList<Integer> select = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMaxOfMins(0);
        System.out.println(answer);
    }

    private static void findMaxOfMins(int row) {
        if (row == N) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < select.size(); i++) {
                min = Math.min(select.get(i), min);
            }
            answer = Math.max(answer, min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            select.add(grid[row][i]);
            findMaxOfMins(row + 1);
            visited[i] = false;
            select.remove(select.size() - 1);
        }
    }
}
