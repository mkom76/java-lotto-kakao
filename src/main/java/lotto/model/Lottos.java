package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 구매한 로또 객체들을 관리하는 클래스입니다.
 */
public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int numberOfLottos) {
        addRandom(numberOfLottos);
    }

    private void addRandom(int numberOfLottos) {
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottosReadOnly = new ArrayList<>(lottos);
        return lottosReadOnly;
    }

    public List<Ranking> getRankings(List<Integer> winNumbers, int bonus) {
        final List<Ranking> rankings = new ArrayList<>();
        for(Lotto lotto: lottos){
            rankings.add(lotto.checkWin(winNumbers, bonus));
        }
        return Collections.unmodifiableList(rankings);
    }
}
