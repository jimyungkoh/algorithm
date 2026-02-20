/**
 * 벨만-포드 최단거리 템플릿.
 *
 * 목표:
 * - 시작 정점에서 모든 정점까지 최단거리 계산
 * - 방향 가중치 그래프에서 음수 간선 지원
 * - 시작 정점에서 도달 가능한 음수 사이클이 있으면 예외 처리
 * - 시간복잡도 O(VE)
 *
 * 입력 계약:
 * - vertexCount: 정점 개수
 * - edges: [from, to, weight] 형태의 배열
 * - start: 시작 정점 인덱스
 * - 도달 불가 정점은 Number.POSITIVE_INFINITY로 반환
 *
 * 구현 가이드:
 * 1. 거리 배열을 초기화한다. 시작 정점은 0, 나머지는 INF.
 * 2. vertexCount - 1회 순회하며 모든 간선을 완화한다.
 * 3. 추가 순회에서 완화가 가능하면 음수 사이클 도달을 감지해 예외를 던진다.
 */
function bellmanFord(vertexCount, edges, start) {
  throw new Error("TODO: implement");
}

module.exports = { bellmanFord };
