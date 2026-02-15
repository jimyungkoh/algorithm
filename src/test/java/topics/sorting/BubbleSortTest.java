package topics.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Nested
    @DisplayName("sort()")
    class SortMethod {
        @Test
        @DisplayName("null 배열이면 예외를 던진다")
        void throwsWhenInputIsNull() {
            assertThrows(IllegalArgumentException.class, () -> bubbleSort.sort(null));
        }

        @Test
        @DisplayName("빈 배열이면 빈 배열 복사본을 반환한다")
        void returnsSortedCopyWhenInputIsEmpty() {
            assertSorted(new int[]{}, new int[]{});
        }

        @Test
        @DisplayName("정렬되지 않은 배열을 오름차순으로 정렬한다")
        void sortsUnsortedArrayAscending() {
            assertSorted(new int[]{5, 3, 1, 4, 2}, new int[]{1, 2, 3, 4, 5});
        }

        @Test
        @DisplayName("중복 값이 있어도 오름차순으로 정렬한다")
        void sortsArrayWithDuplicates() {
            assertSorted(new int[]{3, 1, 2, 3, 2}, new int[]{1, 2, 2, 3, 3});
        }

        @Test
        @DisplayName("음수가 포함되어도 오름차순으로 정렬한다")
        void sortsArrayWithNegativeNumbers() {
            assertSorted(new int[]{-1, 3, 0, -2, 5}, new int[]{-2, -1, 0, 3, 5});
        }

        @Test
        @DisplayName("원본 배열은 변경하지 않는다")
        void doesNotMutateInputArray() {
            int[] input = {5, 1, 4, 2, 8};
            int[] original = Arrays.copyOf(input, input.length);

            bubbleSort.sort(input);

            assertArrayEquals(original, input);
        }
    }


    private void assertSorted(int[] input, int[] expected) {
        int[] original = Arrays.copyOf(input, input.length);
        int[] sorted = bubbleSort.sort(input);
        assertArrayEquals(expected, sorted);
        assertArrayEquals(original, input);
        assertNotSame(input, sorted);
    }
}
