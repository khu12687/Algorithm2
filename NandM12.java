import java.io.*;
import java.util.*;

public class NandM12 {
    static int M;
    static Integer[] intArr;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<Integer> s = new HashSet<>();
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++)
            s.add(Integer.parseInt(st.nextToken()));

        intArr = s.toArray(new Integer[0]);
        Arrays.sort(intArr);

        backTracking(0, 0);
    }

    static void backTracking(int idx, int count){
        if(count == M){
            for(int i = 0; i<M; i++)
                System.out.print(answer[i]+" ");
            System.out.println();

            return;
        }

        for(int i = idx; i<intArr.length; i++){
            answer[count] = intArr[i];
            backTracking(i, count+1);
        }
    }
}
