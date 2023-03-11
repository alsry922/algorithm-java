package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek1074 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //크기
        int r = Integer.parseInt(st.nextToken()); //행
        int c = Integer.parseInt(st.nextToken()); //열

        int size = (int) Math.pow(2, N);
        findPos(size, r, c);
        System.out.println(count);

    }

    public static void findPos(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        /*1사분면인 경우*/
        if (r < size / 2 && c < size / 2) {
            findPos(size / 2, r, c);
        /*2사분면인 경우*/
        } else if (r < size / 2 && c >= size / 2) {
            count += (int)Math.pow(size / 2, 2);
            findPos(size / 2, r, c - size / 2);
        /*3사분면인 경우*/
        } else if (r >= size / 2 && c < size / 2) {
            count += (int) Math.pow(size / 2, 2) * 2;
            findPos(size/2, r - size / 2, c);
        /*4사분면인 경우*/
        } else if (r >= size / 2 && c >= size / 2) {
            count += (int) Math.pow(size / 2, 2) * 3;
            findPos(size / 2, r - size / 2, c - size / 2);
        }
    }
}
