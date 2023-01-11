import java.io.*;
import java.util.*;
public class NandM8 {
    static int N,M,arr[],result[];
    public static void comb(int start, int cnt) {
        if(M == cnt) {
            for(int i : result) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++) {
            result[cnt] = arr[i];
            comb(i,cnt+1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0,0);
        bw.flush();
        bw.close();
        br.close();
    }
}