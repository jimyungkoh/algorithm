package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchingTest {

    private final Matching matching = new Matching();

    @Nested
    @DisplayName("maximumBipartiteMatching()")
    class MatchingMethod {
        @Test
        @DisplayName("왼쪽 정점이 비어 있으면 빈 배열을 반환한다")
        void returnsEmptyWhenLeftIsEmpty() {
            assertEquals(0, matching.maximumBipartiteMatching(new int[][]{}, 3).length);
        }

        @Test
        @DisplayName("우측 정점 개수가 0이면 예외를 던진다")
        void throwsWhenRightCountIsZero() {
            assertThrows(IllegalArgumentException.class, () -> matching.maximumBipartiteMatching(new int[][]{{0}}, 0));
        }

        @Test
        @DisplayName("그래프가 null이면 예외를 던진다")
        void throwsWhenGraphIsNull() {
            assertThrows(IllegalArgumentException.class, () -> matching.maximumBipartiteMatching(null, 3));
        }

        @Test
        @DisplayName("간선이 없는 경우 매칭 크기가 0이다")
        void returnsNoMatchingWhenNoEdges() {
            int[] result = matching.maximumBipartiteMatching(new int[][]{{}, {}, {}}, 4);
            assertEquals(0, matchingSize(result));
            assertValid(result, 4);
        }

        @Test
        @DisplayName("단순 매칭 케이스를 정확히 계산한다")
        void computesSimpleMatching() {
            int[] result = matching.maximumBipartiteMatching(
                    new int[][]{
                            {0},
                            {1},
                            {2}
                    },
                    3
            );

            assertEquals(3, matchingSize(result));
            assertValid(result, 3);
            assertEquals(0, result[0]);
            assertEquals(1, result[1]);
            assertEquals(2, result[2]);
        }

        @Test
        @DisplayName("중복 간선이 있어도 최적 매칭 크기를 유지한다")
        void handlesDuplicateEdges() {
            int[] result = matching.maximumBipartiteMatching(
                    new int[][]{
                            {0, 0, 1, 1},
                            {1},
                            {2}
                    },
                    3
            );

            assertEquals(3, matchingSize(result));
            assertValid(result, 3);
        }

        @Test
        @DisplayName("공유 리소스를 재분배해 최대 매칭 크기를 만든다")
        void choosesMaximumMatchingForConflicts() {
            int[] result = matching.maximumBipartiteMatching(
                    new int[][]{
                            {0, 1},
                            {1},
                            {0, 2}
                    },
                    3
            );

            assertEquals(3, matchingSize(result));
            assertValid(result, 3);
        }

        @Test
        @DisplayName("매칭되지 않은 정점은 -1을 가진다")
        void keepsUnmatchedLeftVertexAsMinusOne() {
            int[] result = matching.maximumBipartiteMatching(
                    new int[][]{
                            {0},
                            {0},
                            {}
                    },
                    1
            );

            assertEquals(1, matchingSize(result));
            assertEquals(-1, result[2]);
            assertValid(result, 1);
        }
    }

    private int matchingSize(int[] matching) {
        int size = 0;
        for (int match : matching) {
            if (match != -1) size++;
        }
        return size;
    }

    private void assertValid(int[] matching, int rightCount) {
        Set<Integer> matched = new HashSet<>();

        for (int matchedRight : matching) {
            if (matchedRight == -1) continue;
            assertTrue(matchedRight >= 0 && matchedRight < rightCount);
            assertFalse(matched.contains(matchedRight));
            matched.add(matchedRight);
        }
    }
}
