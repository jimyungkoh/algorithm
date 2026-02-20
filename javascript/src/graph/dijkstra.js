/**
 * 다익스트라 최단거리 템플릿.
 *
 * 목표:
 * - 시작 정점에서 모든 정점까지 최단거리 계산
 * - 음수 간선을 허용하지 않는 방향/무방향 그래프에서 동작
 * - 시간복잡도 O((V + E) log V) (우선순위 큐 기준)
 *
 * 입력 계약:
 * - vertexCount: 정점 개수
 * - edges: [from, to, weight] 형태의 배열
 * - start: 시작 정점 인덱스
 * - 도달 불가 정점은 Number.POSITIVE_INFINITY로 반환
 *
 * 구현 가이드:
 * 1. 거리 배열을 초기화한다. 시작 정점은 0, 나머지는 INF.
 * 2. 우선순위 큐로 현재 최단거리 후보를 관리한다.
 * 3. 처리된 정점은 스킵하고, 최단거리 갱신이 가능한 간선을 완화한다.
 * 4. 음수 가중치 간선이 입력에 들어오면 예외를 던지는 정책을 정한다.
 */
function dijkstra(vertexCount, edges, start) {
  throw new Error("TODO: implement");
}

module.exports = { dijkstra };
