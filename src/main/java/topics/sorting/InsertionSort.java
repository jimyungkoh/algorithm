package topics.sorting;

import java.util.Arrays;

public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("input must not be null");
        }

        int[] sorted = Arrays.copyOf(input, input.length);

        if (sorted.length <= 1) return sorted;

        for (int idx = 1; idx < sorted.length; idx++) {
            int currentIdx = idx;
            for (int prevIdx = idx - 1; prevIdx >= 0; prevIdx--) {
                if (sorted[prevIdx] <= sorted[currentIdx]) break;
                int prevVal = sorted[prevIdx];

                sorted[prevIdx] = sorted[currentIdx];
                sorted[currentIdx] = prevVal;
                currentIdx = prevIdx;
            }
        }

        return sorted;
    }
}
