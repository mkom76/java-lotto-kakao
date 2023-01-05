package lotto.controller;

import lotto.constant.Constants;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        // 사용자에게 돈을 입력받은 후 lottos(로또들) 생성
        int money = inputView.receiveMoneyUserInput();
        Lottos lottos = new Lottos(money / Constants.THOUSAND);
        outputView.printLottos(lottos);

        // 사용자에게 당첨번호를 입력받은 후 winlotto(당첨번호) 생성
        List<Integer> winNumbers = inputView.receiveWinLottoNumbers();
        int bonusNumber = inputView.receiveWinBonusNumber(winNumbers);
        WinLotto winLotto = new WinLotto(new Lotto(winNumbers), new BonusNumber(bonusNumber));

        // 구매한 로또들의 ranking 계산
        RankingResult rankingResult = new RankingResult(lottos.getRankings(winLotto));

        // 각 ranking에 해당하는 로또 개수 총 수익률 출력
        outputView.printStatistic(rankingResult.getRankingResult());
        outputView.printRevenue(rankingResult.calculateRevenue(money));
    }
}
