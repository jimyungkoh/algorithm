const { maximumBipartiteMatching } = require("../../src/graph/matching");

function toMatchingSize(matching) {
  return matching.filter((value) => value !== -1).length;
}

function assertValidMatching(matching, rightCount) {
  const used = new Set();

  for (const matchedRight of matching) {
    if (matchedRight === -1) continue;
    expect(matchedRight).toBeGreaterThanOrEqual(0);
    expect(matchedRight).toBeLessThan(rightCount);
    expect(used.has(matchedRight)).toBe(false);
    used.add(matchedRight);
  }
}

describe("maximumBipartiteMatching", () => {
  describe("maximumBipartiteMatching()", () => {
    test("왼쪽 정점이 비어 있으면 빈 배열을 반환한다", () => {
      expect(maximumBipartiteMatching([], 3)).toEqual([]);
    });

    test("우측 정점 개수가 0이면 예외를 던진다", () => {
      expect(() => maximumBipartiteMatching([[0]], 0)).toThrow();
    });

    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => maximumBipartiteMatching(null, 3)).toThrow();
    });

    test("간선이 없는 정점은 매칭되지 않는다", () => {
      const matching = maximumBipartiteMatching([[ ], [ ], [ ]], 4);
      expect(toMatchingSize(matching)).toBe(0);
      expect(matching).toEqual([-1, -1, -1]);
      assertValidMatching(matching, 4);
    });

    test("단순한 매칭 케이스를 정확히 계산한다", () => {
      const matching = maximumBipartiteMatching(
        [
          [0],
          [1],
          [2]
        ],
        3
      );

      expect(toMatchingSize(matching)).toBe(3);
      expect(matching).toEqual([0, 1, 2]);
      assertValidMatching(matching, 3);
    });

    test("중복 간선이 있어도 매칭 크기가 유지된다", () => {
      const matching = maximumBipartiteMatching(
        [
          [0, 0, 1, 1],
          [1],
          [2]
        ],
        3
      );

      expect(toMatchingSize(matching)).toBe(3);
      assertValidMatching(matching, 3);
    });

    test("공유 자원이 많은 경우에도 최대 매칭 크기를 보장한다", () => {
      const matching = maximumBipartiteMatching(
        [
          [0, 1],
          [1],
          [1, 2]
        ],
        3
      );

      expect(toMatchingSize(matching)).toBe(3);
      assertValidMatching(matching, 3);
    });

    test("매칭되지 않는 좌측 정점은 -1을 가진다", () => {
      const matching = maximumBipartiteMatching(
        [
          [0],
          [0],
          []
        ],
        1
      );

      expect(toMatchingSize(matching)).toBe(1);
      expect(matching[2]).toBe(-1);
      assertValidMatching(matching, 1);
    });
  });
});
