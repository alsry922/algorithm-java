package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//겹치지 않게 선분 고르기
public class Exercise4 {
    static class Segment {
        int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int N; //선분 갯수
    public static Segment[] segments;
    public static ArrayList<Segment> selectList = new ArrayList<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        segments = new Segment[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            segments[i] = new Segment(start, end);
        }

        findMaxSegments(0);
        System.out.println(answer);
    }

    private static void findMaxSegments(int cnt) {
        if (cnt == N) {
            if (possible()) {
                answer = Math.max(answer, selectList.size());
            }
            return;
        }

        selectList.add(segments[cnt]);
        findMaxSegments(cnt + 1);
        selectList.remove(selectList.size() - 1);
        findMaxSegments(cnt + 1);
    }

    private static boolean possible() {
        for (int i = 0; i < selectList.size() - 1; i++) {
            Segment seg1 = selectList.get(i);
            for (int j = i + 1; j < selectList.size(); j++) {
                Segment seg2 = selectList.get(j);
                if (segmentsOverlap(seg1, seg2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean segmentsOverlap(Segment seg1, Segment seg2) {

        return (seg1.start <= seg2.start && seg2.start <= seg1.end) ||
                (seg1.start <= seg2.end && seg2.end <= seg1.end) ||
                (seg2.start <= seg1.start && seg1.start <= seg2.end) ||
                (seg2.start <= seg1.end && seg1.end <= seg2.end);
    }

}
