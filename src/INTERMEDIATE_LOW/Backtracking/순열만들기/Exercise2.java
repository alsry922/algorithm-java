package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
// 거꾸로 순열

public class Exercise2 {
    public static int N;
    public static boolean[] visited;
    public static List<Integer> pick = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        findPermutation(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findPermutation(int n) {
        if (n == N) {
            for (int i : pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = N; i > 0; i--) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            pick.add(i);
            findPermutation(n + 1);
            visited[i] = false;
            pick.remove(pick.size() - 1);
        }
    }
}
