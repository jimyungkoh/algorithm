const { mergeSort } = require("../../src/sorting/mergeSort");

const INT_MAX = 2147483647;
const INT_MIN = -2147483648;

function assertSorted(input, expected) {
  const original = [...input];
  const sorted = mergeSort(input);

  expect(sorted).toEqual(expected);
  expect(input).toEqual(original);
  expect(sorted).not.toBe(input);
}

describe("MergeSort", () => {
  describe("sort()", () => {
    test("throws when input is null", () => {
      expect(() => mergeSort(null)).toThrow();
    });

    test("returns a copy of empty array when input is empty", () => {
      assertSorted([], []);
    });

    test("returns a copy with same value for single element", () => {
      assertSorted([7], [7]);
    });

    test("sorts two reversed elements", () => {
      assertSorted([2, 1], [1, 2]);
    });

    test("sorts unsorted array ascending", () => {
      assertSorted([5, 3, 1, 4, 2], [1, 2, 3, 4, 5]);
    });

    test("keeps already sorted array", () => {
      assertSorted([1, 2, 3, 4, 5], [1, 2, 3, 4, 5]);
    });

    test("sorts reverse sorted array ascending", () => {
      assertSorted([9, 7, 5, 3, 1], [1, 3, 5, 7, 9]);
    });

    test("sorts array with duplicates ascending", () => {
      assertSorted([3, 1, 2, 3, 2], [1, 2, 2, 3, 3]);
    });

    test("sorts array with mixed negatives and zero", () => {
      assertSorted([-1, 3, 0, -2, 5], [-2, -1, 0, 3, 5]);
    });

    test("sorts repeated pattern ascending", () => {
      assertSorted([4, 1, 4, 1, 4, 1, 2, 2, 3, 3], [1, 1, 1, 2, 2, 3, 3, 4, 4, 4]);
    });

    test("sorts array with integer boundary values", () => {
      assertSorted([0, INT_MAX, -1, INT_MIN, 1], [INT_MIN, -1, 0, 1, INT_MAX]);
    });

    test("does not mutate input array", () => {
      const input = [5, 1, 4, 2, 8];
      const original = [...input];

      mergeSort(input);

      expect(input).toEqual(original);
    });

    test("returns different reference from input", () => {
      const input = [4, 1, 3, 2];
      const sorted = mergeSort(input);

      expect(sorted).not.toBe(input);
    });
  });
});
