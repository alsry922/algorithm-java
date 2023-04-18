package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//아름다운 수
public class Exercise2 {
    public static int N; //자릿 수
    public static ArrayList<Integer> selectList = new ArrayList<>();
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        choose(0);
        System.out.println(answer);
    }

    private static void choose(int cnt) {
        if (cnt == N) {
            if (isBeautifulNum()) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            selectList.add(i);
            choose(cnt + 1);
            selectList.remove(selectList.size() - 1);
        }
    }

    private static boolean isBeautifulNum() {
        for (int i = 0; i < selectList.size(); i += selectList.get(i)) {
            if (i + selectList.get(i) - 1 >= N) {
                return false;
            }
            for (int j = i; j < i + selectList.get(i); j++) {
                if (!selectList.get(i).equals(selectList.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
