package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KruskalTest {

    private final Kruskal kruskal = new Kruskal();

    @Nested
    @DisplayName("kruskal()")
    class KruskalMethod {
        @Test
        @DisplayName("정점 수가 0이면 예외를 던진다")
        void throwsWhenVertexCountIsZero() {
            assertThrows(IllegalArgumentException.class, () -> kruskal.kruskal(0, new int[][]{}));
        }

        @Test
        @DisplayName("간선이 null이면 예외를 던진다")
        void throwsWhenEdgesIsNull() {
            assertThrows(IllegalArgumentException.class, () -> kruskal.kruskal(3, null));
        }

        @Test
        @DisplayName("정점이 하나면 빈 배열을 반환한다")
        void returnsEmptyForSingleVertex() {
            assertEquals(0, kruskal.kruskal(1, new int[][]{}).length);
        }

        @Test
        @DisplayName("단순 연결 그래프의 MST를 계산한다")
        void computesMstInSimpleGraph() {
            int[][] mst = kruskal.kruskal(
                    4,
                    new int[][]{
                            {0, 1, 1},
                            {0, 2, 2},
                            {1, 2, 4},
                            {1, 3, 6},
                            {2, 3, 3},
                            {0, 3, 5}
                    }
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
            assertEquals(0, kruskal.kruskal(4, new int[][]{{0, 1, 1}, {2, 3, 1}}).length);
        }

        @Test
        @DisplayName("중복 간선에서는 더 작은 가중치를 택한다")
        void choosesSmallerWeightForDuplicateEdge() {
            int[][] mst = kruskal.kruskal(
                    3,
                    new int[][]{
                            {0, 1, 8},
                            {0, 1, 3},
                            {1, 2, 4},
                            {0, 2, 10}
                    }
            );

            assertMstEdges(
                    mst,
                    new int[][]{
                            {0, 1, 3},
                            {1, 2, 4}
                    }
            );
        }

        @Test
        @DisplayName("음수 간선도 허용해 MST를 계산한다")
        void computesMstWithNegativeWeights() {
            int[][] mst = kruskal.kruskal(
                    3,
                    new int[][]{
                            {0, 1, -5},
                            {1, 2, -1},
                            {0, 2, 4}
                    }
            );

            assertMstEdges(
                    mst,
                    new int[][]{
                            {0, 1, -5},
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
