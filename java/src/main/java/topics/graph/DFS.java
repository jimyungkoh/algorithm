package topics.graph;

import java.util.ArrayList;

/**
 * 깊이 우선 탐색(DFS) 템플릿.
 * 목표:
 * - 시작 정점에서 도달 가능한 정점을 방문 순서대로 반환한다.
 * - 시간복잡도 O(V + E)로 동작한다.
 * 계약:
 * - graph: 각 정점의 인접 정점 목록을 담은 인접 리스트
 * - start: 시작 정점 인덱스
 * - 반환: 방문 순서를 담은 int 배열
 * - 입력이 유효하지 않으면 IllegalArgumentException을 던진다.
 */
public class DFS {
    public int[] dfs(int[][] graph, int start) {
        if (graph == null || start < 0 || start >= graph.length)
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");

        ArrayList<Integer> retList = new ArrayList<>();
        dfsCore(graph, start, retList,new boolean[graph.length]);

        int[] ret =  new int[retList.size()];
        for (int i  = 0 ; i < retList.size() ; i++)
            ret[i] = retList.get(i);

        return ret;
    }

    private void dfsCore(int[][] graph, int start, ArrayList<Integer> ret, boolean [] visited){
        if(visited[start]) return ;
        visited[start] =  true;
        ret.add(start);

        for(int v:graph[start]){
            if(v >= graph.length  || v <0) continue;
            dfsCore(graph, v, ret, visited);
        }
    }
}
