package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 구매한 로또 객체들을 관리하는 클래스입니다.
 */
public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int numberOfAutomatedLottos, List<List<Integer>> manualLottos) {
        addManualLottos(manualLottos);
        addRandom(numberOfAutomatedLottos);
    }

    private void addRandom(int numberOfLottos) {
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto());
        }
    }

    public void addManualLottos(List<List<Integer>> manualLottos) {
        for (List<Integer> manualLotto : manualLottos){
            lottos.add(new Lotto(manualLotto));
        }
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottosReadOnly = new ArrayList<>(lottos);
        return Collections.unmodifiableList(lottosReadOnly);
    }

    public List<Ranking> getRankings(WinLotto winLotto) {
        final List<Ranking> rankings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            rankings.add(lotto.checkWin(winLotto));
        }
        return Collections.unmodifiableList(rankings);
    }
}
