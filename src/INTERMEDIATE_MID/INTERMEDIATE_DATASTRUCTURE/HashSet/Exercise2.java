package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
// 데이터 비교

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int n, m; //각 수열의 원소 갯수
    public static int[] seq1, seq2;
    public static HashSet<Integer> hashSet1 = new HashSet<>();
    public static HashSet<Integer> hashSet2 = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        seq1 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq1[i] = Integer.parseInt(st.nextToken());
            hashSet1.add(seq1[i]);
        }

        m = Integer.parseInt(br.readLine());
        seq2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            seq2[j] = Integer.parseInt(st.nextToken());
            hashSet2.add(seq2[j]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            if (hashSet1.contains(seq2[i])) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
