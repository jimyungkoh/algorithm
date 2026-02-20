const { dijkstra } = require("../../src/graph/dijkstra");

const INF = Number.POSITIVE_INFINITY;

describe("dijkstra", () => {
  describe("dijkstra()", () => {
    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => dijkstra(3, null, 0)).toThrow();
    });

    test("정점 개수가 0이면 예외를 던진다", () => {
      expect(() => dijkstra(0, [], 0)).toThrow();
    });

    test("시작 정점이 범위를 벗어나면 예외를 던진다", () => {
      expect(() => dijkstra(3, [[0, 1, 1]], 4)).toThrow();
    });

    test("음수 간선이 있으면 예외를 던진다", () => {
      expect(() => dijkstra(3, [[0, 1, -3]], 0)).toThrow();
    });

    test("단일 시작점 최단거리를 정확히 계산한다", () => {
      const result = dijkstra(
        5,
        [
          [0, 1, 4],
          [0, 2, 1],
          [2, 1, 2],
          [1, 3, 1],
          [2, 3, 5],
          [3, 4, 3],
          [1, 4, 10]
        ],
        0
      );

      expect(result).toEqual([0, 3, 1, 4, 7]);
    });

    test("도달 불가능한 정점은 Infinity를 반환한다", () => {
      const result = dijkstra(
        6,
        [
          [0, 1, 7],
          [1, 2, 2]
        ],
        0
      );

      expect(result).toEqual([0, 7, 9, INF, INF, INF]);
    });

    test("시작 정점만 있는 입력은 0 거리 배열을 반환한다", () => {
      expect(dijkstra(1, [], 0)).toEqual([0]);
    });

    test("사이클이 있어도 최소거리 계산이 안정적으로 동작한다", () => {
      const result = dijkstra(
        4,
        [
          [0, 1, 1],
          [1, 2, 2],
          [2, 1, 2],
          [2, 3, 1],
          [1, 3, 10]
        ],
        0
      );

      expect(result).toEqual([0, 1, 3, 4]);
    });
  });
});
