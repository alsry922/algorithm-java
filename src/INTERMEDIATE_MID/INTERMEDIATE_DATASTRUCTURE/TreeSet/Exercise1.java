package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// treeset 기본

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        StringBuffer sb = new StringBuffer();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("largest")) {
                sb.append(treeSet.isEmpty() ? "None" : treeSet.last())
                        .append("\n");
            }
            if (command.equals("smallest")) {
                sb.append(treeSet.isEmpty() ? "None" : treeSet.first())
                        .append("\n");
            }
            if (command.equals("add")) {
                int value = Integer.parseInt(st.nextToken());
                treeSet.add(value);
            }
            if (command.equals("find")) {
                int value = Integer.parseInt(st.nextToken());
//                System.out.println(treeSet.contains(value));
                sb.append(treeSet.contains(value))
                        .append("\n");
            }
            if (command.equals("remove")) {
                int value = Integer.parseInt(st.nextToken());
                treeSet.remove(value);
            }
            if (command.equals("lower_bound")) {
                int value = Integer.parseInt(st.nextToken());
                sb.append(treeSet.ceiling(value) == null ? "None" : treeSet.ceiling(value))
                        .append("\n");
            }
            if (command.equals("upper_bound")) {
                int value = Integer.parseInt(st.nextToken());
                sb.append(treeSet.higher(value) == null ? "None" : treeSet.higher(value))
                        .append("\n");
            }
        }
        System.out.println(sb);
    }
}
