package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
//대응되는 수와 문자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise4 {
    public static int n, m; //문자열 갯수, 조사할 대상 갯수
    public static Map<String, Integer> map = new HashMap<>();
    public static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = new String[n+1];

        for (int i = 1; i <= n; i++) {
            String key = br.readLine();
            str[i] = key;
            map.put(key, i);
        }

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < m; j++) {
            String input = br.readLine();
            if (isNumber(input)) {
                sb.append(str[Integer.parseInt(input)]).append("\n");
            } else {
                sb.append(map.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
