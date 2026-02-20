package topics.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 너비 우선 탐색(BFS) 템플릿.
 *
 * 목표:
 * - 시작 정점에서 도달 가능한 정점을 방문 순서대로 반환한다.
 * - 시간복잡도 O(V + E)로 동작한다.
 *
 * 계약:
 * - graph: 각 정점의 인접 정점 목록을 담은 인접 리스트
 * - start: 시작 정점 인덱스
 * - 반환: 방문 순서를 담은 int 배열
 * - 입력이 유효하지 않으면 IllegalArgumentException을 던진다.
 */
public class BFS {
    public int[] bfs(int[][] graph, int start) {
        if(graph == null || start<0|| start >= graph.length )
            throw new IllegalArgumentException("지원하지 않는 입력입니다.");

        Queue<Integer> vertices=  new LinkedList<>(List.of(start));
        boolean[] visitedVertices = new boolean[graph.length];
        ArrayList<Integer> ret = new ArrayList<>();

        while(!vertices.isEmpty()){
            int vertex = vertices.poll();
            if(visitedVertices[vertex]) continue;
            ret.add(vertex);
            visitedVertices[vertex] = true;

            for(int v : graph[vertex]){
              if(v<0|| v >= graph.length) continue;
              vertices.add(v);
            }
        }

        int[] result = new int[ret.size()];
        
        for(int i = 0 ; i < ret.size(); i++)
            result[i] = ret.get(i);

        return result;
    }
}
