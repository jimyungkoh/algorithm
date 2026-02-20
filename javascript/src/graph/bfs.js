/**
 * 너비 우선 탐색(BFS) 템플릿.
 *
 * 목표:
 * - 시작 정점에서 도달 가능한 정점들을 레벨 순서로 방문
 * - 시간복잡도 O(V + E)
 *
 * 입력 계약:
 * - graph: 각 정점의 인접 정점 목록을 담은 인접 리스트
 * - start: 시작 정점 인덱스
 * - 잘못된 입력이면 예외를 던짐
 *
 * 구현 가이드:
 * 1. 입력과 시작점 범위를 검증한다.
 * 2. 큐와 방문 배열을 초기화한다.
 * 3. 시작 정점에서 인접 정점을 레벨 순서로 확장해 방문 순서를 기록한다.
 * 4. 방문 순서를 담은 배열을 반환한다.
 */
function bfs(graph, start) {
  if (!Array.isArray(graph) || start < 0 || start >= graph.length)
    throw new Error("지원하지 않는 입력입니다.");

  const visitedVertices = new Array(graph.length).fill(false);
  const [ret, queue] = [[],[start]];
  let queueHead = 0;
  ret.push(start);
  visitedVertices[start] = true;

  while (queueHead < queue.length){
    const vertex = queue[queueHead++];

    for (const v of graph[vertex]){
      if (v < 0 || v >= graph.length || visitedVertices[v]) continue;
      queue.push(v);
      ret.push(v);
      visitedVertices[v] = true;
    }
  }

  return ret;
}

module.exports = { bfs };
