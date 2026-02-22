package topics.graph;

import java.util.Arrays;

/**
 * 벨만-포드 최단거리 템플릿.
 * 목표:
 * - 시작 정점에서 모든 정점까지 최단거리를 계산한다.
 * - 음수 간선을 허용하고, 음수 사이클은 예외 처리한다.
 * - 시간복잡도 O(VE).
 * 계약:
 * - vertexCount: 정점 개수
 * - edges: [from,to,weight] 형태의 간선 목록
 * - start: 시작 정점 인덱스
 * - 반환: 각 정점까지 거리 배열 (도달 불가는 Integer.MAX_VALUE)
 * - 시작 정점에서 음수 사이클이 감지되면 IllegalStateException을 던진다.
 */
public class BellmanFord {

  public int[] bellmanFord(int vertexCount, int[][] edges, int start) {

        if (edges == null || start < 0 | start >= vertexCount) throw new IllegalArgumentException("잘못된 입력입니다.");

        int[] dist = new int [vertexCount];
    int INF = Integer.MAX_VALUE;

    Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int v = 1; v < vertexCount; v++){
          boolean relaxed = false;
            for(int[] e: edges) {
                int from  = e[0];
                int to  = e[1];
                int weight  = e[2];

                if(dist[from] == INF || dist[to] <= dist[from]+weight) continue;

                dist[to] = dist[from] + weight;
                relaxed = true;
            }

            if(!relaxed) break;
        }

        for(int[] e: edges) {
            int from  = e[0];
            int to  = e[1];
            int weight  = e[2];

            if(dist[from] == INF) continue;

            if(dist[to] > dist[from]+weight) throw new IllegalStateException("음수 사이클을 감지하여 예외가 발생합니다.");
        }

        return dist;
    }
}
