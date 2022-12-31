import java.util.*;
import java.io.*;

public class FindTheSumOfTheIntervals {
    public static void main(String[] args) throws IOException {

        // 1. N, M, N*N 배열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());	// 2차원 배열의 크기
        int M = Integer.parseInt(st.nextToken());	// 구해야하는 구간 합의 수

        // 2. 배열 입력과 동시에 합배열 구하기
        // S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j]
        int[][] S = new int[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        // 3. 구간 합 구한 후 출력
        // 구간 합 = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]
        int result = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            result = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
