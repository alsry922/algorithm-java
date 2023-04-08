package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 숫자 빠르게 찾기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise3 {
    public static int n, m; // 각 수열의 숫자 갯수
    public static int[] seq1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq1 = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq1[i] = Integer.parseInt(st.nextToken());
            treeSet.add(seq1[i]);
        }

        for (int j = 0; j < m; j++) {
            int input = Integer.parseInt(br.readLine());
            if (treeSet.ceiling(input) != null) {
                System.out.println(treeSet.ceiling(input));
            } else {
                System.out.println(-1);
            }
        }
    }
}
