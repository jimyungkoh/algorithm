const { bubbleSort } = require("../../src/sorting/bubbleSort");
const { selectionSort } = require("../../src/sorting/selectionSort");
const { insertionSort } = require("../../src/sorting/insertionSort");
const { mergeSort } = require("../../src/sorting/mergeSort");
const { heapSort } = require("../../src/sorting/heapSort");
const { quickSort } = require("../../src/sorting/quickSort");

const sortImplementations = [
  ["bubbleSort", bubbleSort],
  ["selectionSort", selectionSort],
  ["insertionSort", insertionSort],
  ["mergeSort", mergeSort],
  ["heapSort", heapSort],
  ["quickSort", quickSort],
];

const sortCases = [
  ["empty array", [], []],
  ["single element", [7], [7]],
  ["already sorted", [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]],
  ["reverse sorted", [9, 7, 5, 3, 1], [1, 3, 5, 7, 9]],
  ["duplicates", [3, 1, 2, 3, 2], [1, 2, 2, 3, 3]],
  ["negative and mixed", [-1, 3, 0, -2, 5], [-2, -1, 0, 3, 5]],
  ["repeated pattern", [4, 1, 4, 1, 4, 1, 2, 2, 3, 3], [1, 1, 1, 2, 2, 3, 3, 4, 4, 4]],
  ["safe integer boundaries", [0, Number.MAX_SAFE_INTEGER, -1, Number.MIN_SAFE_INTEGER, 1], [Number.MIN_SAFE_INTEGER, -1, 0, 1, Number.MAX_SAFE_INTEGER]],
];

describe.each(sortImplementations)("%s", (_name, sortFn) => {
  test("throws when input is null", () => {
    expect(() => sortFn(null)).toThrow();
  });

  test.each(sortCases)("sorts %s", (_label, input, expected) => {
    const inputCopy = [...input];
    const sorted = sortFn(input);

    expect(sorted).toEqual(expected);
    expect(input).toEqual(inputCopy);
    expect(sorted).not.toBe(input);
  });
});
