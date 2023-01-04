package lotto.controller;

import lotto.constant.Constants;
import lotto.model.Lottos;
import lotto.model.Ranking;
import lotto.model.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Winner winner = new Winner();

    public void start() {
        int money = inputView.receiveMoneyUserInput();
        Lottos lottos = new Lottos(money / Constants.THOUSAND);
        outputView.printNumberOfLottos(lottos);
        outputView.printLottos(lottos);

        List<Integer> winNumbers = inputView.receiveWinLottoNumbers();
        int bonusNumber = inputView.receiveWinBonusNumber(winNumbers);

        List<Ranking> rankings = lottos.getRankings(winNumbers, bonusNumber);
        Map<Ranking, Integer> rankingResult = winner.rankingCount(rankings);

        outputView.printStatistic(rankingResult);
        outputView.printRevenue(winner.revenue(rankingResult, money));
    }
}
