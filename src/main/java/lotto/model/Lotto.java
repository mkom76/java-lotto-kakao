package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
