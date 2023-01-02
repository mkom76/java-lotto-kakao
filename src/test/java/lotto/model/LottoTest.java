package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
}