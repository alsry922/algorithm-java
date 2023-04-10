package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
//자리 차지하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise8 {
    public static int n, m;
    public static TreeSet<Integer> treeSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (treeSet.floor(input) == null) {
                break;
            }
            treeSet.remove(treeSet.floor(input));
            cnt++;
        }
        System.out.println(cnt);
    }
}
