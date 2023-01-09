package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WinLottoTest {
    @Test
    void checkDuplicatedLottoAndBonus() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WinLotto winLotto = new WinLotto(lotto, bonusNumber);
        });
    }
}
