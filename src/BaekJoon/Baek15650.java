package BaekJoon;
// N과 M (2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15650 {
    public static int n, m;
    public static int[] seq;
    public static ArrayList<Integer> combi = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }

        combination(0, 0);
    }

    private static void combination(int index, int cnt) {
        if (index == n) {
            if (cnt == m) {
                StringBuffer sb = new StringBuffer();
                for (Integer num : combi) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }
            return;
        }

        combi.add(seq[index]);
        combination(index + 1, cnt + 1);
        combi.remove(combi.size() - 1);
        combination(index + 1, cnt);
    }
}
