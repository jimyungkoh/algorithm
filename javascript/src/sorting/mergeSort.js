/**
 * Sort numbers in ascending order.
 * Target complexity: O(n log n).
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function mergeSort(input) {
  if (!Array.isArray(input)) throw new Error("배열이 아닌 입력은 지원하지 않습니다");

  return divideAndMerge([...input]);
}

function divideAndMerge(arr){
  if (arr.length <= 1) return arr;

  const midIdx = Math.floor(arr.length / 2);
  const lArr = divideAndMerge(arr.slice(0, midIdx));
  const rArr = divideAndMerge(arr.slice(midIdx));

  const mergedArr = [];
  let [lPointer, rPointer]  = [0,0];
  while (lPointer !== lArr.length || rPointer !== rArr.length){
    if (lPointer === lArr.length || rArr[rPointer] < lArr[lPointer])
      mergedArr.push(rArr[rPointer++]);
    else mergedArr.push(lArr[lPointer++]);
  }

  return mergedArr;
}

module.exports = { mergeSort };
