package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
//대칭 차집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class test1 {
    public static int n, m; //집합 A,B 원소 갯수
    public static int[] a, b;
    public static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            hashSet.add(a[i]);
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            b[j] = Integer.parseInt(st.nextToken());
            if (hashSet.contains(b[j])) {
                hashSet.remove(b[j]);
            } else {
                hashSet.add(b[j]);
            }
        }

        System.out.println(hashSet.size());
    }
}
