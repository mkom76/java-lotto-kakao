package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Ranking;
import lotto.model.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Winner winner = new Winner();
    public void start(){
        int money = inputView.receiveMoneyUserInput();
        Lottos lottos = new Lottos(money / 1000);
        outputView.printNumberOfLottos(lottos);
        outputView.printLottos(lottos);

        List<Integer> winNumbers = inputView.receiveLastLottoNumbers();
        int bonusNumber = inputView.receiveLastLottoBonusNumber(winNumbers);

        List<Ranking> rankings = lottos.getRankings(winNumbers, bonusNumber);
        Map<Ranking, Integer> rankingResult = winner.rankingCount(rankings);

        outputView.printStatistic(rankingResult);


    }
}
