package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class LottoTest {
    @Test
    @DisplayName("로또 생성 확인")
    void checkLottoMaker() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5,6), lotto.getLotto());
    }

    @Test
    @DisplayName("로또 생성 순서 상관 확인")
    void checkLottoMakerSorted() {
        Lotto lotto = new Lotto(Arrays.asList(3,4,5,6,1,2));
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5,6), lotto.getLotto());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;1",
            "1,2,3,4,5,7;2",
            "1,2,3,4,5,8;3",
            "1,2,3,4,8,9;4",
            "1,2,3,8,9,10;5",
            "1,2,8,9,10,11;6"}, delimiter = ';')
    void checkLottoWin(String input, String expect){
        List<Integer> numbers = Arrays.stream(input.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        List<Integer> winNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        Lotto lotto = new Lotto(numbers);
        Assertions.assertEquals(lotto.checkWin(winNumbers, bonus), Integer.parseInt(expect));
    }

}