package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//n개 중에 m개 뽑기
public class Exercise1 {
    public static int N, M; //N개 중에 M개 뽑기
    public static int[] nums;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        findCombination(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findCombination(int currIdx, int cnt) {
        if (currIdx == N) {
            if (cnt == M) {
                for (int num : list) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        list.add(nums[currIdx]);
        findCombination(currIdx + 1, cnt + 1);
        list.remove(list.size() - 1);
        findCombination(currIdx + 1, cnt);
    }
}
