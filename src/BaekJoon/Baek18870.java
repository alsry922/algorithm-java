package BaekJoon;
// 좌표 압축

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek18870 {
    public static int N; //길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 원본 배열
        int[] origin = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 정렬 배열(중복 제거)
        int[] sorted = Arrays.stream(origin).distinct().sorted().toArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(sorted, origin[i])).append(" ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int[] sorted, int target) {
        int left = 0; // 왼쪽
        int right = sorted.length - 1; // 오른쪽
        int targetIndex = sorted.length;

        while (left <= right) {
            int mid = (right - left) / 2 + left; // 중간
            if (sorted[mid] >= target) {
                right = mid - 1;
                targetIndex = Math.min(targetIndex, mid);
            } else {
                left = mid + 1;
            }
        }
        return targetIndex;
    }
}
