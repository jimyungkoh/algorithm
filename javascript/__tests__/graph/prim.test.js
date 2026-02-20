const { prim } = require("../../src/graph/prim");

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

describe("prim", () => {
  describe("prim()", () => {
    test("정점이 1개면 빈 배열을 반환한다", () => {
      expect(prim(1, [], 0)).toEqual([]);
    });

    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => prim(3, null, 0)).toThrow();
    });

    test("시작 정점이 범위를 벗어나면 예외를 던진다", () => {
      expect(() => prim(3, [[0, 1, 1]], 5)).toThrow();
    });

    test("연결된 그래프에서 MST를 계산한다", () => {
      const result = prim(
        4,
        [
          [0, 1, 1],
          [0, 2, 2],
          [1, 2, 4],
          [1, 3, 6],
          [2, 3, 3],
          [0, 3, 5]
        ],
        0
      );

      assertMstEdges(result, [
        [0, 1, 1],
        [0, 2, 2],
        [2, 3, 3]
      ]);
    });

    test("연결되지 않은 그래프는 빈 배열을 반환한다", () => {
      expect(
        prim(
          4,
          [
            [0, 1, 1],
            [2, 3, 2]
          ],
          0
        )
      ).toEqual([]);
    });

    test("시작 정점에 따라 계산해도 동일한 가중치의 MST를 만든다", () => {
      const fromZero = normalizeEdges(
        prim(
          4,
          [
            [0, 1, 1],
            [0, 2, 2],
            [1, 2, 4],
            [1, 3, 6],
            [2, 3, 3],
            [0, 3, 5]
          ],
          0
        )
      );

      const fromTwo = normalizeEdges(
        prim(
          4,
          [
            [0, 1, 1],
            [0, 2, 2],
            [1, 2, 4],
            [1, 3, 6],
            [2, 3, 3],
            [0, 3, 5]
          ],
          2
        )
      );

      const expected = normalizeEdges([
        [0, 1, 1],
        [0, 2, 2],
        [2, 3, 3]
      ]);

      expect(fromZero).toEqual(expected);
      expect(fromTwo).toEqual(expected);
    });

    test("음수 간선을 포함한 그래프에서도 MST를 계산한다", () => {
      assertMstEdges(
        prim(
          3,
          [
            [0, 1, -2],
            [1, 2, -1],
            [0, 2, 5]
          ],
          0
        ),
        [
          [0, 1, -2],
          [1, 2, -1]
        ]
      );
    });
  });
});
