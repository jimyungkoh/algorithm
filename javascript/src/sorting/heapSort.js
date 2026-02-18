/**
 * Sort numbers in ascending order.
 * Target complexity: O(n log n).
 * Contract:
 * - throw if input is null
 * - return a new sorted array
 * - do not mutate the input array
 */
function heapSort(input) {
  if (!Array.isArray(input)) throw Error("배열이 아닌 입력은 지원하지 않습니다.");

  let sorted = [...input];

  // 1. 최대 힙을 구한다.
  for (let i = Math.floor(sorted.length / 2) - 1; i >= 0; i--){
    sorted = heapify({ arr:sorted, idx:i });
  }

  /**
   * 2. 0번째 요소는 항상 최대 힙의 정점이므로,
   *  배열 끝부터 시작하는 i번째 인덱스의 값과 교환해주는 과정을 거치면, 오름차순 배열이 된다.
   **/
  for (let i  = sorted.length - 1; i > 0; i--){
    [sorted[0], sorted[i]] = [sorted[i], sorted[0]];

    sorted = heapify({ arr:sorted, idx:0, length: i });
  }

  return sorted;
}

function heapify({ arr, idx, length = arr.length }){
  let largestIdx = idx;

  const [lChildIdx, rChildIdx] = [2 * idx + 1, 2 * idx + 2];
  if (lChildIdx < length && arr[lChildIdx] > arr[largestIdx]) {
    largestIdx = lChildIdx;
  }

  if (rChildIdx < length && arr[rChildIdx] > arr[largestIdx])
    largestIdx =  rChildIdx;

  if (idx === largestIdx) return arr;

  [arr[idx], arr[largestIdx]] = [arr[largestIdx], arr[idx]];
  return heapify({ arr, idx:largestIdx, length });
}

module.exports = { heapSort };
