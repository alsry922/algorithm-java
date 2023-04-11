package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;
//가장 가까운 점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise4 {
    static class Pair implements Comparable<Pair> {
        int x, y, len;

        Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        @Override
        public int compareTo(Pair pair) {
            if (len == pair.len) {
                if (x == pair.x) {
                    return y - pair.y;
                } else {
                    return x - pair.x;
                }
            }
            return len - pair.len;
        }
    }

    public static int N, M; //점의 갯수, 작업 횟수
    public static int[] xNums;
    public static int[] yNums;
    public static PriorityQueue<Pair> positions = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        xNums = new int[N];
        yNums = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xNums[i] = x;
            yNums[i] = y;
            positions.add(new Pair(x, y, x + y));
        }

        for (int i = 0; i < M; i++) {
            Pair min = positions.poll();
            int x = min.x + 2;
            int y = min.y + 2;
            positions.add(new Pair(x, y, x + y));
        }

        Pair min = positions.peek();
        System.out.println(min.x + " " + min.y);
    }
}
