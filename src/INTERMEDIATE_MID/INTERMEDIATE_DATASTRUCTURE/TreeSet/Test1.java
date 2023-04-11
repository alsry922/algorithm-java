package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
//작지만 큰 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Test1 {
    public static int N, M; //수열의 숫자 갯수, 질의 수
    public static int[] seq;
    public static TreeSet<Integer> treeSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            treeSet.add(seq[i]);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            Integer floor = treeSet.floor(query);
            if (floor != null) {
                treeSet.remove(floor);
            }
            System.out.println(floor == null ? -1 : floor);
        }
    }
}
