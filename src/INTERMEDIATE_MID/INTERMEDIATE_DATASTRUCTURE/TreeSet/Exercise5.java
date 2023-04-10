package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 최대 숫자 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise5 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            int input = Integer.parseInt(st.nextToken());
            treeSet.remove(input);
            System.out.println(treeSet.last());
        }
    }
}
