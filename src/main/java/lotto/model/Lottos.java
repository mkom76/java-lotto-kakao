package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lottos {

    List<Lotto> lottos = new ArrayList<>();

    public Lottos(int input) {
        addRandom(input);
    }

    private void addRandom(int input) {
        for (int i = 0; i < input; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Ranking> getRankings(List<Integer> winNumbers, int bonus) {
        List<Ranking> rankings = new ArrayList<>();
        for(Lotto lotto: lottos){
            rankings.add(lotto.checkWin(winNumbers, bonus));
        }
        return rankings;
    }
}
