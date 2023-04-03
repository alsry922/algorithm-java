package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;
//아름다운 수


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise2 {
    public static int n; //자릿 수
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        choose(1, n);

        System.out.println(answer);
    }

    public static void choose(int currPos, int n) {
        if (currPos > n) {
            if (isBeautifulNum()) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr.add(i);
            choose(currPos + 1, n);
            arr.remove(arr.size() - 1);
        }
    }

    private static boolean isBeautifulNum() {
        for (int i = 0; i < n; i += arr.get(i)) {
            if (i + arr.get(i) - 1 >= n) {
                return false;
            }
            for (int j = i; j < i + arr.get(i); j++) {
                if (arr.get(j) != arr.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
