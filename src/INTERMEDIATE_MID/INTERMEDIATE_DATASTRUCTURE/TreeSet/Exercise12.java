package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 최대로 연속한 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class LengthInfo implements Comparable<LengthInfo> {
    int start, end, len;

    public LengthInfo(int start, int end, int len) {
        this.start = start;
        this.end = end;
        this.len = len;
    }

    public int compareTo(LengthInfo lengthInfo) {
        if (this.len != lengthInfo.len) {
            return lengthInfo.len - this.len;
        } else if (this.start != lengthInfo.start) {
            return this.start - lengthInfo.start;
        } else {
            return this.end - lengthInfo.end;
        }
    }
}

public class Exercise12 {
    public static int n, m; //나열된 수, 제거할 숫자의 갯수
    public static int[] removeList;
    public static TreeSet<Integer> nums = new TreeSet<>();
    public static TreeSet<LengthInfo> lengthInfos = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        removeList = new int[m];
        nums.add(-1);
        nums.add(n + 1);
        lengthInfos.add(new LengthInfo(-1, n + 1, n + 1));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            removeList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int removeVal = removeList[i];
            nums.add(removeVal);
            int start = nums.lower(removeVal);
            int end = nums.higher(removeVal);
            lengthInfos.remove(new LengthInfo(start, end, end - start - 1));
            lengthInfos.add(new LengthInfo(start, removeVal, removeVal - start - 1));
            lengthInfos.add(new LengthInfo(removeVal, end, end - removeVal - 1));
            System.out.println(lengthInfos.first().len);
        }

    }
}
