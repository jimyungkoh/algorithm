package topics.sorting;

import java.util.Arrays;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("input must not be null");
        }

        int[] sorted = Arrays.copyOf(input, input.length);

        if (sorted.length < 2) {
            return sorted;
        }

        for (int i = 0; i < sorted.length - 1; i++) {
            int min = sorted[i];
            int minIndex = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] >= min) continue;

                min = sorted[j];
                minIndex = j;
            }

            sorted[minIndex] = sorted[i];
            sorted[i] = min;
        }
        return sorted;
    }
}
