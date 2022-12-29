import java.util.*;
import java.io.*;

public class Floyd {
    static StringBuilder sb;

    static final int INF = 1000000000;
    static int N, M;
    static int x = 0;
    static int y = 0;
    static int map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = INF;

                if(i == j) {
                    map[i][j] = 0;
                }
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            map[y][x] = Math.min(map[y][x], value);
        }

        Road_Finder();

        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == INF) {
                    map[i][j] = 0;
                }

                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    } // End of Main

    static void Road_Finder() {

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {

                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }


                }
            }
        }

    }

}