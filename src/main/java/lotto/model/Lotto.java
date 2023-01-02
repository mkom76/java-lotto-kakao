package lotto.model;

import lotto.utils.RandomNumbersGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    List<Integer> lotto;

    public Lotto() {
        this(RandomNumbersGenerator.generateRandomNumbers());
    }

    public Lotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Ranking checkWin(List<Integer> winNumbers, int bonus) {
        int matchedNum = lotto.stream()
                .filter(winNumbers::contains)
                .collect(Collectors.toSet())
                .size();
        return Ranking.findRanking(matchedNum, checkBonus(bonus));
    }

    private boolean checkBonus(int bonus){
        return lotto.contains(bonus);
    }
}
