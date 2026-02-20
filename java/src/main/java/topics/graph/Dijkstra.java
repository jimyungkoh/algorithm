package topics.graph;

/**
 * 다익스트라 최단거리 템플릿.
 *
 * 목표:
 * - 시작 정점에서 모든 정점까지 최단거리를 계산한다.
 * - 음수 간선이 없는 경우를 가정한다.
 * - 시간복잡도 O((V + E) log V).
 *
 * 계약:
 * - vertexCount: 정점 개수
 * - edges: [from,to,weight] 형태의 간선 목록
 * - start: 시작 정점 인덱스
 * - 반환: 각 정점까지 거리 배열 (도달 불가는 Integer.MAX_VALUE)
 * - 음수 간선이 감지되면 IllegalArgumentException을 던진다.
 */
public class Dijkstra {
    public int[] dijkstra(int vertexCount, int[][] edges, int start) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
