package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public void printNumberOfLottos(Lottos lottos){
        System.out.println(String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
    }
    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }
}
