package lotto;

import lotto.controller.LottoController;

import java.util.Arrays;
import java.util.List;

public class Application {
    static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        lottoController.start();
    }
}
