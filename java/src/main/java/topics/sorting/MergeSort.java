package topics.sorting;

import java.util.Arrays;

/**
 * 병합 정렬 학습용 템플릿.
 * <p>
 * 목표:
 * - 시간 복잡도 O(n log n)
 * - 추가 공간 O(n)
 * </p>
 *
 * <p>
 * 구현 계약:
 * - 입력이 null이면 IllegalArgumentException을 던진다.
 * - 입력 배열은 변경하지 않는다.
 * - 오름차순으로 정렬된 새 배열을 반환한다.
 * </p>
 */
public class MergeSort implements Sort {

  @Override
  public int[] sort(int[] input) {
    if (input == null) throw new IllegalArgumentException("null 입력은 지원하지 않습니다.");

    int[] sorted = Arrays.copyOf(input, input.length);

    if (sorted.length <= 1) return sorted;

    return mergeSort(sorted);
  }

  private int[] mergeSort(int[] arr) {
    if (arr.length <= 1) return arr;

    int[] lArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
    int[] rArr = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

    return merge(lArr, rArr);
  }

  private int[] merge(int[] leftArr, int[] rightArr) {
    int[] mergedArr = new int[leftArr.length + rightArr.length];
    int retPointer = 0;
    int lPointer = 0;
    int rPointer = 0;

    while (lPointer != leftArr.length || rPointer != rightArr.length) {
      if (lPointer == leftArr.length) {
        mergedArr[retPointer++] = rightArr[rPointer++];
        continue;
      } else if (rPointer == rightArr.length) {
        mergedArr[retPointer++] = leftArr[lPointer++];
        continue;
      }

      if (leftArr[lPointer] <= rightArr[rPointer]) {
        mergedArr[retPointer++] = leftArr[lPointer++];
      } else {
        mergedArr[retPointer++] = rightArr[rPointer++];
      }
    }

    return mergedArr;
  }
}
