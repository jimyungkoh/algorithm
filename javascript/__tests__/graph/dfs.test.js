const { dfs } = require("../../src/graph/dfs");

describe("dfs", () => {
  describe("dfs()", () => {
    test("그래프가 null이면 예외를 던진다", () => {
      expect(() => dfs(null, 0)).toThrow();
    });

    test("그래프가 비어 있으면 시작 정점이 없어 예외를 던진다", () => {
      expect(() => dfs([], 0)).toThrow();
    });

    test("시작 정점이 범위를 벗어나면 예외를 던진다", () => {
      expect(() => dfs([[1], []], 2)).toThrow();
    });

    test("정점이 하나인 그래프는 시작 정점만 방문한다", () => {
      expect(dfs([[]], 0)).toEqual([0]);
    });

    test("단일 경로를 정확한 순서로 순회한다", () => {
      expect(dfs([[1], [2], [3], []], 0)).toEqual([0, 1, 2, 3]);
    });

    test("가지가 있는 그래프를 깊이 우선 순서로 순회한다", () => {
      expect(dfs([[1, 2], [3], [3], []], 0)).toEqual([0, 1, 3, 2]);
    });

    test("사이클이 있어도 중복 방문하지 않는다", () => {
      expect(dfs([[1, 2], [2], [1, 0], []], 0)).toEqual([0, 1, 2]);
    });

    test("도달 가능한 정점만 방문한다", () => {
      expect(dfs([[1], [], [3], []], 0)).toEqual([0, 1]);
    });

    test("중복 간선이 있어도 정점은 한 번만 방문한다", () => {
      expect(dfs([[1, 1, 2], [2, 2], [], [0]], 0)).toEqual([0, 1, 2]);
    });
  });
});
