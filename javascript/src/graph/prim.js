/**
 * 프림 MST 템플릿.
 *
 * 목표:
 * - 시작 정점에서 한 번에 한 정점씩 신장 트리 확장
 * - 최소 신장 트리 간선 목록 생성
 * - 연결되지 않은 그래프는 빈 결과로 처리
 *
 * 입력 계약:
 * - vertexCount: 정점 개수
 * - edges: [from, to, weight] 형태의 무향 간선 목록
 * - start: 시작 정점
 * - 반환값: 시작 정점 기반 MST 간선 목록
 *
 * 구현 가이드:
 * 1. 시작 정점에서 인접 간선을 우선순위 큐에 삽입한다.
 * 2. 아직 포함되지 않은 가장 작은 간선을 선택해 트리를 확장한다.
 * 3. 방문 정점을 기록해 사이클 없이 트리를 구성한다.
 */
function prim(vertexCount, edges, start) {
  throw new Error("TODO: implement");
}

module.exports = { prim };
