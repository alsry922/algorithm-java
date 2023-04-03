package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
//hahsmap 기본

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                hashMap.put(key, value);
            } else {
                int key = Integer.parseInt(st.nextToken());
                if (command.equals("find")) {
                    int value = hashMap.getOrDefault(key,-1);
                    System.out.println(value == -1 ? "None" : value);
                }
                if (command.equals("remove")) {
                    hashMap.remove(key);
                }
            }
        }
    }
}
