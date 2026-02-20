package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimTest {

    private final Prim prim = new Prim();

    @Nested
    @DisplayName("prim()")
    class PrimMethod {
        @Test
        @DisplayName("정점 수가 0이면 예외를 던진다")
        void throwsWhenVertexCountIsZero() {
            assertThrows(IllegalArgumentException.class, () -> prim.prim(0, new int[][]{}, 0));
        }

        @Test
        @DisplayName("간선이 null이면 예외를 던진다")
        void throwsWhenEdgesIsNull() {
            assertThrows(IllegalArgumentException.class, () -> prim.prim(3, null, 0));
        }

        @Test
        @DisplayName("시작 정점이 범위를 벗어나면 예외를 던진다")
        void throwsWhenStartIsOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> prim.prim(3, new int[][]{}, 5));
        }

        @Test
        @DisplayName("정점이 하나면 빈 배열을 반환한다")
        void returnsEmptyForSingleVertex() {
            assertEquals(0, prim.prim(1, new int[][]{}, 0).length);
        }

        @Test
        @DisplayName("연결된 그래프의 MST를 계산한다")
        void computesMstInConnectedGraph() {
            int[][] mst = prim.prim(
                    4,
                    new int[][]{
                            {0, 1, 1},
                            {0, 2, 2},
                            {1, 2, 4},
                            {1, 3, 6},
                            {2, 3, 3},
                            {0, 3, 5}
                    },
                    0
            );

            assertMstEdges(
                    mst,
                    new int[][]{
                            {0, 1, 1},
                            {0, 2, 2},
                            {2, 3, 3}
                    }
            );
        }

        @Test
        @DisplayName("연결되지 않은 그래프는 빈 배열을 반환한다")
        void returnsEmptyWhenDisconnected() {
            assertEquals(0, prim.prim(4, new int[][]{{0, 1, 1}, {2, 3, 1}}, 0).length);
        }

        @Test
        @DisplayName("음수 간선도 포함해 MST를 계산한다")
        void computesMstWithNegativeWeightEdges() {
            int[][] mst = prim.prim(
                    3,
                    new int[][]{
                            {0, 1, -2},
                            {1, 2, -1},
                            {0, 2, 5}
                    },
                    0
            );

            assertMstEdges(
                    mst,
                    new int[][]{
                            {0, 1, -2},
                            {1, 2, -1}
                    }
            );
        }
    }

    private void assertMstEdges(int[][] actual, int[][] expected) {
        assertTrue(Arrays.deepEquals(normalize(actual), normalize(expected)));
    }

    private int[][] normalize(int[][] edges) {
        int[][] normalized = Arrays.stream(edges)
                .map(edge -> {
                    int from = Math.min(edge[0], edge[1]);
                    int to = Math.max(edge[0], edge[1]);
                    return new int[]{from, to, edge[2]};
                })
                .toArray(int[][]::new);

        Arrays.sort(
                normalized,
                Comparator.comparingInt((int[] edge) -> edge[0])
                        .thenComparingInt(edge -> edge[1])
                        .thenComparingInt(edge -> edge[2])
        );

        return normalized;
    }
}
