package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1차원 윷놀이
public class Exercise2 {
    public static int N, M, K; //턴 수, 윳놀이 판, 말 수
    public static int[] distances;
    public static int[] scores;
    public static List<Integer> selections = new ArrayList<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scores = new int[K + 1];
        for (int i = 0; i < K + 1; i++) {
            scores[i] = 1;
        }

        choose(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void choose(int n) {
        calc();

        if (n == N) {
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (scores[i] >= M)
                continue;

            scores[i] += distances[n];
            choose(n + 1);
            scores[i] -= distances[n];

        }
    }

    public static void calc() {
        int result = (int) Arrays.stream(scores).filter(score -> score >= M).count();
        answer = Math.max(answer, result);
    }
}
