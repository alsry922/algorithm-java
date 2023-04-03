package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;
// 1차원 윷놀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int n, m, k; //턴 수, 윳높이 판, 말 수
    public static int[] step;

    public static int answer = 0;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        step = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        choose(1);
        System.out.println(answer);
    }

    public static void choose(int cnt) {
        if (cnt > n) {
            int[] pieces = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                pieces[i] = 1;
            }

            for (int i = 0; i < list.size(); i++) {
                pieces[list.get(i)] += step[i];
            }

            int max = 0;

            for (int j = 1; j <= k; j++) {
                if (pieces[j] >= m) {
                    max++;
                }
            }

            answer = Math.max(answer, max);
            return;
        }

        for (int i = 1; i <= k; i++) {
            list.add(i);
            choose(cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}
