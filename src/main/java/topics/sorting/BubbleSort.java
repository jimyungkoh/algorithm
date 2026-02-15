package topics.sorting;

import java.util.Arrays;

public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("input must not be null");
        }

        int[] sorted = Arrays.copyOf(input, input.length);
        if (sorted.length < 2) {
            return sorted;
        }

        for (int end = sorted.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (sorted[i] <= sorted[i + 1]) {
                    continue;
                }

                int temp = sorted[i];
                sorted[i] = sorted[i + 1];
                sorted[i + 1] = temp;
                swapped = true;
            }

            if (!swapped) {
                break;
            }
        }

        return sorted;
    }
}
