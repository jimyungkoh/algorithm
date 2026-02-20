package topics.graph;

/**
 * A* 경로탐색 템플릿.
 *
 * 목표:
 * - 시작 정점에서 목표 정점까지 휴리스틱 기반 최단경로를 복원한다.
 * - 경로가 없으면 빈 배열을 반환한다.
 *
 * 계약:
 * - vertexCount: 정점 개수
 * - edges: [from,to,weight] 형태의 간선 목록
 * - heuristic: 각 정점의 휴리스틱 점수
 * - start: 시작 정점
 * - goal: 목표 정점
 * - 반환: start -> goal 경로 정점 목록
 */
public class AStar {
    public int[] aStar(int vertexCount, int[][] edges, int[] heuristic, int start, int goal) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
