/**
 * 이분 매칭 템플릿.
 *
 * 목표:
 * - 좌측 정점 집합 기준 최대 매칭을 계산
 * - 각 좌측 정점이 매칭한 우측 정점 인덱스를 반환
 * - 매칭되지 않은 좌측 정점은 -1 반환
 *
 * 입력 계약:
 * - graph: 좌측 정점 i의 연결 가능한 우측 정점 목록
 * - rightCount: 우측 정점 개수
 * - 반환값: 좌측 정점별 매칭 결과 배열
 *
 * 구현 가이드:
 * 1. 방문 배열과 DFS/BFS 기반 증강 경로 탐색을 준비한다.
 * 2. 좌측 정점마다 매칭 시도를 수행해 매칭 크기를 갱신한다.
 * 3. 매칭이 불가능한 경우 -1을 그대로 유지한다.
 */
function maximumBipartiteMatching(graph, rightCount) {
  throw new Error("TODO: implement");
}

module.exports = { maximumBipartiteMatching };
