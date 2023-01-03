package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

import java.util.Arrays;

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

    @Test
    void checkLastLottoNumbers(){
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,6";
        Assertions.assertEquals(inputView.receiveLastLottoNumbers(input), Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void checkLastLottoNumbersDuplicate(){
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers(input);
        });
    }

    @Test
    void checkLastLottoNumbersWrongSize(){
        InputView inputView = new InputView();
        String input = "1,2,3,4,5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers(input);
        });
    }

    @Test
    void checkLastLottoNumbersString(){
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers(input);
        });
    }
}
