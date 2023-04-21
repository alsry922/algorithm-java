package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1차원 윷놀이
public class Exercise2 {
    public static int N, M, K; //턴 수, 윷 판 길이, 말 수
    public static int[] turns;
    public static int[] horses;
    public static ArrayList<Integer> select = new ArrayList<>();
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        turns = new int[N];
        horses = new int[K + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            turns[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= K; i++) {
            horses[i] = 1;
        }

        choose(0);
        System.out.println(answer);
    }

    private static void choose(int cnt) {
        if (cnt == N) {
            initHorses();
            for (int i = 0; i < select.size(); i++) {
                horses[select.get(i)] += turns[i];
            }
            int score = 0;
            for (int i = 1; i < horses.length; i++) {
                if (horses[i] >= M) {
                    score++;
                }
            }
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 1; i <= K; i++) {
            select.add(i);
            choose(cnt + 1);
            select.remove(select.size() - 1);
        }
    }

    private static void initHorses() {
        for (int i = 1; i < horses.length; i++) {
            horses[i] = 1;
        }
    }
}
