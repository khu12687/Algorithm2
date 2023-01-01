import java.util.*;
import java.io.*;

public class FindTheParentOfTheTree {
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());

        for (int i=0; i<=nodes; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i=0; i<nodes-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            FindTheParentOfTheTree.edges.get(node1).add(node2);
            FindTheParentOfTheTree.edges.get(node2).add(node1);
        }

        visited = new boolean[nodes+1];
        parents = new int[nodes+1];

        dfs(1);
        // 루트인 1번 노드부터 시작한다.

        for (int i=2; i<parents.length; i++) {
            System.out.println(parents[i]);
            // 2번 노드부터 부모를 구하면 된다.
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int v : edges.get(node)) {
            if (!visited[v]) {
                dfs(v);
                parents[v]=node;
                //임의 노드 v를 만나기 위해서는 반드시 부모노드 node를 지난다.
                // 따라서 부모 노드는 반복문 안에서 만나는 node
            }
        }
    }
}