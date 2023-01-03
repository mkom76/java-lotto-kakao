package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Winner winner = new Winner();
    public void start(){
        int money = inputView.receiveMoneyUserInput();
        Lottos lottos = new Lottos(money / 1000);
        outputView.printNumberOfLottos(lottos);
        outputView.printLottos(lottos);
    }
}
