package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 점 빼기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Pair10 implements Comparable<Pair10> {
    int x, y;

    public Pair10(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair10 pair) {
        if (this.x == pair.x) {
            return this.y - pair.y;
        }
        return this.x - pair.x;
    }
}

public class Exercise10 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        TreeSet<Pair10> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            treeSet.add(new Pair10(x, y));
        }

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            Pair10 target = new Pair10(x, 0);
            if (treeSet.ceiling(target) != null) {
                Pair10 toDelete = treeSet.ceiling(target);
                System.out.println(toDelete.x + " " + toDelete.y);
                treeSet.remove(treeSet.ceiling(target));
            } else {
                System.out.println("-1 -1");
            }
        }
    }
}
