package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DijkstraTest {

    private static final int INF = Integer.MAX_VALUE;
    private final Dijkstra dijkstra = new Dijkstra();

    @Nested
    @DisplayName("dijkstra()")
    class DijkstraMethod {
        @Test
        @DisplayName("그래프가 null이면 예외를 던진다")
        void throwsWhenEdgesIsNull() {
            assertThrows(IllegalArgumentException.class, () -> dijkstra.dijkstra(3, null, 0));
        }

        @Test
        @DisplayName("정점 수가 0이면 예외를 던진다")
        void throwsWhenVertexCountIsZero() {
            assertThrows(IllegalArgumentException.class, () -> dijkstra.dijkstra(0, new int[][]{}, 0));
        }

        @Test
        @DisplayName("시작 정점이 범위를 벗어나면 예외를 던진다")
        void throwsWhenStartIsOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> dijkstra.dijkstra(3, new int[][]{}, 5));
        }

        @Test
        @DisplayName("음수 간선이 있으면 예외를 던진다")
        void throwsWhenNegativeWeightExists() {
            assertThrows(IllegalArgumentException.class, () ->
                    dijkstra.dijkstra(
                            3,
                            new int[][]{
                                    {0, 1, -5},
                                    {1, 2, 2}
                            },
                            0
                    )
            );
        }

        @Test
        @DisplayName("최단거리 배열을 정확히 계산한다")
        void computesShortestPathWithNonNegativeEdges() {
            int[] distances = dijkstra.dijkstra(
                    5,
                    new int[][]{
                            {0, 1, 4},
                            {0, 2, 1},
                            {2, 1, 2},
                            {1, 3, 1},
                            {2, 3, 5},
                            {3, 4, 3},
                            {1, 4, 10}
                    },
                    0
            );

            assertArrayEquals(new int[]{0, 3, 1, 4, 7}, distances);
        }

        @Test
        @DisplayName("도달할 수 없는 정점은 INF를 반환한다")
        void returnsInfinityForUnreachableVertices() {
            int[] distances = dijkstra.dijkstra(
                    6,
                    new int[][]{
                            {0, 1, 7},
                            {1, 2, 2}
                    },
                    0
            );

            assertArrayEquals(new int[]{0, 7, 9, INF, INF, INF}, distances);
        }

        @Test
        @DisplayName("사이클이 있어도 최소거리가 안정적으로 계산된다")
        void handlesCyclesWithoutChangingResult() {
            int[] distances = dijkstra.dijkstra(
                    4,
                    new int[][]{
                            {0, 1, 1},
                            {1, 2, 2},
                            {2, 1, 2},
                            {2, 3, 1},
                            {1, 3, 10}
                    },
                    0
            );

            assertArrayEquals(new int[]{0, 1, 3, 4}, distances);
        }

        @Test
        @DisplayName("시작 정점만 있는 입력은 0 거리만 반환한다")
        void returnsSingleZeroDistance() {
            assertArrayEquals(new int[]{0}, dijkstra.dijkstra(1, new int[][]{}, 0));
        }
    }
}
