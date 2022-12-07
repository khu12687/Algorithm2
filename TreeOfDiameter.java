import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeOfDiameter {

    static int n;
    static int result = 0;
    static int max_node = 0;
    static ArrayList<Edge>[] nodes;

    static class Edge{ // 트리(그래프) 저장용
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{ // BFS 탐색용
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            int idx = Integer.parseInt(inputs[0]);
            int j = 1;
            while(true){
                int v_num = Integer.parseInt(inputs[j]);
                if(v_num == -1) break;
                int weight = Integer.parseInt(inputs[j+1]);

                nodes[idx].add(new Edge(v_num, weight));

                j += 2;
            }
        }

        bfs(1); // 임의의 노드 1
        bfs(max_node); // 임의의 노드 1에서 가장 먼 노드부터 bfs 시작

        System.out.println(result);

    }


    public static void bfs(int start) {

        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        int max_cnt = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(now.cnt>max_cnt){
                max_cnt = now.cnt;	// 가장 멀리 떨어진 노드의 거리
                max_node = now.idx;	// 가장 멀리 떨어진 노드의 번호
            }

            for (Edge e : nodes[now.idx]) {
                if(!visited[e.end]){
                    visited[e.end] = true;
                    q.add(new Node(e.end, now.cnt + e.weight));

                }
            }

        }

        result = Math.max(result, max_cnt);

    }
}
