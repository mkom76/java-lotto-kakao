package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

class LottoTest {
    final static List<Integer> DUMMY_LIST = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void checkImmutable() {
        Lotto lotto = new Lotto(DUMMY_LIST);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            lotto.getLotto().add(7);
        });
    }

    @Test
    void checkLottoMaker() {
        Lotto lotto = new Lotto(DUMMY_LIST);
        Assertions.assertEquals(DUMMY_LIST, lotto.getLotto());
    }

    @Test
    void checkLottoMakerSorted() {
        Lotto lotto = new Lotto(Arrays.asList(3, 4, 5, 6, 1, 2));
        Assertions.assertEquals(DUMMY_LIST, lotto.getLotto());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;FIRST",
            "1,2,3,4,5,7;SECOND",
            "1,2,3,4,5,8;THIRD",
            "1,2,3,4,7,9;FOURTH",
            "1,2,3,8,9,10;FIFTH",
            "1,2,8,9,10,11;DEFAULT",
            "1,8,9,10,11,12,;DEFAULT",
            "8,9,10,11,12,13;DEFAULT"}, delimiter = ';')
    void checkLottoWin(String input, String expect) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Lotto lotto = new Lotto(numbers);
        WinLotto winLotto = new WinLotto(new Lotto(winNumbers), new BonusNumber(bonus));
        Assertions.assertEquals(lotto.checkWin(winLotto).name(), expect);
    }

}