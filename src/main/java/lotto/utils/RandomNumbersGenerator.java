package lotto.utils;

import lotto.constant.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 랜덤 넘버를 만드는 유틸성 클래스입니다.
 * 1~45의 숫자를 리스트에 집어넣고, 셔플을 진행한 후 앞 6개의 요소를 잘라서 반환합니다.
 */
public class RandomNumbersGenerator {

    private final static List<Integer> INIT_LIST =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                    31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                    41, 42, 43, 44, 45);

    private RandomNumbersGenerator() {

    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(INIT_LIST);

        Collections.shuffle(numbers);
        return numbers.subList(0, Constants.LOTTO_SIZE);
    }
}
