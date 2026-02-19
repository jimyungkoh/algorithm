/**
 * Sort numbers in ascending order.
 * Target complexity: average O(n log n).
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function quickSort(input) {
  if (!Array.isArray(input)) throw Error("배열이 아닌 입력은 지원하지 않습니다.");
  return sort([...input]);
}

function sort(arr, startIdx = 0, pivotIdx = arr.length - 1){
  let lp = startIdx;

  for (let rp = startIdx; rp < pivotIdx; rp++){
    if (arr[rp] >= arr[pivotIdx]) continue;

    [arr[lp], arr[rp]] = [arr[rp], arr[lp]];
    lp++;
  }

  [arr[lp],arr[pivotIdx]] = [arr[pivotIdx], arr[lp]];

  if (startIdx < lp - 1)
    sort(arr, startIdx, lp - 1);
  if (lp + 1 < pivotIdx)
    sort(arr,  lp + 1,pivotIdx);

  return arr;
}

module.exports = { quickSort };
