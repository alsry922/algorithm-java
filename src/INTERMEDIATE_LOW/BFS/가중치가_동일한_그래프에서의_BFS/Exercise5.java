package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//4가지 연산을 이용하여 1 만들기
public class Exercise5 {
    public static int MAX_N = 1000000;
    public static int N; //숫자
    public static int[] graph = new int[MAX_N + 1];
    public static int[] step = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static Queue<Integer> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph[i] = i;
        }

        visited[graph[1]] = true;
        bfsQ.add(graph[1]);

        while (!bfsQ.isEmpty()) {
            int curr = bfsQ.poll();
            int[] operation = {-1, 1, curr, curr * 2};
            for (int i = 0; i < 4; i++) {
                int nx = curr + operation[i];
                if (canGo(nx)) {
                    visited[nx] = true;
                    step[nx] = step[curr] + 1;
                    bfsQ.add(nx);
                }
            }
        }
        System.out.println(step[N]);
    }

    private static boolean canGo(int nx) {
        return isInRange(nx) && !visited[nx];
    }

    private static boolean isInRange(int nx) {
        return nx >= 0 && nx <= MAX_N;
    }
}
