package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 차이가 가장 작은 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise9 {
    public static int n, m;
    public static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            treeSet.add(seq[i]);
        }

        for (int i = 0; i < n; i++) {
            int current = seq[i];
            if (treeSet.ceiling(current + m) != null) {
                answer = Math.min(answer, treeSet.ceiling(current + m) - current);
            }
            if (treeSet.floor(current - m) != null) {
                answer = Math.min(answer, current - treeSet.floor(current - m));
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
