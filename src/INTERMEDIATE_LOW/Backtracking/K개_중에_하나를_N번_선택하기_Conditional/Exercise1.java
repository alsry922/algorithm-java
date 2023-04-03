package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int K, N;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        answer.add(0); //0번째 자리 0으로 초기화
        choose(1);
    }

    public static void choose(int currPos) {
        if (currPos == N + 1) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (!canPickNum(i, currPos)) {
                continue;
            }
            answer.add(i);
            choose(currPos+1);
            answer.remove(answer.size() - 1);
        }
    }

    private static boolean canPickNum(int i, int currPos) {
        return (currPos < 3) || (answer.get(currPos-1) != i || answer.get(currPos-2) != i);
    }

    private static void printAnswer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < answer.size(); i++) {
            sb.append(answer.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
