import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(true) {
            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{0,0});
            map[0][0]=-1;
            while(!q.isEmpty()) {
                //바깥공기 영역 구하기 !!
                //bfs 사용
                Integer[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int i=0;i<4;i++) {
                    int nowx = x+dx[i];
                    int nowy = y+dy[i];
                    if(nowx<0||nowy<0||nowx>=n||nowy>=m) {
                        continue;
                    }
                    if(map[nowx][nowy]==0) {
                        map[nowx][nowy]=-1;
                        q.add(new Integer[] {nowx,nowy});
                    }
                }
            }
            Queue<Integer> xx = new LinkedList<>();
            Queue<Integer> yy = new LinkedList<>();
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    int cnt = 0;
                    if(map[i][j]==1) {
                        for(int d=0;d<4;d++) {
                            int nowx = i+dx[d];
                            int nowy = j+dy[d];
                            if(nowx<0||nowy<0||nowx>=n||nowy>=m) {
                                continue;
                            }
                            //범위 나가버리면 컨티뉴

                            if(map[nowx][nowy]==-1) {
                                cnt ++;
                                if(cnt>=2) break;
                                //두개이상이 비었다면 더이상 볼 필요 없으니 break
                            }
                        }
                        if(cnt>=2) {
                            xx.add(i);
                            yy.add(j);
                            //없어질 치즈 좌표를 넣어준다.
                        }
                    }
                }
            }
            if(xx.isEmpty()) {
                System.out.println(res);
                System.exit(0);
            }
            //사라질 치즈 후보가 없다는 것은 치즈가 모두 녹아서 없어졌다는 것.
            //res를 출력해주고 종료해주자.

            //종료가 되지 않았다는 것은 아직 치즈가 있다는 것.
            //없어질 치즈들을 없애주고, while문 진행
            res++;
            while(!xx.isEmpty()) {
                map[xx.poll()][yy.poll()] = 0;
            }
            for(int i = 0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(map[i][j]==-1) {
                        map[i][j]=0;
                    }
                }
            }
        }
    }
}

