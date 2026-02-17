/**
 * Sort numbers in ascending order.
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function insertionSort(input) {
  if (input === null || input === undefined) throw new Error("null | undefined 입력은 지원하지 않습니다.");
  else if (!Array.isArray(input)) throw new Error("배열이 아닌 값은 입력할 수 없습니다.");


}

module.exports = { insertionSort };
