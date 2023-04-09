package BaekJoon;
// 트리의 부모 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek11725 {
    public static int N;
    public static ArrayList<Integer>[] graph;
    public static int[] parentNode;
    public static boolean[] visit;
    public static Queue<Integer> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parentNode = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        visit[1] = true;
        bfsQ.add(1);

        while (!bfsQ.isEmpty()) {
            int currV = bfsQ.poll();
            for (int i = 0; i < graph[currV].size(); i++) {
                int nextV = graph[currV].get(i);
                if (!visit[nextV]) {
                    bfsQ.add(nextV);
                    visit[nextV] = true;
                    parentNode[nextV] = currV;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parentNode[i]);
        }
    }
}
