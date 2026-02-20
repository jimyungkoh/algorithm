const { aStar } = require("../../src/graph/aStar");

describe("aStar", () => {
  describe("aStar()", () => {
    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => aStar(3, null, [0, 0, 0], 0, 2)).toThrow();
    });

    test("시작 정점이 목표 정점이면 시작 정점만 반환한다", () => {
      const result = aStar(
        3,
        [
          [0, 1, 4],
          [1, 2, 5]
        ],
        [1, 0, 0],
        1,
        1
      );

      expect(result).toEqual([1]);
    });

    test("최단 비용 경로를 노드 순서대로 복원한다", () => {
      const result = aStar(
        6,
        [
          [0, 1, 2],
          [0, 2, 4],
          [1, 3, 2],
          [2, 3, 1],
          [3, 5, 5],
          [2, 4, 7],
          [4, 5, 1]
        ],
        [6, 4, 2, 1, 3, 0],
        0,
        5
      );

      expect(result).toEqual([0, 1, 3, 5]);
    });

    test("연결되지 않은 경우 빈 배열을 반환한다", () => {
      const result = aStar(
        4,
        [
          [0, 1, 1],
          [1, 2, 1]
        ],
        [0, 0, 0, 0],
        2,
        0
      );

      expect(result).toEqual([]);
    });

    test("중복 간선이 있어도 경로 복원이 일관되어야 한다", () => {
      const result = aStar(
        5,
        [
          [0, 1, 1],
          [0, 1, 2],
          [1, 2, 2],
          [0, 2, 5],
          [2, 3, 2],
          [3, 4, 1]
        ],
        [6, 4, 3, 1, 0],
        0,
        4
      );

      expect(result).toEqual([0, 1, 2, 3, 4]);
    });
  });
});
