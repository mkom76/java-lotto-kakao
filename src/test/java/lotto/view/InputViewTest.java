package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

public class InputViewTest {

    @Test
    void checkThousandUnit() {
        InputView inputView = new InputView();
        String input = "10000";
        Assertions.assertEquals(inputView.receiveMoneyUserInput(input), 10000);
    }
    @Test
    void checkNotThousandUnit() {
        InputView inputView = new InputView();
        String input = "12345";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveMoneyUserInput(input);
        });
    }

    @Test
    void checkStringInput() {
        InputView inputView = new InputView();
        String input = "abcde";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveMoneyUserInput(input);
        });
    }
}
