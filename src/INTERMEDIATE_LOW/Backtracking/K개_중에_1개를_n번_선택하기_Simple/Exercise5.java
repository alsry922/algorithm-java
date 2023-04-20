package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//사다리 타기
public class Exercise5 {
    static class Segment {
        int pos, floor;

        public Segment(int pos, int floor) {
            this.pos = pos;
            this.floor = floor;
        }
    }

    static class Row {
        int start, end;

        public Row(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int N, M; //사람 수, 가로 줄 수
    public static ArrayList<Row>[] ladder;
    public static ArrayList<Segment> segments = new ArrayList<>();
    public static ArrayList<Segment> selectList = new ArrayList<>();
    public static int[] originResult;
    public static int maxFloor = 0;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int floor = Integer.parseInt(st.nextToken());
            maxFloor = Math.max(maxFloor, floor);
            segments.add(new Segment(pos, floor));
        }

        ladder = new ArrayList[maxFloor + 1];
        for (int i = 1; i <= maxFloor; i++) {
            ladder[i] = new ArrayList<Row>();
        }

        originResult = new int[N + 1];

        for (int i = 0; i < segments.size(); i++) {
            Segment segment = segments.get(i);
            int pos = segment.pos, floor = segment.floor;
            ladder[floor].add(new Row(pos, pos + 1));
            ladder[floor].add(new Row(pos + 1, pos));
        }

        for (int i = 1; i <= N; i++) {
            int cp = i;
            for (int cf = 1; cf <= maxFloor; cf++) {
                for (int j = 0; j < ladder[cf].size(); j++) {
                    Row row = ladder[cf].get(j);
                    if (row.start == cp) {
                        cp = row.end;
                        break;
                    }
                }
            }
            originResult[i] = cp;
        }

        findMinRow(0);
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    private static void findMinRow(int cnt) {
        if (cnt == M) {
            if (possible()) {
                answer = Math.min(answer, selectList.size());
            }
            return;
        }
        selectList.add(segments.get(cnt));
        findMinRow(cnt + 1);
        selectList.remove(selectList.size() - 1);
        findMinRow(cnt + 1);
    }

    private static boolean possible() {
        initLadder();

        for (int i = 0; i < selectList.size(); i++) {
            Segment segment = selectList.get(i);
            int pos = segment.pos, floor = segment.floor;
            ladder[floor].add(new Row(pos, pos + 1));
            ladder[floor].add(new Row(pos + 1, pos));
        }

        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int cp = i;
            for (int cf = 1; cf <= maxFloor; cf++) {
                for (int j = 0; j < ladder[cf].size(); j++) {
                    Row row = ladder[cf].get(j);
                    if (row.start == cp) {
                        cp = row.end;
                        break;
                    }
                }
            }
            result[i] = cp;
        }

        return Arrays.equals(originResult, result);

    }

    private static void initLadder() {
        for (int i = 1; i < ladder.length; i++) {
            ladder[i].clear();
        }
    }
}