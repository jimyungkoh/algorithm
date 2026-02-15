package topics.sorting;

import java.util.Arrays;

/**
 * 힙 정렬 학습용 템플릿.
 * <p>
 * 목표:
 * - 시간 복잡도 O(n log n)
 * - 추가 공간 O(1) (입력 복사본 내부에서 제자리 정렬)
 * </p>
 */
public class HeapSort implements Sort {
  @Override
  public int[] sort(int[] input) {
    if (input == null) throw new IllegalArgumentException("Null is not arr");

    int[] sorted = Arrays.copyOf(input, input.length);

    if (sorted.length == 1) return sorted;

    for (int i = sorted.length / 2 - 1; i >= 0; i--) {
      heapify(sorted, i, sorted.length);
    }

    for (int i = sorted.length - 1; i > 0; i--) {
      sorted = swap(0, i, sorted);
      sorted = heapify(sorted, 0, i);
    }

    return sorted;
  }

  private int[] heapify(int[] arr, int idx, int length) {
    int currentIdx = idx;

    while (true) {
      int largestIdx = currentIdx;
      int leftChildIdx = 2 * currentIdx + 1;
      int rightChildIdx = 2 * currentIdx + 2;

      if (leftChildIdx < length && arr[leftChildIdx] > arr[largestIdx]) {
        largestIdx = leftChildIdx;
      }

      if (rightChildIdx < length && arr[rightChildIdx] > arr[largestIdx]) {
        largestIdx = rightChildIdx;
      }

      if (currentIdx == largestIdx) return arr;

      swap(currentIdx, largestIdx, arr);
      currentIdx = largestIdx;
    }
  }

  private int[] swap(int idx1, int idx2, int[] arr) {
    int tmp = arr[idx1];

    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;

    return arr;
  }
}
