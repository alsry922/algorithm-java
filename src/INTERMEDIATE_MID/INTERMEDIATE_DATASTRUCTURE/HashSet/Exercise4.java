package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
// 정수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise4 {
    public static int n, m; //각 수열의 원소 갯수
    public static int[] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> hashSet1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet1.add(arr1[i]);
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            if (hashSet1.contains(arr2[i])) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
