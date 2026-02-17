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
  const sorted = [...input];


  for (let i = 1 ; i < sorted.length; i++){
    const val = sorted[i];

    let pointer = i - 1;

    while (true){
      if (pointer < 0 || sorted[pointer] <= val) break;
      sorted[pointer + 1] = sorted[pointer];
      pointer--;
    }

    sorted[pointer + 1] = val;
  }

  return sorted;
}

module.exports = { insertionSort };
