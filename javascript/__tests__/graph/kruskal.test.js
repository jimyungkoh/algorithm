const { kruskal } = require("../../src/graph/kruskal");

function normalizeEdges(edges) {
  return edges
    .map(([from, to, weight]) => {
      const a = Math.min(from, to);
      const b = Math.max(from, to);
      return [a, b, weight];
    })
    .sort(([a1, b1, w1], [a2, b2, w2]) => {
      if (a1 !== a2) return a1 - a2;
      if (b1 !== b2) return b1 - b2;
      return w1 - w2;
    });
}

function assertMstEdges(actual, expected) {
  expect(normalizeEdges(actual)).toEqual(normalizeEdges(expected));
}

describe("kruskal", () => {
  describe("kruskal()", () => {
    test("정점이 1개면 빈 배열을 반환한다", () => {
      expect(kruskal(1, [[0, 0, 5]])).toEqual([]);
    });

    test("정점 개수가 0이면 예외를 던진다", () => {
      expect(() => kruskal(0, [])).toThrow();
    });

    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => kruskal(3, null)).toThrow();
    });

    test("단순한 연결 그래프의 MST를 계산한다", () => {
      const result = kruskal(
        4,
        [
          [0, 1, 1],
          [0, 2, 2],
          [1, 2, 4],
          [1, 3, 6],
          [2, 3, 3],
          [0, 3, 5]
        ]
      );

      assertMstEdges(result, [
        [0, 1, 1],
        [0, 2, 2],
        [2, 3, 3]
      ]);
    });

    test("연결되지 않은 그래프는 빈 배열을 반환한다", () => {
      expect(
        kruskal(
          4,
          [
            [0, 1, 1],
            [2, 3, 1]
          ]
        )
      ).toEqual([]);
    });

    test("중복 간선에서 더 작은 가중치를 우선한다", () => {
      expect(
        normalizeEdges(
          kruskal(
            3,
            [
              [0, 1, 8],
              [0, 1, 3],
              [1, 2, 4],
              [0, 2, 10]
            ]
          )
        )
      ).toEqual(
        normalizeEdges([
          [0, 1, 3],
          [1, 2, 4]
        ])
      );
    });

    test("사이클을 만들 수 있는 간선은 제외한다", () => {
      const result = kruskal(
        4,
        [
          [0, 1, 1],
          [0, 2, 2],
          [1, 2, 3],
          [1, 3, 4],
          [2, 3, 5]
        ]
      );

      assertMstEdges(result, [
        [0, 1, 1],
        [0, 2, 2],
        [1, 3, 4]
      ]);
    });

    test("음수 가중치도 정상 처리한다", () => {
      const result = kruskal(
        3,
        [
          [0, 1, -5],
          [1, 2, -1],
          [0, 2, 4]
        ]
      );

      assertMstEdges(result, [
        [0, 1, -5],
        [1, 2, -1]
      ]);
    });
  });
});
