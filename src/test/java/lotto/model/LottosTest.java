package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void checkSizeOfLottos() {
        int input = 10;
        Lottos lottos = new Lottos(input);
        Assertions.assertEquals(lottos.getLottos().size(), 10);
    }
}