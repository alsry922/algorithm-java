package INTERMEDIATE_LOW.DFS.DFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//안전 지대
public class Exercise4 {
    static class SafeZone implements Comparable<SafeZone> {
        int cnt; //세이프 존 영역 수
        int rain; //비의 높이

        public SafeZone(int cnt, int rain) {
            this.cnt = cnt;
            this.rain = rain;
        }

        @Override
        public int compareTo(SafeZone ns) {
            if (this.cnt == ns.cnt) {
                return this.rain - ns.rain;
            }
            return ns.cnt - this.cnt;
        }
    }
    public static int N, M; //행, 열
    public static int[][] grid;
    public static ArrayList<SafeZone> safeZones = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rain = 1;
        while (rain <= 100) {
            boolean[][] visited = new boolean[N + 1][M + 1];
            int currSaveZoneCnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (grid[i][j] > rain && !visited[i][j]) {
                        visited[i][j] = true;
                        currSaveZoneCnt++;
                        dfs(i, j, rain, visited);
                    }
                }
            }
            safeZones.add(new SafeZone(currSaveZoneCnt, rain));
            rain++;
        }

        Collections.sort(safeZones);
        SafeZone maxSafeZone = safeZones.get(0);
        System.out.println(maxSafeZone.rain + " " + maxSafeZone.cnt);
    }

    private static void dfs(int x, int y, int rain, boolean[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny, rain, visited)) {
                visited[nx][ny] = true;
                dfs(nx, ny, rain, visited);
            }
        }
    }

    private static boolean canGo(int x, int y, int rain, boolean[][] visited) {
        return isInRange(x, y) && !visited[x][y] && grid[x][y] > rain;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}
