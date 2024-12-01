package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//겹치지 않게 선분 고르기
public class Exercise4 {
    public static int N;
    public static List<Segment> segments = new ArrayList<>();
    public static List<Segment> picked = new ArrayList<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            segments.add(new Segment(start, end));
        }

        findMaxSegmentsWithOutOverlap();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findMaxSegmentsWithOutOverlap() {
        choose(0);
    }

    // 현재 인덱스의 값을 뽑느냐 뽑지 않느냐
    public static void choose(int currIdx) {
        if (currIdx == N) {
            if (isPossible()) {
                answer = Math.max(answer, picked.size());
            }
            return;
        }

        // 현재 인덱스의 선분을 뽑음
        picked.add(segments.get(currIdx));
        choose(currIdx + 1);
        // 현재 인덱스의 선분을 뽑지 않음
        picked.remove(segments.get(currIdx));
        choose(currIdx + 1);
    }

    public static boolean isPossible() {
        for (int i = 0; i < picked.size(); i++) {
            for (int j = i + 1; j < picked.size(); j++) {
                if (overlapped(picked.get(i), picked.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean overlapped(Segment a, Segment b) {
        int aStart = a.start;
        int aEnd = a.end;
        int bStart = b.start;
        int bEnd = b.end;

        return (aStart <= bStart && bStart <= aEnd) || (aStart <= bEnd && bEnd <= aEnd) || (bStart <= aStart && aStart <= bEnd) || (bStart <= aEnd && aEnd <= bEnd);
    }

    public static class Segment {
        int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
