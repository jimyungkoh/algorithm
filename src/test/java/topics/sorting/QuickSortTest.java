package topics.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Nested
    @DisplayName("sort()")
    class SortMethod {
        @Test
        @DisplayName("null 배열이면 예외를 던진다")
        void throwsWhenInputIsNull() {
            assertThrows(IllegalArgumentException.class, () -> quickSort.sort(null));
        }

        @Test
        @DisplayName("빈 배열이면 빈 배열 복사본을 반환한다")
        void returnsSortedCopyWhenInputIsEmpty() {
            assertSorted(new int[]{}, new int[]{});
        }

        @Test
        @DisplayName("원소가 하나면 동일 값 복사본을 반환한다")
        void returnsSortedCopyWhenInputHasSingleElement() {
            assertSorted(new int[]{7}, new int[]{7});
        }

        @Test
        @DisplayName("원소가 두 개인 역순 배열을 정렬한다")
        void sortsTwoElementsReversed() {
            assertSorted(new int[]{2, 1}, new int[]{1, 2});
        }

        @Test
        @DisplayName("정렬되지 않은 배열을 오름차순으로 정렬한다")
        void sortsUnsortedArrayAscending() {
            assertSorted(new int[]{5, 3, 1, 4, 2}, new int[]{1, 2, 3, 4, 5});
        }

        @Test
        @DisplayName("이미 정렬된 배열은 그대로 유지한다")
        void keepsAlreadySortedArray() {
            assertSorted(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        }

        @Test
        @DisplayName("내림차순 배열을 오름차순으로 정렬한다")
        void sortsReverseSortedArrayAscending() {
            assertSorted(new int[]{9, 7, 5, 3, 1}, new int[]{1, 3, 5, 7, 9});
        }

        @Test
        @DisplayName("중복 값이 있어도 오름차순으로 정렬한다")
        void sortsArrayWithDuplicates() {
            assertSorted(new int[]{3, 1, 2, 3, 2}, new int[]{1, 2, 2, 3, 3});
        }

        @Test
        @DisplayName("음수와 0이 섞여 있어도 오름차순으로 정렬한다")
        void sortsArrayWithNegativeAndMixedNumbers() {
            assertSorted(new int[]{-1, 3, 0, -2, 5}, new int[]{-2, -1, 0, 3, 5});
        }

        @Test
        @DisplayName("반복 패턴이 있어도 오름차순으로 정렬한다")
        void sortsArrayWithRepeatedPattern() {
            assertSorted(new int[]{4, 1, 4, 1, 4, 1, 2, 2, 3, 3}, new int[]{1, 1, 1, 2, 2, 3, 3, 4, 4, 4});
        }

        @Test
        @DisplayName("정수 극값이 포함되어도 오름차순으로 정렬한다")
        void sortsArrayWithIntegerBoundaryValues() {
            assertSorted(
                    new int[]{0, Integer.MAX_VALUE, -1, Integer.MIN_VALUE, 1},
                    new int[]{Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE}
            );
        }

        @Test
        @DisplayName("원본 배열은 변경하지 않는다")
        void doesNotMutateInputArray() {
            int[] input = {5, 1, 4, 2, 8};
            int[] original = Arrays.copyOf(input, input.length);

            quickSort.sort(input);

            assertArrayEquals(original, input);
        }

        @Test
        @DisplayName("반환 배열은 입력 배열과 다른 참조다")
        void returnsDifferentReferenceFromInput() {
            int[] input = {4, 1, 3, 2};
            int[] sorted = quickSort.sort(input);

            assertNotSame(input, sorted);
        }
    }

    private void assertSorted(int[] input, int[] expected) {
        int[] original = Arrays.copyOf(input, input.length);
        int[] sorted = quickSort.sort(input);

        assertArrayEquals(expected, sorted);
        assertArrayEquals(original, input);
        assertNotSame(input, sorted);
    }
}
