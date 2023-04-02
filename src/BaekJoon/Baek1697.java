package BaekJoon;
//숨바꼭질

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1697 {
    public static int MAX = 100000;
    public static int n, k; // 수빈, 동생
    public static int[] graph = new int[MAX + 1];
    public static boolean[] visit = new boolean[MAX + 1];
    public static Queue<Integer> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfsQ.add(n);
        visit[n] = true;

        while (!bfsQ.isEmpty()) {
            int currV = bfsQ.poll();

            int[] dir = {-1, 1, currV};
            for (int i = 0; i < 3; i++) {
                int nextV = currV + dir[i];
                if (isLinked(nextV)) {
                    graph[nextV] = graph[currV] + 1;
                    visit[nextV] = true;
                    bfsQ.add(nextV);
                }
            }
            /*graph의 해당 정점을 방문한 적이 있음*/
            if (visit[k])
                break;
        }

        System.out.println(graph[k]);
    }

    private static boolean isLinked(int v) {
        return isInRange(v) && !visit[v];
    }

    private static boolean isInRange(int v) {
        return v >= 0 && v <= MAX;
    }
}
