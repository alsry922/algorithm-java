package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
//가장 많은 데이터
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise3 {
    public static int n; //문자열의 갯수
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
            answer = Math.max(answer, map.get(key));
        }

        System.out.println(answer);
    }
}
