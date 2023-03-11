package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //포켓몬 수
        int M = Integer.parseInt(st.nextToken()); //문제 수
        Map<String, Integer> book = new HashMap<>(); //도감
        String[] arr = new String[N+1]; //이름 저장 배열

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            book.put(name, i);
            arr[i] = name;
        }

        while (M-- > 0) {
            String input = br.readLine();
            if (isNumeric(input)) {
                int number = Integer.parseInt(input);
                sb.append(arr[number]);
            } else {
                sb.append(book.get(input));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    /**
     * 입력받은 문자열이 숫자로 변환할 수 있는 문자열인지 확인하는 메서드
     * @param input 입력받은 문자열
     * @return
     */
    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
