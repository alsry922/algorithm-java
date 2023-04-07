package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeMap;
//처음 등장하는 위치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise3 {
    public static int n; //원소의 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (!treeMap.containsKey(input)) {
                treeMap.put(input, i);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            sb.append(entry.getKey()).append(" ").append(treeMap.get(entry.getKey())).append("\n");
        }
        System.out.println(sb);
    }
}
