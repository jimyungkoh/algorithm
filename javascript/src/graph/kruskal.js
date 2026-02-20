/**
 * 크루스칼 MST 템플릿.
 *
 * 목표:
 * - 연결 그래프에서 최소 신장 트리 간선 집합 계산
 * - 정점 수가 n인 그래프에서 n-1개 간선을 반환
 * - 정점 연결이 불가능하면 빈 배열 반환(또는 빈 결과로 처리)
 *
 * 입력 계약:
 * - vertexCount: 정점 개수
 * - edges: [from, to, weight] 형태의 무향 간선 목록
 * - 반환값: MST를 구성하는 간선 목록
 *
 * 구현 가이드:
 * 1. 간선을 가중치 기준 오름차순 정렬한다.
 * 2. 유니온 파인드로 사이클을 피하면서 간선을 선택한다.
 * 3. 선택 간선 수가 n-1이 되면 조기 종료한다.
 */
function kruskal(vertexCount, edges) {
  throw new Error("TODO: implement");
}

module.exports = { kruskal };
