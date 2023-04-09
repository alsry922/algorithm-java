package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
//친한 점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair pair) {
        if (this.x == pair.x) {
            return this.y - pair.y;
        }
        return this.x - pair.x;
    }
}

public class Exercise4 {
    public static int n, m; //n개의 점, m개의 질의
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        TreeSet<Pair> pairs = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(x, y));
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair pair = pairs.ceiling(new Pair(x, y));
            if (pair == null) {
                System.out.println("-1 -1");
            } else {
                System.out.println(pair.x + " " + pair.y);
            }
        }
    }
}
