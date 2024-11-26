package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//아름다운 수
public class Exercise2 {
    public static int N;
    public static List<Integer> list = new ArrayList<>();
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        choose(N);

        bw.write(answer);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void choose(int n) {
        if (n == 0) {
            if (isBeautifulNum(list)) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            choose(n-1);
            list.remove(list.size()-1);
        }
    }

    public static boolean isBeautifulNum(List<Integer> list) {
        for (int i = 0; i < list.size(); i += list.get(i)) {
            int num = list.get(i);

            if (i + num - 1 >= N) {
                return false;
            }

            boolean isBeautifulNum = false;
            for (int j = i; j < i + num; j++) {
                if (!Objects.equals(list.get(j), list.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
