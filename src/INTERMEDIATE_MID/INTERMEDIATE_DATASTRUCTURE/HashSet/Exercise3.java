package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
// 서로 다른 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise3 {
    public static int n; // 숫자 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(hashSet.size());

    }
}
