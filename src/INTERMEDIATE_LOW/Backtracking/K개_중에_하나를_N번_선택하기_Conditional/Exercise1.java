package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

//특정 조건에 맞개 k개 중에 1개를 n번 뽑기
public class Exercise1 {
    public static int K, N; //뽑을 수, 반복 수
    public static ArrayList<Integer> selectList = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        choose(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void choose(int currIdx) {
        if (currIdx == N) {
            selectList.forEach(ele -> sb.append(ele).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= K; i++) {
            selectList.add(i);
            if (selectList.size() >= 3) {
                if (Objects.equals(selectList.get(currIdx), selectList.get(currIdx - 1)) &&
                        Objects.equals(selectList.get(currIdx), selectList.get(currIdx - 2))) {
                    selectList.remove(currIdx);
                    continue;
                }
            }
            choose(currIdx + 1);
            selectList.remove(selectList.size() - 1);
        }
    }
}
