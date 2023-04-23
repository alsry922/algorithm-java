package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//n개의 점 중 m개 고르기
public class test1 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M; //점 갯수, 선택할 갯수
    public static Pair[] coords;
    public static ArrayList<Pair> select = new ArrayList<>();
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int answer = INT_MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coords = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i] = new Pair(x, y);
        }
        findMinOfMaxDist(0, 0);
        System.out.println(answer == INT_MAX ? -1 : answer);
    }

    private static void findMinOfMaxDist(int idx, int cnt) {
        if (cnt == M) {
            answer = Math.min(answer, calc());
            return;
        }
        if (idx == N) {
            return;
        }

        select.add(coords[idx]);
        findMinOfMaxDist(idx + 1, cnt + 1);
        select.remove(select.size() - 1);
        findMinOfMaxDist(idx + 1, cnt);
    }

    private static int calc() {
        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                Pair a = select.get(i);
                Pair b = select.get(j);
                int dist = (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
                maxResult = Math.max(maxResult, dist);
            }
        }
        return maxResult;
    }
}
