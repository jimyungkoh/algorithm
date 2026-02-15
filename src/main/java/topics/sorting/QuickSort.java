package topics.sorting;

import java.util.Arrays;

/**
 * 퀵 정렬 학습용 템플릿.
 * <p>
 * 목표:
 * - 평균 시간 복잡도 O(n log n)
 * - 최악 시간 복잡도 O(n^2)
 * - 추가 공간 O(log n) 내외(재귀 호출 스택 기준)
 * </p>
 *
 * <p>
 * 구현 계약:
 * - 입력이 null이면 IllegalArgumentException을 던진다.
 * - 입력 배열은 변경하지 않는다.
 * - 오름차순으로 정렬된 새 배열을 반환한다.
 * </p>
 */
public class QuickSort implements Sort {

  @Override
  public int[] sort(int[] input) {
    if (input == null) throw new IllegalArgumentException("null은 지원하지 않습니다.");

    int[] copiedArr = Arrays.copyOf(input, input.length);

    if (copiedArr.length <= 1) return copiedArr;

    return quickSort(copiedArr, 0, copiedArr.length - 1);
  }

  private int[] quickSort(int[] arr, int startIdx, int endIdx) {
    if (startIdx >= endIdx) return arr;
    int lIdx = startIdx;

    for (int rIdx = lIdx; rIdx < endIdx; rIdx++) {
      if (arr[rIdx] <= arr[endIdx]) {
        int tmp = arr[rIdx];
        arr[rIdx] = arr[lIdx];
        arr[lIdx] = tmp;
        lIdx++;
      }
    }

    int tmp = arr[lIdx];
    arr[lIdx] = arr[endIdx];
    arr[endIdx] = tmp;

    quickSort(arr, startIdx, lIdx - 1);
    quickSort(arr, lIdx + 1, endIdx);

    return arr;
  }
}
