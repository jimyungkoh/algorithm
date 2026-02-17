/**
 * Sort numbers in ascending order.
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function bubbleSort(input) {
  if (input === null || input === undefined) throw Error("null | undefined 입력은 지원하지 않습니다");
  else if (!Array.isArray(input)) throw Error("배열이 아닌 값은 입력할 수 없습니다.");

  if (input?.length === 0) return [...input];

  const sorted = [...input];
  for (let i = 0 ; i < sorted.length; i++){
    let flag = false;
    for (let j = 0; j < sorted.length - 1 - i; j++){
      if (sorted[j] <= sorted[j + 1]) continue;
      flag = true;
      [sorted[j], sorted[j + 1]] = [sorted[j + 1], sorted[j]];
    }

    if (!flag) return sorted;
  }

  return sorted;
}

module.exports = { bubbleSort };
