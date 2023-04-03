package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N, M; //N개의 숫자, M개 뽑기
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        findCombination(1, 0);
        System.out.println(sb);
    }

    private static void findCombination(int currNum, int cnt) {
        if (currNum == N + 1) {
            if (cnt == M) {
                printCombination();
            }
            return;
        }

        answer.add(currNum);
        findCombination(currNum + 1, cnt + 1);
        answer.remove(answer.size() - 1);
        findCombination(currNum + 1, cnt);
    }

    private static void printCombination() {
        for (Integer num : answer) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
