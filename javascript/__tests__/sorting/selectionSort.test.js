const { selectionSort } = require("../../src/sorting/selectionSort");

function assertSorted(input, expected) {
  const original = [...input];
  const sorted = selectionSort(input);

  expect(sorted).toEqual(expected);
  expect(input).toEqual(original);
  expect(sorted).not.toBe(input);
}

describe("SelectionSort", () => {
  describe("sort()", () => {
    test("throws when input is null", () => {
      expect(() => selectionSort(null)).toThrow();
    });

    test("returns a copy of empty array when input is empty", () => {
      assertSorted([], []);
    });

    test("sorts unsorted array ascending", () => {
      assertSorted([5, 3, 1, 4, 2], [1, 2, 3, 4, 5]);
    });

    test("sorts array with duplicates ascending", () => {
      assertSorted([3, 1, 2, 3, 2], [1, 2, 2, 3, 3]);
    });

    test("sorts array with negative numbers ascending", () => {
      assertSorted([-1, 3, 0, -2, 5], [-2, -1, 0, 3, 5]);
    });

    test("does not mutate input array", () => {
      const input = [5, 1, 4, 2, 8];
      const original = [...input];

      selectionSort(input);

      expect(input).toEqual(original);
    });
  });
});
