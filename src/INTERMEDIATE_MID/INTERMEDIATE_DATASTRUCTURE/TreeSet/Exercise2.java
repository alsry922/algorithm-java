package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 정수 명령어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("I")) {
                    int value = Integer.parseInt(st.nextToken());
                    treeSet.add(value);
                }
                if (command.equals("D") && !treeSet.isEmpty()) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        treeSet.remove(treeSet.last());
                    } else {
                        treeSet.remove(treeSet.first());
                    }
                }
            }
            System.out.println(treeSet.isEmpty() ? "EMPTY" : treeSet.last() + " " + treeSet.first());
        }

    }
}
