package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 낮은 지점들

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(x)) {
                hashMap.put(x, y);
            } else {
                hashMap.put(x, Math.min(hashMap.get(x), y));
            }
        }

        long answer = 0;
        for (Integer y : hashMap.values()) {
            answer += y;
        }

        System.out.println(answer);

    }
}
