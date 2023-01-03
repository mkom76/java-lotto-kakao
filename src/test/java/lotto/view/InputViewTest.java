package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void checkThousandUnit() {
        String input = "10000";
        systemIn(input);
        Assertions.assertEquals(inputView.receiveMoneyUserInput(), 10000);
    }
    @Test
    void checkNotThousandUnit() {
        String input = "12345\n";
        systemIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveMoneyUserInput();
        });
    }

    @Test
    void checkStringInput() {
        String input = "abcde\n";
        systemIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveMoneyUserInput();
        });
    }

    @Test
    void checkLastLottoNumbers(){
        String input = "1,2,3,4,5,6\n";
        systemIn(input);
        Assertions.assertEquals(inputView.receiveLastLottoNumbers(), Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void checkLastLottoNumbersDuplicate(){
        String input = "1,2,3,4,5,5\n";
        systemIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers();
        });
    }

    @Test
    void checkLastLottoNumbersWrongSize(){
        String input = "1,2,3,4,5\n";
        systemIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers();
        });
    }

    @Test
    void checkLastLottoNumbersString(){
        String input = "1,2,3,4,5,5\n";
        systemIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.receiveLastLottoNumbers();
        });
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
