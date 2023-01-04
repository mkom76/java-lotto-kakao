package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 랜덤 넘버를 만드는 유틸성 클래스입니다.
 * 1~45의 숫자를 리스트에 집어넣고, 셔플을 진행한 후 앞 6개의 요소를 잘라서 반환합니다.
 */
public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {

    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
