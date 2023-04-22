package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// xor 결과 최대 만들기
public class Exercise2 {
    public static int N, M; //N개 중 M개 고르기
    public static int[] nums;
    public static ArrayList<Integer> select = new ArrayList<>();
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findMaxXor(0, 0);
        System.out.println(answer);
    }

    private static void findMaxXor(int idx, int cnt) {
        if (idx == N) {
            if (cnt == M) {
                answer = Math.max(answer, calc());
            }
            return;
        }

        select.add(nums[idx]);
        findMaxXor(idx + 1, cnt + 1);
        select.remove(select.size() - 1);
        findMaxXor(idx + 1, cnt);

    }

    private static int calc() {
        int result = select.get(0);
        for (int i = 1; i < select.size(); i++) {
            result = result ^ select.get(i);
        }
        return result;
    }
}
