package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public int checkWin(List<Integer> winNumbers, int bonus) {
        int matchedNum = lotto.stream()
                .filter(winNumbers::contains)
                .collect(Collectors.toSet())
                .size();
        return checkRank(matchedNum, bonus);
    }

    private int checkRank(int matchedNum, int bonus){
        if(matchedNum == 3){
            return 5;
        }
        if(matchedNum == 4){
            return 4;
        }
        if(matchedNum == 5){
            return checkBonus(bonus);
        }
        if(matchedNum == 6){
            return 1;
        }
        return 6;
    }

    private int checkBonus(int bonus){
        if(lotto.contains(bonus)){
            return 2;
        }
        return 3;
    }
}
