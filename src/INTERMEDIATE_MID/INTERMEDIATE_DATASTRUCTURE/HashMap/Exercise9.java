package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 순서를 바꾸었을 때 같은 단어 그룹화하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise9 {
    public static int n; // 문자열 입력 갯수
    public static Map<String, Integer> freq = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = Arrays.toString(chars);

            if (!freq.containsKey(str)) {
                freq.put(str, 1);
            } else {
                freq.put(str, freq.get(str) + 1);
            }
        }

        int answer = 0;
        for (Integer freq : freq.values()) {
            answer = Math.max(answer, freq);
        }

        System.out.println(answer);
    }
}
