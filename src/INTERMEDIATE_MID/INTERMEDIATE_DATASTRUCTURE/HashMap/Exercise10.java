package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 특별한 문자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Exercise10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            hashMap.put(input.charAt(i), hashMap.getOrDefault(input.charAt(i), 0) + 1);
        }

        String answer = "None";

        for (int i = 0; i < input.length(); i++) {
            if (hashMap.get(input.charAt(i)) == 1) {
                answer = String.valueOf(input.charAt(i));
                break;
            }
        }

        System.out.println(answer);
    }
}
