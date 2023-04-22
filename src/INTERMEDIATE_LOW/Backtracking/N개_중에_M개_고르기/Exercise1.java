package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//n개 중에 m개 뽑기
public class Exercise1 {
    public static int N, M; //N개 중에 M개 뽑기
    public static int[] nums;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        findCombination(0, 0);
    }

    private static void findCombination(int idx, int cnt) {
        if (idx == N) {
            if (cnt == M) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)).append(" ");
                }
                System.out.println(sb);
            }
            return;
        }

        list.add(nums[idx]);
        findCombination(idx+1, cnt+1);
        list.remove(list.size() - 1);
        findCombination(idx + 1, cnt);
    }
}
