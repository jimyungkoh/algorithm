package topics.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AStarTest {

    private final AStar aStar = new AStar();

    @Nested
    @DisplayName("aStar()")
    class AStarMethod {
        @Test
        @DisplayName("그래프가 null이면 예외를 던진다")
        void throwsWhenEdgesIsNull() {
            assertThrows(IllegalArgumentException.class, () -> aStar.aStar(3, null, new int[]{0, 0, 0}, 0, 2));
        }

        @Test
        @DisplayName("시작 정점이 목표 정점이면 시작 정점만 반환한다")
        void returnsSingleNodeWhenStartEqualsGoal() {
            int[] path = aStar.aStar(
                    3,
                    new int[][]{{0, 1, 1}, {1, 2, 1}},
                    new int[]{2, 0, 1},
                    1,
                    1
            );

            assertArrayEquals(new int[]{1}, path);
        }

        @Test
        @DisplayName("최단 비용 경로를 복원한다")
        void reconstructsShortestPath() {
            int[] path = aStar.aStar(
                    6,
                    new int[][]{
                            {0, 1, 2},
                            {0, 2, 4},
                            {1, 3, 2},
                            {2, 3, 1},
                            {3, 5, 5},
                            {2, 4, 7},
                            {4, 5, 1}
                    },
                    new int[]{6, 4, 2, 1, 3, 0},
                    0,
                    5
            );

            assertArrayEquals(new int[]{0, 1, 3, 5}, path);
        }

        @Test
        @DisplayName("경로가 없으면 빈 배열을 반환한다")
        void returnsEmptyWhenNoPathExists() {
            int[] path = aStar.aStar(
                    4,
                    new int[][]{
                            {0, 1, 1},
                            {1, 2, 1}
                    },
                    new int[]{2, 2, 2, 2},
                    2,
                    0
            );

            assertArrayEquals(new int[]{}, path);
        }

        @Test
        @DisplayName("목표 정점을 찾지 못해도 시작 정점 유효성이 맞아야 한다")
        void throwsWhenStartOutOfRange() {
            assertThrows(IllegalArgumentException.class, () ->
                    aStar.aStar(
                            3,
                            new int[][]{
                                    {0, 1, 1},
                                    {1, 2, 1}
                            },
                            new int[]{0, 0, 0},
                            5,
                            2
                    )
            );
        }

        @Test
        @DisplayName("휴리스틱 길이와 정점 수가 일치하지 않으면 예외를 던진다")
        void throwsWhenHeuristicSizeMismatch() {
            assertThrows(IllegalArgumentException.class, () ->
                    aStar.aStar(
                            4,
                            new int[][]{
                                    {0, 1, 1},
                                    {1, 2, 1}
                            },
                            new int[]{0, 0},
                            0,
                            2
                    )
            );
        }
    }
}
