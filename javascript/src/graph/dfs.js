/**
 * 깊이 우선 탐색(DFS) 템플릿.
 *
 * 목표:
 * - 시작 정점에서 도달 가능한 정점들을 방문 순서대로 반환
 * - 시간복잡도 O(V + E)
 *
 * 입력 계약:
 * - graph: 각 정점의 인접 정점 목록을 담은 인접 리스트
 * - start: 시작 정점 인덱스
 * - 잘못된 입력이면 예외를 던짐
 *
 * 구현 가이드:
 * 1. 입력과 시작점 범위를 검증한다.
 * 2. 방문 배열을 만들고 시작 정점을 스택/재귀로 방문한다.
 * 3. 이미 방문한 정점은 다시 처리하지 않으며, 방문할 수 있는 모든 정점의 순서를 기록한다.
 * 4. 방문 순서를 담은 배열을 반환한다.
 */
function dfs(graph, start) {
  if (!Array.isArray(graph) || start >= graph.length || start < 0) throw Error("지원하지 않는 입력입니다.");
  const ret = [];
  const visited = Array(graph.length).fill(false);
  dfs_core({ graph, currentVertex:start, ret, visited });
  return ret;
}

function dfs_core({ graph, currentVertex, ret, visited }){
  if (!Array.isArray(graph) || visited[currentVertex]) return;
  visited[currentVertex] = true;
  ret.push(currentVertex);

  for (const v of graph[currentVertex]){
    if (v < 0 || v >= graph.length) continue;
    dfs_core({ graph, currentVertex:v, ret, visited });
  }
}

module.exports = { dfs };
