package topics.sorting;

/**
 * 정수 배열 정렬 전략 인터페이스.
 * <p>
 * 구현체는 입력 배열을 오름차순으로 정렬한 결과를 반환한다.
 * 입력 배열은 변경하지 않고, 정렬 결과를 담은 새로운 배열을 반환한다.
 * </p>
 */
public interface Sort {
    /**
     * 배열을 오름차순으로 정렬한다.
     *
     * @param array 정렬 대상 배열 (null 허용하지 않음)
     * @return 정렬된 새 배열 (입력 배열과 다른 참조)
     * @throws IllegalArgumentException {@code array}가 null인 경우
     */
    int[] sort(int[] array);
}
