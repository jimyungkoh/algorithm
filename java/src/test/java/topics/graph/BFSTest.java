package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BFSTest {

    private final BFS bfs = new BFS();

    @Nested
    @DisplayName("bfs()")
    class BFSMethod {
        @Test
        @DisplayName("그래프가 null이면 예외를 던진다")
        void throwsWhenGraphIsNull() {
            assertThrows(IllegalArgumentException.class, () -> bfs.bfs(null, 0));
        }

        @Test
        @DisplayName("정점이 비어 있으면 예외를 던진다")
        void throwsWhenGraphIsEmpty() {
            assertThrows(IllegalArgumentException.class, () -> bfs.bfs(new int[][]{}, 0));
        }

        @Test
        @DisplayName("시작 정점이 범위를 벗어나면 예외를 던진다")
        void throwsWhenStartIsOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> bfs.bfs(new int[][]{{1}, {}}, 2));
        }

        @Test
        @DisplayName("정점이 하나면 시작 정점만 방문한다")
        void visitsSingleVertexOnly() {
            assertOrder(new int[][]{{}}, 0, new int[]{0});
        }

        @Test
        @DisplayName("단일 경로를 레벨 순서로 순회한다")
        void traversesLinearGraphLevelOrder() {
            assertOrder(new int[][]{{1}, {2}, {3}, {}}, 0, new int[]{0, 1, 2, 3});
        }

        @Test
        @DisplayName("균형 잡힌 그래프를 계층 순서로 순회한다")
        void traversesBalancedGraphLevelOrder() {
            assertOrder(new int[][]{{1, 2}, {3}, {3, 4}, {4}, {}}, 0, new int[]{0, 1, 2, 3, 4});
        }

        @Test
        @DisplayName("사이클이 있어도 중복 방문하지 않는다")
        void doesNotRevisitOnCycle() {
            assertOrder(new int[][]{{1, 2}, {0, 2}, {3}, {1}, {}}, 0, new int[]{0, 1, 2, 3});
        }

        @Test
        @DisplayName("도달 가능한 정점만 방문한다")
        void visitsReachableVerticesOnly() {
            assertOrder(new int[][]{{1}, {0}, {3}, {2}, {}}, 0, new int[]{0, 1});
        }

        @Test
        @DisplayName("중복 간선을 포함해도 한 번만 방문한다")
        void handlesDuplicateEdges() {
            assertOrder(new int[][]{{1, 1, 2}, {2}, {}, {}}, 0, new int[]{0, 1, 2});
        }
    }

    private void assertOrder(int[][] graph, int start, int[] expected) {
        int[] actual = bfs.bfs(graph, start);

        assertArrayEquals(expected, actual);
        assertUnique(actual);
    }

    private void assertUnique(int[] order) {
        HashSet<Integer> set = new HashSet<>();
        for (int node : order) {
            assertFalse(set.contains(node));
            set.add(node);
        }
    }
}
