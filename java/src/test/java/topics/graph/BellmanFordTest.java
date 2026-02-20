package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BellmanFordTest {

    private static final int INF = Integer.MAX_VALUE;
    private final BellmanFord bellmanFord = new BellmanFord();

    @Nested
    @DisplayName("bellmanFord()")
    class BellmanFordMethod {
        @Test
        @DisplayName("그래프가 null이면 예외를 던진다")
        void throwsWhenEdgesIsNull() {
            assertThrows(IllegalArgumentException.class, () -> bellmanFord.bellmanFord(3, null, 0));
        }

        @Test
        @DisplayName("정점 수가 0이면 예외를 던진다")
        void throwsWhenVertexCountIsZero() {
            assertThrows(IllegalArgumentException.class, () -> bellmanFord.bellmanFord(0, new int[][]{}, 0));
        }

        @Test
        @DisplayName("시작 정점이 범위를 벗어나면 예외를 던진다")
        void throwsWhenStartIsOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> bellmanFord.bellmanFord(3, new int[][]{}, 5));
        }

        @Test
        @DisplayName("음수 간선을 포함해도 최단거리를 정확히 계산한다")
        void computesShortestPathWithNegativeEdges() {
            int[] distances = bellmanFord.bellmanFord(
                    4,
                    new int[][]{
                            {0, 1, 4},
                            {0, 2, 5},
                            {2, 1, -2},
                            {1, 3, 2},
                            {2, 3, 3}
                    },
                    0
            );

            assertArrayEquals(new int[]{0, 3, 5, 5}, distances);
        }

        @Test
        @DisplayName("도달할 수 없는 정점은 INF를 반환한다")
        void returnsInfinityForUnreachableVertices() {
            int[] distances = bellmanFord.bellmanFord(
                    6,
                    new int[][]{
                            {0, 1, 7},
                            {1, 2, 2},
                            {2, 3, 4}
                    },
                    0
            );

            assertArrayEquals(new int[]{0, 7, 9, 13, INF, INF}, distances);
        }

        @Test
        @DisplayName("시작 정점에서 음수 사이클이 있으면 예외를 던진다")
        void throwsWhenNegativeCycleExists() {
            assertThrows(IllegalStateException.class, () ->
                    bellmanFord.bellmanFord(
                            3,
                            new int[][]{
                                    {0, 1, 1},
                                    {1, 2, -1},
                                    {2, 1, -1}
                            },
                            0
                    )
            );
        }

        @Test
        @DisplayName("정점이 하나면 시작 정점 거리만 0이다")
        void returnsZeroDistanceForSingleVertex() {
            assertArrayEquals(new int[]{0}, bellmanFord.bellmanFord(1, new int[][]{}, 0));
        }
    }
}
