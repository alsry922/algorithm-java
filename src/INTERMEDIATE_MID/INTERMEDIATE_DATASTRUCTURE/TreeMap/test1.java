package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeMap;
// 단어장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class test1 {
    public static int n; //단어 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!treeMap.containsKey(word)) {
                treeMap.put(word, 1);
            } else {
                treeMap.put(word, treeMap.get(word) + 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> it = treeMap.entrySet().iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            sb.append(entry.getKey())
                    .append(" ")
                    .append(treeMap.get(entry.getKey()))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
