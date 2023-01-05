package lotto.model;

import lotto.constant.Constants;
import lotto.utils.RandomNumbersGenerator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 번호를 가지는 일급객체입니다.
 */
public class Lotto {
    private final List<Integer> lotto;

    public Lotto() {
        this(RandomNumbersGenerator.generateRandomNumbers());
    }

    public Lotto(List<Integer> lotto) {
        checkRangeAll(lotto);
        checkSize(lotto);
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    private void checkRangeAll(List<Integer> lotto) {
        for (int num : lotto) {
            checkRange(num);
        }
    }

    private void checkRange(int num) {
        if (num < Constants.LOTTO_MIN_NUM || num > Constants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또번호는 1~45 사이여야 합니다.");
        }
    }

    private void checkSize(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    public List<Integer> getLotto() {
        List<Integer> lottoReadOnly = new ArrayList<>(lotto);   // 방어적 복사
        return Collections.unmodifiableList(lottoReadOnly);
    }

    public Ranking checkWin(List<Integer> winNumbers, int bonus) {
        int matchedNum = lotto.stream()
                .filter(winNumbers::contains)
                .collect(Collectors.toSet())
                .size();
        if (matchedNum == 5) {
            return Ranking.findRanking(matchedNum, checkBonus(bonus));
        }
        return Ranking.findRanking(matchedNum, false);
    }

    private boolean checkBonus(int bonus) {
        return lotto.contains(bonus);
    }
}
