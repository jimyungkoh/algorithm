package topics.graph;

/**
 * 벨만-포드 최단거리 템플릿.
 *
 * 목표:
 * - 시작 정점에서 모든 정점까지 최단거리를 계산한다.
 * - 음수 간선을 허용하고, 음수 사이클은 예외 처리한다.
 * - 시간복잡도 O(VE).
 *
 * 계약:
 * - vertexCount: 정점 개수
 * - edges: [from,to,weight] 형태의 간선 목록
 * - start: 시작 정점 인덱스
 * - 반환: 각 정점까지 거리 배열 (도달 불가는 Integer.MAX_VALUE)
 * - 시작 정점에서 음수 사이클이 감지되면 IllegalStateException을 던진다.
 */
public class BellmanFord {
    public int[] bellmanFord(int vertexCount, int[][] edges, int start) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
