package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Ranking;

import java.util.Map;

public class OutputView {

    public void printNumberOfLottos(Lottos lottos){
        System.out.println(String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printStatistic(Map<Ranking, Integer> rankingResult){
        for (int i = Ranking.values().length -2 ; i >= 0  ; i--){
            System.out.print(Ranking.values()[i].getHowManyMatches());
            System.out.println(String.format("- %d개", rankingResult.get(Ranking.values()[i])));
        }
    }
}
