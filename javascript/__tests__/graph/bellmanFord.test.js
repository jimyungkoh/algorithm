const { bellmanFord } = require("../../src/graph/bellmanFord");

const INF = Number.POSITIVE_INFINITY;

describe("bellmanFord", () => {
  describe("bellmanFord()", () => {
    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => bellmanFord(3, null, 0)).toThrow();
    });

    test("정점 개수가 0이면 예외를 던진다", () => {
      expect(() => bellmanFord(0, [], 0)).toThrow();
    });

    test("시작 정점이 범위를 벗어나면 예외를 던진다", () => {
      expect(() => bellmanFord(3, [[0, 1, 1]], 5)).toThrow();
    });

    test("음수 간선을 포함해도 최단거리를 정확히 계산한다", () => {
      const result = bellmanFord(
          4,
          [
            [0, 1, 4],
            [0, 2, 5],
            [2, 1, -2],
            [1, 3, 2],
            [2, 3, 3]
          ],
          0
      );

      expect(result).toEqual([0, 3, 5, 5]);
    });

    test("도달 불가능한 정점은 Infinity를 반환한다", () => {
      const result = bellmanFord(
          6,
          [
            [0, 1, 7],
            [1, 2, 2],
            [2, 3, 4]
          ],
          0
      );

      expect(result).toEqual([0, 7, 9, 13, INF, INF]);
    });

    test("시작 정점에서 음수 사이클이 있으면 예외를 던진다", () => {
      expect(() =>
        bellmanFord(
          3,
          [
            [0, 1, 1],
            [1, 2, -1],
            [2, 1, -1]
          ],
          0
        )
      ).toThrow();
    });

    test("출발 정점만 있는 입력도 정상 처리한다", () => {
      expect(bellmanFord(1, [], 0)).toEqual([0]);
    });
  });
});
