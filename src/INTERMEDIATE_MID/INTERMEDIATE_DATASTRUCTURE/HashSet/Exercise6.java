package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
//C-TAG

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise6 {
    public static int N, M; //한 그룹의 행, 열
    public static String[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new String[2*N + 1];

        for (int i = 1; i <= 2 * N; i++) {
            cards[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    HashSet<String> A = new HashSet<>();
                    HashSet<String> B = new HashSet<>();
                    boolean isDistinct = true;
                    for (int ai = 1; ai <= N; ai++) {
                        A.add(String.valueOf(cards[ai].charAt(i)) + String.valueOf(cards[ai].charAt(j)) + String.valueOf(cards[ai].charAt(k)));
                    }
                    for (int bi = N + 1; bi <= N * 2; bi++) {
                        String groupB = String.valueOf(cards[bi].charAt(i)) + String.valueOf(cards[bi].charAt(j)) + String.valueOf(cards[bi].charAt(k));
                        if (A.contains(groupB)) {
                            isDistinct = false;
                        }
                    }
                    if (isDistinct) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
