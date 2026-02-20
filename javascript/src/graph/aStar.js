/**
 * A* 경로탐색 템플릿.
 *
 * 목표:
 * - 시작 정점에서 목표 정점까지 휴리스틱 기반 최단 경로 복원
 * - 경로가 없으면 빈 배열 반환
 * - 시간복잡도는 휴리스틱 품질에 따라 달라짐
 *
 * 입력 계약:
 * - vertexCount: 정점 개수
 * - edges: [from, to, weight] 형태의 배열
 * - heuristic: 각 정점의 휴리스틱 값 배열 (목표 정점 기준)
 * - start: 시작 정점
 * - goal: 목표 정점
 * - 반환값: start -> goal 경로를 담은 정수 배열
 *
 * 구현 가이드:
 * 1. g점수(실제 비용)와 f점수(g + h) 우선순위 큐를 관리한다.
 * 2. 현재 노드에서 인접 간선을 따라 다음 후보를 갱신한다.
 * 3. 부모 노드 추적 배열을 이용해 목표 도달 시 경로를 역추적한다.
 * 4. 도달 불가이면 빈 배열을 반환한다.
 */
function aStar(vertexCount, edges, heuristic, start, goal) {
  throw new Error("TODO: implement");
}

module.exports = { aStar };
