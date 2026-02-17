/**
 * Sort numbers in ascending order.
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function selectionSort(input) {
  if (input === null || input === undefined) throw new Error("null || undefined는 입력값이 될 수 없습니다.");
  else if (!Array.isArray(input)) throw new Error("배열이 아닌 값은 입력값이 될 수 없습니다.");

  const sorted = [...input];

  for (let i  = 0; i < sorted.length; i++){
    let minIdx = i;
    for (let j  = i + 1; j < sorted.length; j++){
      if (sorted[j] >= sorted[minIdx]) continue;
      minIdx = j;
    }
    [sorted[i], sorted[minIdx]] = [sorted[minIdx], sorted[i]];
  }

  return sorted;
}

module.exports = { selectionSort };
