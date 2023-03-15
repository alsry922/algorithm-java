package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //사람 수
        int[] time = new int[N + 1]; //인원당 걸리는 시간
        int[] minimumTimes = new int[N + 1]; //각 인원당 최소 시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        int minimum = 0;
        for (int i = 1; i < N + 1; i++) {
            minimum += time[i];
            minimumTimes[i] = minimum;
        }

        int minimumTime =
                Arrays.stream(minimumTimes)
                        .reduce((acc, next) -> {
                            return acc + next;
                        }).getAsInt();

        System.out.println(minimumTime);
    }
}
