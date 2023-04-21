package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//특정 조건에 맞개 k개 중에 1개를 n번 뽑기
public class Exercise1 {
    public static int K, N; //뽑을 수, 반복 수
    public static ArrayList<Integer> selectList = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        choose(0);
        System.out.println(sb);
    }

    private static void choose(int cnt) {
        if (cnt == N) {
            print();
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (cnt < 2
                    || selectList.get(selectList.size()-1) != i
                    || selectList.get(selectList.size()-2) != i) {
                selectList.add(i);
                choose(cnt + 1);
                selectList.remove(selectList.size() - 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < selectList.size(); i++) {
            sb.append(selectList.get(i)).append(" ");
        }
        sb.append("\n");
    }
}
