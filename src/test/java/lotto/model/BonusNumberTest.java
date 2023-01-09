package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    BonusNumber bonusNumber;
    @Test
    void checkBonusNumberMaker() {
        int input = 1;
        bonusNumber = new BonusNumber(input);
        Assertions.assertEquals(bonusNumber.getBonusNumber(), 1);
    }

    @Test
    void checkOutRangeInput() {
        int input = 55;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bonusNumber = new BonusNumber(input);
        });
    }
}
