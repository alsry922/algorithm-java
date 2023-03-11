package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> hear = new HashSet<>(); //듣
        Set<String> see = new HashSet<>(); //보

        while (N-- > 0) {
            hear.add(br.readLine());
        }

        while (M-- > 0) {
            see.add(br.readLine());
        }

        hear.retainAll(see); //듣보만 남음
        sb.append(hear.size()).append("\n");

        ArrayList<String> names = new ArrayList<>(hear);
        names.sort(Comparator.naturalOrder());
        names.forEach(name -> sb.append(name).append("\n"));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
